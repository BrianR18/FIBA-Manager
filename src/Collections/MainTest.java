package Collections;

public class MainTest {
    public static void main(String[] args) {
        BBT<Integer,Integer> t = new BBT<Integer,Integer>();
        t.insert(4,4);
        t.insert(5,5);
        t.insert(6,6);
        System.out.println(t.isLeaf(t.search(4)));
        System.out.println(t.isLeaf(t.search(6)));
        System.out.println(t.getRoot().getValue());
    }
}
