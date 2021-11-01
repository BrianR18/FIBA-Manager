package Collections;

import javax.print.attribute.HashDocAttributeSet;
import java.util.ArrayList;

public class BST<T,S extends Comparable<S>> implements IBST<T,S> {
    private BSTNode<T,S> root;


    @Override
    public void insert(T node, S key) {
        System.out.println("Se agregara "+key);
        BSTNode<T,S> nodeToAdd = new BSTNode<T,S>(node, key);
        if (root == null) {
            System.out.println("como raiz");
            root = nodeToAdd;
            root.setParent(null);
        } else {
            insert(root, nodeToAdd);
        }
    }

    private void insert(BSTNode<T,S> actualNode, BSTNode<T,S> nodeToAdd) {
        if ((actualNode.getKey().compareTo(nodeToAdd.getKey()))<=0) {
            if (actualNode.getRight() == null) {
                actualNode.setRight(nodeToAdd);
                nodeToAdd.setParent(actualNode);
                System.out.println("como hijo derecho de "+actualNode.getKey());
            } else {
                insert(actualNode.getRight(), nodeToAdd);
            }
        } else if ((actualNode.getKey().compareTo(nodeToAdd.getKey()))>=0) {
            if (actualNode.getLeft() == null) {
                actualNode.setLeft(nodeToAdd);
                nodeToAdd.setParent(actualNode);
                System.out.println("como hijo izquierdo de "+actualNode.getKey());
            } else {
                insert(actualNode.getLeft(), nodeToAdd);
            }
        }
    }


    @Override
    public ArrayList<T> search(S key) {
        ArrayList<T> valueFound = new ArrayList<>();
        if(isLeaf(root)) {
            if (root.getKey().compareTo(key)==0) {
                valueFound.add(root.getValue());
                return valueFound;
            } else {
                return null;
            }
        }else{
            return search(root, key, valueFound);
        }
    }

    private ArrayList<T> search(BSTNode<T,S> actual, S key, ArrayList<T> valueFound) {
            if (actual.getKey().compareTo(key) == 0 && isLeaf(actual)) {
                valueFound.add(actual.getValue());
                return valueFound;
            }else if (actual.getKey().compareTo(key) == 0) {
                valueFound.add(actual.getValue());
                if (actual.getRight() != null) {
                    search(actual.getRight(), key, valueFound);
                }
                if(actual.getLeft() != null){
                    search(actual.getLeft(), key, valueFound);
                }
            } else {
                if (actual.getRight() != null) {
                    search(actual.getRight(), key, valueFound);
                } if(actual.getLeft() != null){
                    search(actual.getLeft(), key, valueFound);
                }
            }
        return valueFound;
    }

    @Override
    public BSTNode<T,S> searchOneValue(S key) {
        if (root == null || root.getKey() == key) {
            return root;
        } else
            return searchOneValue(root, key);
    }

    private BSTNode<T,S> searchOneValue(BSTNode<T,S> actual, S key) {
        if (actual == null || actual.getKey() == key) {
            return actual;
        } else {
            if ((actual.getKey().compareTo(key))>0) {
                return searchOneValue(actual.getLeft(), key);
            } else {
                return searchOneValue(actual.getRight(), key);
            }
        }
    }



    @Override
    public void delete(BSTNode<T,S> keyToDelete){

        //Case 1
        if(keyToDelete.getLeft() == null && keyToDelete.getRight()==null){
            BSTNode<T,S> parent = keyToDelete.getParent();
            if(parent.getLeft()==keyToDelete){
                parent.setLeft(null);
            }else{
                parent.setRight(null);
            }
        }else{
            if(keyToDelete.getLeft()!=null && keyToDelete.getRight()!=null) {
                delete3(keyToDelete);
        	}else {
        		delete2(keyToDelete);
            }
        }
    }




    private void delete2(BSTNode<T,S> keyToDelete) {
        //Case 2
        BSTNode<T,S> parent = keyToDelete.getParent();
        if(parent.getRight()==keyToDelete) {
            if(keyToDelete.getLeft()!=null) {
                parent.setRight(keyToDelete.getLeft());
                keyToDelete.getLeft().setParent(parent);
                setNull(keyToDelete);
            }else {
                if(keyToDelete.getRight()!=null) {
                    parent.setRight(keyToDelete.getRight());
                    keyToDelete.getRight().setParent(parent);
                    setNull(keyToDelete);
                }
            }
        }else {
            if(parent.getLeft()==keyToDelete) {
                if(keyToDelete.getLeft()!=null) {
                    parent.setLeft(keyToDelete.getLeft());
                    keyToDelete.getLeft().setParent(parent);
                    setNull(keyToDelete);
                }else {
                    if(keyToDelete.getRight()!=null) {
                        parent.setLeft(keyToDelete.getRight());
                        keyToDelete.getRight().setParent(parent);
                        setNull(keyToDelete);
                    }
                }
            }
        }
    }

    private void delete3(BSTNode<T,S> keyToDelete) {
        //Case 3
        BSTNode<T, S> parent = keyToDelete.getParent();
        BSTNode<T, S> successor = getSuccessor(keyToDelete);
        if (parent.getRight() == keyToDelete) {
           parent.setRight(successor);
           successor.setLeft(keyToDelete.getLeft());
           successor.setParent(parent);
           successor.getLeft().setParent(successor);
           setNull(keyToDelete);
        }else{
            if(parent.getLeft()==keyToDelete){
                parent.setLeft(successor);
                successor.setLeft(keyToDelete.getLeft());
                successor.setParent(parent);
                successor.getLeft().setParent(successor);
                setNull(keyToDelete);
            }
        }
    }


    @Override
    public BSTNode<T,S> getSuccessor(BSTNode<T,S> value) {
        if(searchOneValue(value.getKey())!=null) {
            if (value.getRight() != null) {
                return getMinimum(value.getRight());
            } else {
                BSTNode<T, S> parent = value.getParent();
                while (parent != null && value == parent.getRight()) {
                    value = parent;
                    parent = parent.getParent();
                }
                return parent;
            }
        }return null;
    }

    @Override
    public BSTNode<T,S> getMinimum(BSTNode<T,S> value) {
        if(searchOneValue(value.getKey())!=null) {
            while (value.getLeft() != null) {
                value = value.getLeft();
            }
            return value;
        }return null;
    }

    @Override
    public BSTNode<T,S> getMaximum(BSTNode<T,S> value){
        if(searchOneValue(value.getKey())!=null) {
            while (value.getRight() != null) {
                value = value.getRight();
            }
            return value;
        }return null;
    }

    @Override
    public boolean isLeaf(BSTNode<T,S> key){

        return key.getRight() == null && key.getLeft() == null;
    }

    @Override
    public boolean isEmpty(){
        return root==null;
    }

    @Override
    public int bstHeight(BSTNode<T,S> root) {
        if(root==null){
            return 0;
        }else{
            return 1+ Math.max(bstHeight(root.getLeft()),bstHeight(root.getRight()));
        }
    }

    public void setRoot(BSTNode<T,S> root){
        this.root = root;
        this.root.setParent(null);
    }

    public BSTNode<T, S> getRoot() {
        return root;
    }

    private void setNull(BSTNode<T,S> value){
        value.setParent(null);
        value.setValue(null);
        value.setLeft(null);
        value.setRight(null);
        value.setKey(null);
        value = null;
    }

}
