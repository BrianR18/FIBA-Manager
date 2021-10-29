package Collections;

import java.util.ArrayList;

public interface IBST<T,S>{
    public void insert(T node, S key);
    public ArrayList<T> search(S key);
    public BSTNode<T,S> searchOneValue(S key);
    public void delete(BSTNode<T,S> keyToDelete);
    public BSTNode<T,S> getSuccessor(BSTNode<T,S> value);
    public BSTNode<T,S> getMinimum(BSTNode<T,S> value);
    public BSTNode<T,S> getMaximum(BSTNode<T,S> value);
    public boolean isLeaf(BSTNode<T,S> key);
    public boolean isEmpty();
    public int bstHeight(BSTNode<T,S> root);
}
