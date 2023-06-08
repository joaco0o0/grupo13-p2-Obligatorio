package uy.edu.um.adt.tests.MyHeap;
import org.junit.Test;
import uy.edu.um.adt.TADS.MyHeap.MyHeapImpl;
import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertTrue;

public class MyHeapTests {
    @Test
    public void testinsert(){
        MyHeapImpl<Integer> heap = new MyHeapImpl<>(true);
        heap.insert(2);
        heap.insert(3);
        heap.insert(4);
        heap.insert(1);
        assertTrue(heap.size()==4 && heap.get().equals(1));
        MyHeapImpl<Integer> heapM = new MyHeapImpl<>(false);
        heapM.insert(2);
        heapM.insert(3);
        heapM.insert(4);
        heapM.insert(1);
        assertTrue(heapM.size()==4 && heapM.get().equals(4));
    }
    @Test
    public void testdelete(){
        MyHeapImpl<Integer> heap = new MyHeapImpl<>(true);
        heap.insert(2);
        heap.insert(3);
        heap.insert(4);
        heap.insert(1);
        heap.deleteMin();
        heap.deleteMin();
        heap.deleteMin();
        assertTrue(heap.size()==1 && heap.get().equals(4));
        MyHeapImpl<Integer> heapM = new MyHeapImpl<>(false);
        heapM.insert(2);
        heapM.insert(3);
        heapM.insert(4);
        heapM.insert(1);
        heapM.deleteMax();
        heapM.deleteMax();
        heapM.deleteMax();
        System.out.println(heapM.get());
        assertTrue(heapM.size()==1);
    }
    @Test
    public void testget(){
        MyHeapImpl<Integer> heap = new MyHeapImpl<>(true);
        heap.insert(2);
        heap.insert(3);
        heap.insert(4);
        heap.insert(1);
        assertEquals(1, (int) heap.get());
        MyHeapImpl<Integer> heapM = new MyHeapImpl<>(false);
        heapM.insert(2);
        heapM.insert(3);
        heapM.insert(4);
        heapM.insert(1);
        assertEquals(4, (int) heapM.get());
    }
    @Test
    public void testsize() {
        MyHeapImpl<Integer> heap = new MyHeapImpl<>(true);
        heap.insert(2);
        heap.insert(3);
        heap.insert(4);
        heap.insert(1);
        assertTrue(heap.size() == 4);
        MyHeapImpl<Integer> heapM = new MyHeapImpl<>(false);
        heapM.insert(2);
        heapM.insert(3);
        heapM.insert(4);
        heapM.insert(1);
        assertTrue(heapM.size() == 4);
    }

}
