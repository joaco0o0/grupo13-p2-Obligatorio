package uy.edu.um.adt.TADS.MyHeap;

public interface MyHeap <T extends Comparable<T>>{
    T delete();
    T get();
    void insert(T element);
    int size();
}
