package uy.edu.um.adt.TADS.MyHeap;
public class MyHeapImpl<T extends Comparable<T>> implements MyHeap<T> {
    private T[] heap;
    private int size;
    private boolean minHeap;

    public MyHeapImpl(boolean minHeap) {
        this.size = 0;
        this.heap = (T[]) new Comparable[10];
        this.minHeap = minHeap;
    }
    @Override
    public T deleteMin(){
        T min = heap[1];
        heap[1] = heap[size--];
        ordenarMin(1);
        return min;
    }

    private void ordenarMin(int i) {
        T tmp = heap[i];
        int hijo;
        while (2 * i <= size) {
            hijo = 2 * i;

            if (hijo != size && heap[hijo].compareTo(heap[hijo + 1]) > 0)
                hijo++;

            if (tmp.compareTo(heap[hijo]) > 0) {
                heap[i] = heap[hijo];
                i = hijo;
            } else {
                break;
            }
        }
        heap[i] = tmp;
    }

    @Override
    public T deleteMax() {
        T max = heap[1];
        heap[1] = heap[size];
        heap[size] = null;
        size--;
        ordenarMax(1);

        return max;
    }

    private void ordenarMax(int i) {
        T tmp = heap[i];
        int hijo;
        while (2 * i <= size) {
            hijo = 2 * i;

            if (hijo != size && heap[hijo].compareTo(heap[hijo + 1]) < 0) // Compare with the largest child
                hijo++;

            if (tmp.compareTo(heap[hijo]) < 0) { // Compare with the largest child
                heap[i] = heap[hijo];
                i = hijo;
            } else {
                break;
            }
        }
        heap[i] = tmp;
    }

    @Override
    public void insert(T elem) {
        if (size == heap.length - 1) {
            expand();
        }
        int position = ++size;
        boolean stop = false;
        while (position > 1) {
            if (minHeap) {
                if (elem.compareTo(heap[position / 2]) < 0) {
                    heap[position] = heap[position / 2];
                    position = position / 2;
                } else {
                    break;
                }
            } else {
                if (!(elem.compareTo(heap[position / 2]) < 0)) {
                    heap[position] = heap[position / 2];
                    position = position / 2;
                } else {
                    break;
                }
            }
        }
        heap[position] = elem;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public T get(){
        T min = heap[1];
        return min;
    }

    private void expand() {
        T[] nuevo = (T[]) new Comparable[heap.length * 2];
        System.arraycopy(heap, 0, nuevo, 0, heap.length);
        heap = nuevo;
    }
}