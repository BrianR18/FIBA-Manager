package Test;
import Collections.BST;
import org.junit.Test;

import java.util.ArrayList;

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
            bst.insert("a",5);
            bst.insert("b",7);
            bst.insert("c",6);
            bst.insert("d",5);
            bst.insert("e",4);
            bst.insert("f",1);
            bst.insert("g",5);
            ArrayList<String> a = new ArrayList<>();
            a.add("a");a.add("d");a.add("g");
            assertEquals(a,bst.search(5));


    }

    @Test
    public void searchTest1(){
        BST<String,Integer> bst = setupStage1();
        bst.insert("a",45);
        bst.insert("b",15);
        bst.insert("d",15);
        bst.insert("e",15);
        bst.insert("f",15);
        ArrayList<String> a = new ArrayList<>();
        a.add("b");a.add("d");a.add("e");a.add("f");
        assertEquals(a,bst.search(15));
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
        assertEquals("f", bst.getSuccessor(bst.searchOneValue(8)).getValue());
    }

    @Test
    public void getMinimumTest(){
        BST<String,Integer> tree = setupStage1();
        tree.insert("a",3);
        tree.insert("b",4);
        tree.insert("c",5);

        assertEquals("a",tree.getMinimum(tree.searchOneValue(3)).getValue());
        assertNotEquals("c",tree.getMinimum(tree.searchOneValue(4)).getValue());
    }

    @Test
    public void getMaximumTest(){
        BST<String,Integer> tree = setupStage1();
        tree.insert("a",3);
        tree.insert("b",4);
        tree.insert("c",5);

        assertEquals("c",tree.getMaximum(tree.searchOneValue(5)).getValue());
        assertNotEquals("b",tree.getMaximum(tree.searchOneValue(3)).getValue());
    }

    @Test
    public void isLeafTest(){
        BST<String,Integer> tree = setupStage1();
        tree.insert("a",3);
        tree.insert("b",4);
        tree.insert("c",5);

        assertFalse(tree.isLeaf(tree.searchOneValue(3)));
        assertFalse(tree.isLeaf(tree.searchOneValue(4)));
        assertTrue(tree.isLeaf(tree.searchOneValue(5)));
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

        assertEquals(tree.searchOneValue(4),tree.searchOneValue(5).getParent());
        assertEquals(tree.searchOneValue(4),tree.searchOneValue(3).getParent());
        assertNotNull(tree.searchOneValue(4).getRight());
        assertNotNull(tree.searchOneValue(4).getLeft());
        tree.delete(tree.searchOneValue(5));
        assertNull(tree.searchOneValue(4).getRight());
        tree.delete(tree.searchOneValue(3));
        assertNull(tree.searchOneValue(4).getLeft());
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
        assertEquals(tree.getRoot(), tree.searchOneValue(5));
        assertEquals(tree.searchOneValue(5),tree.searchOneValue(7).getParent());
        assertEquals(tree.searchOneValue(6), tree.searchOneValue(7).getLeft());
        assertNull(tree.searchOneValue(7).getRight());
        tree.delete(tree.searchOneValue(7));
        assertNull(tree.searchOneValue(7));
        assertEquals(tree.searchOneValue(6).getValue(), tree.searchOneValue(5).getRight().getValue());
        assertEquals(tree.searchOneValue(5),tree.searchOneValue(6).getParent());
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
        tree.delete(tree.searchOneValue(7));
        assertNull(tree.searchOneValue(7));
        assertNotNull(tree.searchOneValue(5).getRight());
        assertEquals(tree.searchOneValue(8).getValue(), tree.searchOneValue(5).getRight().getValue());
        assertNull(tree.searchOneValue(8).getRight());
        assertNotNull(tree.searchOneValue(8).getLeft());
        assertEquals(tree.searchOneValue(6).getValue(),tree.searchOneValue(8).getLeft().getValue());
        assertEquals(tree.searchOneValue(5).getValue(),tree.searchOneValue(8).getParent().getValue());
        assertEquals(tree.searchOneValue(8).getValue(),tree.searchOneValue(6).getParent().getValue());
        //Deleting key 2, this node has two children
        tree.delete(tree.searchOneValue(2));
        assertNull(tree.searchOneValue(2));
        assertNotNull(tree.searchOneValue(5).getLeft());
        assertEquals(tree.searchOneValue(4).getValue(), tree.searchOneValue(5).getLeft().getValue());
        assertNull(tree.searchOneValue(4).getRight());
        assertNotNull(tree.searchOneValue(4).getLeft());
        assertEquals(tree.searchOneValue(1).getValue(),tree.searchOneValue(4).getLeft().getValue());
        assertEquals(tree.searchOneValue(5).getValue(),tree.searchOneValue(4).getParent().getValue());
        assertEquals(tree.searchOneValue(4).getValue(),tree.searchOneValue(1).getParent().getValue());

       //Deleting  key 4, this node has one child---> Testing case 2
        tree.delete(tree.searchOneValue(4));
        assertNull(tree.searchOneValue(2));
        assertEquals(tree.searchOneValue(1).getValue(),tree.searchOneValue(5).getLeft().getValue());
        assertEquals(tree.searchOneValue(5).getValue(),tree.searchOneValue(1).getParent().getValue());

        //Deleting key 1, this node has not child
        tree.delete(tree.searchOneValue(1));
        assertNull(tree.searchOneValue(1));
        assertNull(tree.searchOneValue(5).getLeft());
    }




}
