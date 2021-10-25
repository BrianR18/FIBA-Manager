package Collections;

public class BBT<T,S extends Comparable<S>> extends BST<T,S> {

    public BBT(){
        super();
    }//End BBT constructor

    @Override
    public void insert(T node, S key){
        BSTNode<T,S> nodeToAdd = new BSTNode<T,S>(node, key);
        if (super.getRoot() == null) {
            super.setRoot(nodeToAdd);
            super.getRoot().setParent(null);
        } else {
            insert(super.getRoot(), nodeToAdd);
        }
    }//End insert

    private void insert(BSTNode<T,S> currentNode, BSTNode<T,S> nodeToAdd) {
        if ((currentNode.getKey().compareTo(nodeToAdd.getKey()))<0) {
            if (currentNode.getRight() == null) {
                currentNode.setRight(nodeToAdd);
                nodeToAdd.setParent(currentNode);
                rebalanced(currentNode.getParent());
            } else {
                insert(currentNode.getRight(), nodeToAdd);
            }
        } else {
            if (currentNode.getLeft() == null) {
                currentNode.setLeft(nodeToAdd);
                nodeToAdd.setParent(currentNode);
            } else {
                insert(currentNode.getLeft(), nodeToAdd);
            }
        }//End else
    }//End insert

    @Override
    public void delete(BSTNode<T,S> keyToDelete){
        BSTNode<T,S> p = keyToDelete.getParent();
        if(super.isLeaf(keyToDelete)){
            if(p == null){super.setRoot(null);}
            else if(p.getLeft() == keyToDelete ){p.setLeft(null);}
            else {p.setRight(null);}
        }else if(keyToDelete.getLeft() == null || keyToDelete.getRight() == null){
            BSTNode<T,S> newChildren = (keyToDelete.getLeft() != null)?keyToDelete.getLeft():keyToDelete.getRight();
            if(p.getLeft() == keyToDelete){ p.setLeft(newChildren);}
            else {p.setRight(newChildren);}
            newChildren.setParent(p);
        }else{
            BSTNode<T,S> newRoot = (getNewRoot(keyToDelete.getLeft()));
            if(p.getLeft() == keyToDelete){ p.setLeft(newRoot);}
            else {p.setRight(newRoot);}
            newRoot.setParent(p);
        }//End else
        if(p != null && Math.abs(balanceFactor(p)) > 1 )
            rebalanced(p);
    }//End delete

    private BSTNode<T,S> getNewRoot(BSTNode<T,S> currentRoot){
        if(currentRoot.getRight() == null){
            return currentRoot;
        }else
            return getNewRoot(currentRoot.getRight());
    }//End getNewRoot

    private int balanceFactor(BSTNode<T,S> subTreeRoot){
        int bf = 0;
        if(subTreeRoot != null && !super.isLeaf(subTreeRoot)){
            int rh = (subTreeRoot.getRight()!= null)?super.bstHeight(subTreeRoot.getRight()):0;
            int lh = (subTreeRoot.getLeft()!= null)?super.bstHeight(subTreeRoot.getLeft()):0;
            bf = rh - lh;
        }//end if
        return bf;
    }//End balanceFactor

    private void rightRotate(BSTNode<T,S> subTreeRoot){
        BSTNode<T,S> p = subTreeRoot.getParent();
        if(p != null){//If subTreeRoot isn't the tree root
            rightRotateNotRoot(subTreeRoot,p);
        }else{
            BSTNode<T,S>  y = super.getRoot().getLeft();
            super.setRoot(y);
            if(y.getRight() != null){
                subTreeRoot.setLeft(y.getRight());
                subTreeRoot.getLeft().setParent(subTreeRoot);
            }else
                subTreeRoot.setLeft(null);
            super.getRoot().setRight(subTreeRoot);
            subTreeRoot.setParent(y);
        }//End if..else
    }//rightRotate

    private void leftRotate(BSTNode<T,S> subTreeRoot){
        BSTNode<T,S> p = subTreeRoot.getParent();
        if(p != null){//If subTreeRoot isn't the tree root
            leftRotateNotRoot(subTreeRoot,p);
        }else{
            BSTNode<T,S>  y = super.getRoot().getRight();
            super.setRoot(y);
            if(y.getLeft() != null){
                subTreeRoot.setRight(y.getLeft());
                subTreeRoot.getRight().setParent(subTreeRoot);
            }else
                subTreeRoot.setRight(null);
            super.getRoot().setLeft(subTreeRoot);
            subTreeRoot.setParent(y);
        }//End if..else
    }//rightRotate

    private void leftRotateNotRoot(BSTNode<T,S> subTreeRoot, BSTNode<T,S> subTreeParent){
        boolean direction = subTreeParent.getLeft() == subTreeRoot;
        if(direction){subTreeParent.setLeft(subTreeRoot.getRight());}
        else{subTreeParent.setRight(subTreeRoot.getRight());}
        subTreeRoot.getRight().setParent(subTreeParent);
        subTreeRoot.setRight(subTreeRoot.getRight().getLeft());
        subTreeRoot.getRight().setParent(subTreeRoot);
        if(direction){
            subTreeParent.getLeft().setLeft(subTreeRoot);
            subTreeRoot.setParent(subTreeParent.getLeft());
        } else{
            subTreeParent.getRight().setLeft(subTreeRoot);
            subTreeRoot.setParent(subTreeParent.getRight());
        }//End if..else
    }//End leftRotateNotRoot

    private void rightRotateNotRoot(BSTNode<T,S> subTreeRoot, BSTNode<T,S> subTreeParent){
        boolean direction = subTreeParent.getLeft() == subTreeRoot;
        if(direction){subTreeParent.setLeft(subTreeRoot.getLeft());}
        else{subTreeParent.setRight(subTreeRoot.getLeft());}
        subTreeRoot.getLeft().setParent(subTreeParent);
        subTreeRoot.setLeft(subTreeRoot.getLeft().getRight());
        subTreeRoot.getLeft().setParent(subTreeRoot);
        if(direction){
            subTreeParent.getLeft().setRight(subTreeRoot);
            subTreeRoot.setParent(subTreeParent.getRight());
        } else{
            subTreeParent.getRight().setRight(subTreeRoot);
            subTreeRoot.setParent(subTreeParent.getLeft());
        }//End if..else
    }//End rightRotateNotRoot

    private void rebalanced(BSTNode<T,S> subTreeRoot) {
        int bf = balanceFactor(subTreeRoot);
        if(bf < -1 || bf > 1){
            if(bf == 2){//case unbalanced on right node
                int rbf = balanceFactor(subTreeRoot.getRight());
                if(rbf == 0 || rbf == 1)
                    leftRotate(subTreeRoot);
                else{
                    rightRotate(subTreeRoot.getRight());
                    leftRotate(subTreeRoot);
                }//End else
            }else{//case unbalanced on left node
                int lbf = balanceFactor(subTreeRoot.getLeft());
                if(lbf == 0 || lbf == -1)
                    rightRotate(subTreeRoot);
                else{
                    leftRotate(subTreeRoot.getLeft());
                    rightRotate(subTreeRoot);
                }//End else
            }//End case unbalanced on left node
        }//End if subtree unbalanced
    }//End rebalanced
}//End Balance binary tree
