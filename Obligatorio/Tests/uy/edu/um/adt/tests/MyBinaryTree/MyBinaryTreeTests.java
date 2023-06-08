package uy.edu.um.adt.tests.MyBinaryTree;
import org.junit.Test;
import uy.edu.um.adt.TADS.MyBinaryTree.MyBinarySearchTreeImpl;
import static junit.framework.TestCase.assertTrue;

public class MyBinaryTreeTests {
    @Test
    public void inserttest(){
        MyBinarySearchTreeImpl<Integer,Integer> tree = new MyBinarySearchTreeImpl<>();
        tree.insert(1,2);
        tree.insert(2,3);
        tree.insert(3,4);
        tree.insert(4,5);
        assertTrue(tree.find(1)==2 && tree.find(2)==3 && tree.find(3)==4 && tree.find(4)==5);

    }
    @Test
    public void findtest(){
        MyBinarySearchTreeImpl<Integer,Integer> tree = new MyBinarySearchTreeImpl<>();
        tree.insert(1,2);
        tree.insert(2,3);
        tree.insert(3,4);
        tree.insert(4,5);
        assertTrue(tree.find(1)==2 && tree.find(2)==3 && tree.find(3)==4 && tree.find(4)==5);
    }
    @Test
    public void deletetest(){
        MyBinarySearchTreeImpl<Integer,Integer> tree = new MyBinarySearchTreeImpl<>();
        tree.insert(1,2);
        tree.insert(2,3);
        tree.insert(3,4);
        tree.insert(4,5);
        tree.delete(1);
        tree.delete(2);
        tree.delete(3);
        tree.delete(4);
        assertTrue(tree.find(1)==null && tree.find(2)==null && tree.find(3)==null && tree.find(4)==null);
    }
    @Test
    public void containstest(){
        MyBinarySearchTreeImpl<Integer,Integer> tree = new MyBinarySearchTreeImpl<>();
        tree.insert(1,2);
        tree.insert(2,3);
        tree.insert(3,4);
        tree.insert(4,5);
        assertTrue(tree.contains(1) && tree.contains(2) && tree.contains(3) && tree.contains(4));
    }

}
