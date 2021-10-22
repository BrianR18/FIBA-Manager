package Collections;
import org.junit.Test;

import static org.junit.Assert.*;

public class BSTTest {
    public <T,S extends Comparable<S>> BST<T,S> setupStage1(){
        return new BST<T,S>();
    }

    @Test
    public void insertTest() {

        BST<String, Integer> bst = setupStage1();
        bst.insert("a",3);

        bst.insert("b",2);
        bst.insert("c",8);
        assertEquals("a", bst.getRoot().getValue());
        assertEquals( "b" , bst.getRoot().getLeft().getValue());
        assertEquals("c", bst.getRoot().getRight().getValue());
    }

    @Test
    public void searchTest(){

        BST<String, Integer> bst = setupStage1();
        bst.insert("a",3);
        bst.insert("b",2);
        bst.insert("c",8);
        assertEquals("b", bst.search(2).getValue());
        assertEquals("a", bst.search(3).getValue());
        assertEquals("c", bst.search(8).getValue());
    }

    @Test
    public void getSuccessorTest(){

        BST<String, Integer> bst = setupStage1();
        bst.insert("a",3);
        bst.insert("b",2);
        bst.insert("c",8);
        bst.insert("f",18);
        assertEquals("a", bst.getRoot().getValue());
        assertEquals("c", bst.getSuccessor(bst.getRoot()));
        assertNotEquals("f", bst.getSuccessor(bst.getRoot()));
        assertEquals("f", bst.getSuccessor(bst.search(8)));
    }

    @Test
    public void getMinimumTest(){
        BST<String,Integer> tree = setupStage1();
        tree.insert("a",3);
        tree.insert("b",4);
        tree.insert("c",5);

        assertEquals("a",tree.getMinimum(tree.search(3)).getValue());
        assertNotEquals("c",tree.getMinimum(tree.search(4)).getValue());
    }

    @Test
    public void getMaximumTest(){
        BST<String,Integer> tree = setupStage1();
        tree.insert("a",3);
        tree.insert("b",4);
        tree.insert("c",5);

        assertEquals("c",tree.getMaximum(tree.search(5)).getValue());
        assertNotEquals("b",tree.getMaximum(tree.search(3)).getValue());
    }

    @Test
    public void isLeafTest(){
        BST<String,Integer> tree = setupStage1();
        tree.insert("a",3);
        tree.insert("b",4);
        tree.insert("c",5);

        assertFalse(tree.isLeaf(tree.search(3)));
        assertFalse(tree.isLeaf(tree.search(4)));
        assertTrue(tree.isLeaf(tree.search(5)));
    }

    @Test
    public void isEmptyTest(){
        BST<String,Integer> tree = setupStage1();
        tree.insert("a",3);
        assertFalse(tree.isEmpty());
        BST<String,Integer> tree2 = setupStage1();
        assertTrue(tree2.isEmpty());
    }

    @Test
    public void bstHeightTest(){
        BST<String,Integer> tree = setupStage1();
        tree.insert("a",3);
        tree.insert("b",4);
        tree.insert("c",5);


        assertEquals(3,tree.bstHeight(tree.getRoot()));
        tree.insert("a",6);
        assertEquals(4,tree.bstHeight(tree.getRoot()));

    }

    @Test
    public void deleteTest(){
        BST<String,Integer> tree = setupStage1();
        tree.insert("a",1);
        tree.insert("b",4);
        tree.insert("c",5);
        tree.insert("f",3);

        assertEquals(tree.search(4),tree.search(5).getParent());
        assertEquals(tree.search(4),tree.search(3).getParent());
        assertNotNull(tree.search(4).getRight());
        assertNotNull(tree.search(4).getLeft());
        tree.delete(tree.search(5));
        assertNull(tree.search(4).getRight());
        tree.delete(tree.search(3));
        assertNull(tree.search(4).getLeft());
    }

}
