import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;
import uy.edu.um.adt.tests.MyBinaryTree.MyBinaryTreeTests;
import uy.edu.um.adt.tests.MyHash.MyHashTests;
import uy.edu.um.adt.tests.MyLinkedList.MyLinkedListTests;
import uy.edu.um.adt.tests.MyQueue.MyQueueTests;
import uy.edu.um.adt.tests.MyStack.MyStackTest;

@RunWith(Suite.class)
@SuiteClasses({MyQueueTests.class, MyStackTest.class, MyLinkedListTests.class, MyBinaryTreeTests.class, MyHashTests.class})
public class Alltests { }