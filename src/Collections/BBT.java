package Collections;

public class BBT<T,S extends Comparable<S>> extends BST<T,S> {

    public BBT(){
        super();
    }//End BBT constructor

    @Override
    public void insert(T node, S key){

    }//End insert

    @Override
    public void delete(BSTNode<T,S> keyToDelete){

    }//End delete

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

    public void rebalanced(){

    }//End rebalanced
}//End Balance binary tree
