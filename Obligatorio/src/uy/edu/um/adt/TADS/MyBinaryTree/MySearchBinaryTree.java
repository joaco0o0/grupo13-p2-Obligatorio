package uy.edu.um.adt.TADS.MyBinaryTree;

import uy.edu.um.adt.TADS.MyLinkedList.Mylist;

public interface MySearchBinaryTree<K extends Comparable<K>,T> {
    T find(K key);
    void insert(K key, T value);
    void delete(K key);
    boolean contains(K key);
}
