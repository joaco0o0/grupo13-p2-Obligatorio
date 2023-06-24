package uy.edu.um.adt.tests.MyHash;
import org.junit.Test;
import uy.edu.um.adt.TADS.MyHash.MyHashImpl;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

public class MyHashTests {
    @Test
    public void inserttest(){
        MyHashImpl<Integer,Integer> hash = new MyHashImpl<>(4);
        hash.put(1,2);
        hash.put(2,3);
        hash.put(3,4);
        hash.put(4,5);
        assertTrue(hash.get(1)==2 && hash.get(2)==3 && hash.get(3)==4 && hash.get(4)==5);
    }
    @Test
    public void findtest(){
        MyHashImpl<Integer,Integer> hash = new MyHashImpl<>(4);
        hash.put(1,2);
        hash.put(2,3);
        hash.put(3,4);
        hash.put(4,5);
        assertTrue(hash.get(1)==2 && hash.get(2)==3 && hash.get(3)==4 && hash.get(4)==5);
    }
    @Test
    public void deletetest(){
        MyHashImpl<Integer,Integer> hash = new MyHashImpl<>(4);
        hash.put(1,2);
        hash.put(2,3);
        hash.put(3,4);
        hash.put(4,5);
        hash.remove(1);
        hash.remove(4);
        assertTrue(hash.get(1)==null && hash.get(4)==null);
        assertFalse(hash.containsKey(1) && hash.containsKey(4));
        assertTrue(hash.get(2)==3 && hash.get(3)==4);
    }
    @Test
    public void containstest(){
        MyHashImpl<Integer,Integer> hash = new MyHashImpl<>(4);
        hash.put(1,2);
        hash.put(2,3);
        hash.put(3,4);
        hash.put(4,5);
        assertTrue(hash.containsKey(1) && hash.containsKey(2) && hash.containsKey(3) && hash.containsKey(4));
    }

    @Test
    public void sizetest(){
        MyHashImpl<Integer,Integer> hash = new MyHashImpl<>(4);
        hash.put(1,2);
        hash.put(2,3);
        hash.put(3,4);
        hash.put(4,5);
        assertTrue(hash.size()==4);
    }

    @Test
    public void gettest(){
        MyHashImpl<Integer,Integer> hash = new MyHashImpl<>(4);
        hash.put(1,2);
        hash.put(2,3);
        hash.put(3,4);
        hash.put(4,5);
        assertTrue(hash.get(1)==2 && hash.get(2)==3 && hash.get(3)==4 && hash.get(4)==5);
    }
}
