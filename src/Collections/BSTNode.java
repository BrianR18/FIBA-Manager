package Collections;

public class BSTNode<T,S>{
    private T value;
    private BSTNode<T,S> right;
    private BSTNode<T,S> left;
    private BSTNode<T,S> parent;
    private S key;

    public BSTNode(T value, S key){
        this.value = value;
        right = null;
        left = null;
        parent = null;
        this.key = key;
    }


    public T getValue() {return value;}
    public void setValue(T node) {this.value = node;}

    public BSTNode<T,S> getRight() {return right;}
    public void setRight(BSTNode<T,S> right) {this.right = right;}

    public BSTNode<T,S> getLeft() {return left;}
    public void setLeft(BSTNode<T,S> left) {this.left = left;}

    public S getKey() {return key;}
    public void setKey(S key){this.key = key;}

    public BSTNode<T,S> getParent() {return parent;}
    public void setParent(BSTNode<T,S> parent) {this.parent = parent;}

}
