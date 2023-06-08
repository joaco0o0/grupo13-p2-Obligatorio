package uy.edu.um.adt.tests.MyLinkedList;
import org.junit.Assert;
import static junit.framework.TestCase.assertTrue;
import org.junit.Test;
import uy.edu.um.adt.TADS.MyLinkedList.MyLinkedList;

public class MyLinkedListTests {
    @Test
    public void testadd() {
        MyLinkedList list = new MyLinkedList();
        list.add(1);
        list.add(2);
        list.add(3);
        list.addAt(1, 4);
        list.addAt(0, 5);
        list.addAt(0, 6);
        assertTrue(list.size() == 6 && list.findPosition(1) == 2 && list.findPosition(2) == 4 && list.findPosition(3) == 5 && list.findPosition(4) == 3 && list.findPosition(5) == 1 && list.findPosition(6) == 0);
    }

    @Test
    public void testfindPosition() {
        MyLinkedList list = new MyLinkedList();
        list.add(1);
        list.add(2);
        list.add(3);
        list.addAt(1, 4);
        list.addAt(0, 5);
        assertTrue(list.findPosition(1) == 1 && list.findPosition(2) == 3 && list.findPosition(3) == 4 && list.findPosition(4) == 2 && list.findPosition(5) == 0);
    }

    @Test
    public void testisEmpty() {
        MyLinkedList list = new MyLinkedList();
        assertTrue(list.isEmpty());
        list.add(1);
        assertTrue(!list.isEmpty());

    }

    @Test
    public void testsize() {
        MyLinkedList list = new MyLinkedList();
        assertTrue(list.size() == 0);
        list.add(1);
        list.add(2);
        list.add(3);
        assertTrue(list.size() == 3);
    }

    @Test
    public void testremove() {
        MyLinkedList list = new MyLinkedList();
        list.add(1);
        list.add(2);
        list.add(3);
        list.remove(2);
        assertTrue(list.size() == 2 && list.findPosition(1) == 0 && list.findPosition(3) == 1);
        list.remove(3);
        assertTrue(list.size() == 1 && list.findPosition(1) == 0);
        list.remove(1);
        assertTrue(list.size() == 0);
    }

    @Test
    public void testclear() {
        MyLinkedList list = new MyLinkedList();
        list.add(1);
        list.add(2);
        list.add(3);
        list.clear();
        assertTrue(list.size() == 0);
    }

    @Test
    public void testcontains() {
        MyLinkedList list = new MyLinkedList();
        list.add(1);
        list.add(2);
        list.add(3);
        assertTrue(list.contains(1) && list.contains(2) && list.contains(3));
    }

    @Test
    public void testget() {
        MyLinkedList list = new MyLinkedList();
        list.add(1);
        list.add(2);
        list.add(3);
        Assert.assertEquals(1, list.get(0));
        Assert.assertEquals(2, list.get(1));
        Assert.assertEquals(3, list.get(2));
    }

    @Test
    public void testremoveWithIndex() {
        MyLinkedList list = new MyLinkedList();
        list.add(1);
        list.add(2);
        list.add(3);
        list.removeWithIndex(0);
        list.removeWithIndex(1);
        list.removeWithIndex(5);
        assertTrue(list.size() == 1);
        assertTrue(list.contains(2));
    }

}
