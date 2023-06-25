package uy.edu.um.adt.TADS.MyLinkedList;

import uy.edu.um.adt.ENTITIES.Piloto;

public interface Mylist<T> {
    void add(T value);
    void addAt(int index, T value);

    T get(int index);
    boolean contains(T value);
    void remove(T value);
    int findPosition(T value);
    int size();
    void set(int index, T value);

    boolean isEmpty();

    void clear();

}
