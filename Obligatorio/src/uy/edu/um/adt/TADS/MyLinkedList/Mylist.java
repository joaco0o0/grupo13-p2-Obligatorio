package uy.edu.um.adt.TADS.MyLinkedList;

public interface Mylist<T> {
    void add(T value);
    void addAt(int index, T value);
    T get(int index);
    boolean contains(T value);
    void remove(T value);
    int findPosition(T value);
    int size();

    boolean isEmpty();

    void clear();

}
