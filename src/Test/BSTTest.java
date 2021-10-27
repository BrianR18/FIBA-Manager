package Test;
import Collections.BST;
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
        assertEquals("c", bst.getSuccessor(bst.getRoot()).getValue());
        assertNotEquals("f", bst.getSuccessor(bst.getRoot()).getValue());
        assertEquals("f", bst.getSuccessor(bst.search(8)).getValue());
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

    @Test
    public void deleteTest2() {
//      Testing case 2
        BST<String,Integer> tree = setupStage1();
        tree.insert("a",5);
        tree.insert("b",7);
        tree.insert("c",6);
        tree.insert("d",2);
        tree.insert("e",4);
        tree.insert("f",1);
        assertEquals(tree.getRoot(), tree.search(5));
        assertEquals(tree.search(5),tree.search(7).getParent());
        assertEquals(tree.search(6), tree.search(7).getLeft());
        assertNull(tree.search(7).getRight());
        tree.delete(tree.search(7));
        assertNull(tree.search(7));
        assertEquals(tree.search(6).getValue(), tree.search(5).getRight().getValue());
        assertEquals(tree.search(5),tree.search(6).getParent());
    }

    @Test
    public void deleteTest3() {
//      Testing case 2
        BST<String,Integer> tree = setupStage1();
        tree.insert("a",5);
        tree.insert("b",7);
        tree.insert("c",6);
        tree.insert("d",2);
        tree.insert("e",4);
        tree.insert("f",1);
        tree.insert("g",8);

        //Deleting key 7, this node has two children
        tree.delete(tree.search(7));
        assertNull(tree.search(7));
        assertNotNull(tree.search(5).getRight());
        assertEquals(tree.search(8).getValue(), tree.search(5).getRight().getValue());
        assertNull(tree.search(8).getRight());
        assertNotNull(tree.search(8).getLeft());
        assertEquals(tree.search(6).getValue(),tree.search(8).getLeft().getValue());
        assertEquals(tree.search(5).getValue(),tree.search(8).getParent().getValue());
        assertEquals(tree.search(8).getValue(),tree.search(6).getParent().getValue());
        //Deleting key 2, this node has two children
        tree.delete(tree.search(2));
        assertNull(tree.search(2));
        assertNotNull(tree.search(5).getLeft());
        assertEquals(tree.search(4).getValue(), tree.search(5).getLeft().getValue());
        assertNull(tree.search(4).getRight());
        assertNotNull(tree.search(4).getLeft());
        assertEquals(tree.search(1).getValue(),tree.search(4).getLeft().getValue());
        assertEquals(tree.search(5).getValue(),tree.search(4).getParent().getValue());
        assertEquals(tree.search(4).getValue(),tree.search(1).getParent().getValue());

       //Deleting  key 4, this node has one child---> Testing case 2
        tree.delete(tree.search(4));
        assertNull(tree.search(2));
        assertEquals(tree.search(1).getValue(),tree.search(5).getLeft().getValue());
        assertEquals(tree.search(5).getValue(),tree.search(1).getParent().getValue());

        //Deleting key 1, this node has not child
        tree.delete(tree.search(1));
        assertNull(tree.search(1));
        assertNull(tree.search(5).getLeft());
    }
}
