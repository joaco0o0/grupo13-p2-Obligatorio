package uy.edu.um.adt.tests.MyStack;

import org.junit.Assert;
import org.junit.Test;
import uy.edu.um.adt.TADS.MyLinkedList.MyLinkedList;

import static junit.framework.TestCase.assertTrue;

public class MyStackTest {
    @Test
    public void testpeekElement() {
        MyLinkedList list = new MyLinkedList<>();
        list.enqueue(1);
        list.enqueue(2);
        list.enqueue(3);
        Assert.assertEquals(1, list.peekElement());
    }

    @Test
    public void testpush() {
        MyLinkedList list = new MyLinkedList();
        list.push(1);
        list.push(2);
        list.push(3);
        assertTrue(list.size() == 3 && list.findPosition(1) == 0 && list.findPosition(2) == 1 && list.findPosition(3) == 2);
    }

    @Test
    public void testpop() {
        MyLinkedList list = new MyLinkedList();
        list.push(1);
        list.push(2);
        list.push(3);
        list.pop();
        assertTrue(list.size() == 2 && list.findPosition(1) == 0 && list.findPosition(2) == 1);
        list.pop();
        assertTrue(list.size() == 1 && list.findPosition(1) == 0);
        list.pop();
        assertTrue(list.size() == 0);
    }

    @Test
    public void testpeek() {
        MyLinkedList list = new MyLinkedList();
        list.push(1);
        list.push(2);
        list.push(3);
        Assert.assertEquals(3, list.peek());
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
    public void testsize() {
        MyLinkedList list = new MyLinkedList();
        assertTrue(list.size() == 0);
        list.add(1);
        list.add(2);
        list.add(3);
        assertTrue(list.size() == 3);
    }
}
