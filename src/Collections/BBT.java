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
            super.getRoot().setParent(super.getRoot());
        } else {
            insert(super.getRoot(), nodeToAdd);
        }
    }//End insert

    private void insert(BSTNode<T,S> actualNode, BSTNode<T,S> nodeToAdd) {
        if ((actualNode.getKey().compareTo(nodeToAdd.getKey()))<0) {
            if (actualNode.getRight() == null) {
                actualNode.setRight(nodeToAdd);
                nodeToAdd.setParent(actualNode);
                if(Math.abs(balanceFactor(actualNode)) > 1)
                    rebalanced(actualNode);
            } else {
                insert(actualNode.getRight(), nodeToAdd);
            }
        } else {
            if (actualNode.getLeft() == null) {
                actualNode.setLeft(nodeToAdd);
                nodeToAdd.setParent(actualNode);
            } else {
                insert(actualNode.getLeft(), nodeToAdd);
            }
        }//End else
    }//End insert

    @Override
    public void delete(BSTNode<T,S> keyToDelete){
        BSTNode<T,S> p = keyToDelete.getParent();
        if(super.isLeaf(keyToDelete)){
            if(p == keyToDelete){super.setRoot(null);}
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

    public int balanceFactor(BSTNode<T,S> subTreeRoot){
        int bf = 0;
        if(!super.isLeaf(subTreeRoot)){
            int rh = (subTreeRoot.getRight()!= null)?super.bstHeight(subTreeRoot.getRight()):0;
            int lh = (subTreeRoot.getLeft()!= null)?super.bstHeight(subTreeRoot.getLeft()):0;
            bf = rh - lh;
        }//end if
        return bf;
    }//End balanceFactor

    public void rightRotate(BSTNode<T,S> subTreeRoot){
        BSTNode<T,S> aux = subTreeRoot;
        subTreeRoot = subTreeRoot.getLeft();
        aux.setLeft(subTreeRoot.getRight());
        subTreeRoot.setRight(aux);
    }//rightRotate

    public void leftRotate(BSTNode<T,S> subTreeRoot){
        BSTNode<T,S> aux = subTreeRoot;
        subTreeRoot = subTreeRoot.getRight();
        aux.setRight(subTreeRoot.getLeft());
        subTreeRoot.setLeft(aux);
    }//rightRotate

    public void rebalanced(BSTNode<T,S> subTreeRoot){
        int Rfb = balanceFactor(subTreeRoot);
        if(Rfb < -1 || Rfb > 1){
            int lfb = balanceFactor(subTreeRoot.getLeft());
            int rfb = balanceFactor(subTreeRoot.getRight());
            if(Rfb == 2 && rfb != -1){leftRotate(subTreeRoot);}
            else if(Rfb == 2 && rfb == -1){
                rightRotate(subTreeRoot.getRight());
                leftRotate(subTreeRoot);
            }else if(Rfb == -2 && lfb != 1){rightRotate(subTreeRoot);}
            else if(Rfb == -2 && lfb == 1){
                leftRotate(subTreeRoot.getLeft());
                rightRotate(subTreeRoot);
            }//End else..if
            if(subTreeRoot.getParent()!= subTreeRoot)
                rebalanced(subTreeRoot.getParent());
        }//End if
    }//End rebalanced
}//End Balance binary tree
