package Test;

import Collections.BBT;
import org.junit.Test;

import static org.junit.Assert.*;

public class BBTTest {

    public <T,S extends Comparable<S>> BBT<T,S> setupStage1(){
        return new BBT<T,S>();
    }


    @Test
    public void insertTest(){
        //Testing left rotate, imagen caso a
        BBT<String, Integer> tree = setupStage1();
        tree.insert("a",5);
        tree.insert("b",4);
        tree.insert("e",8);
        tree.insert("c",7);
        tree.insert("d",9);
        tree.insert("g",10);
        assertEquals("e",tree.getRoot().getValue());
        assertEquals("a",tree.getRoot().getLeft().getValue());
        assertEquals("c",tree.searchOneValue(5).getRight().getValue());
        assertEquals("d",tree.getRoot().getRight().getValue());
        assertNull(tree.searchOneValue(9).getLeft());

        //Testing right rotate, imagen caso b
        BBT<String, Integer> tree2 = setupStage1();
        tree2.insert("a",7);
        tree2.insert("b",4);
        tree2.insert("e",9);
        tree2.insert("c",3);
        tree2.insert("d",6);
        tree2.insert("g",1);
        assertEquals("b",tree2.getRoot().getValue());
        assertEquals("c",tree2.getRoot().getLeft().getValue());
        assertEquals("a",tree2.getRoot().getRight().getValue());
        assertEquals("d",tree2.searchOneValue(7).getLeft().getValue());
        assertNull("c",tree2.searchOneValue(3).getRight());



    }


    @Test
    public void deleteTest(){
        //imagen eliminar caso c
        BBT<String, Integer> tree = setupStage1();
        tree.insert("h",9);
        tree.insert("b",6);
        tree.insert("m",12);
        tree.insert("a",5);
        tree.insert("d",8);
        tree.insert("c",7);
        tree.delete(tree.searchOneValue(9));
        tree.delete(tree.searchOneValue(12));
        assertEquals("b",tree.getRoot().getValue());
        assertEquals("a",tree.getRoot().getLeft().getValue());
        assertEquals("d",tree.getRoot().getRight().getValue());

        //imagen eliminar caso
        BBT<String, Integer> tree2 = setupStage1();
        tree2.insert("a",7);
        tree2.insert("b",4);
        tree2.insert("e",9);
        tree2.insert("c",3);
        tree2.insert("d",6);
        tree2.insert("g",1);
        assertEquals("b", tree.getRoot().getValue());
        /*tree2.delete(tree.searchOneValue(3));
        tree2.delete(tree.searchOneValue(1));
        assertEquals("a",tree2.getRoot().getValue());
        assertEquals("b",tree2.getRoot().getLeft().getValue());
        assertEquals("e",tree2.getRoot().getRight().getValue());
        assertEquals("d",tree2.searchOneValue(4).getRight().getValue());

         */


    }
}