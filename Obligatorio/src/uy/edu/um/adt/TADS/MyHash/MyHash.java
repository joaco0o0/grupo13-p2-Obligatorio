package uy.edu.um.adt.TADS.MyHash;

import uy.edu.um.adt.TADS.MyLinkedList.Mylist;

public interface MyHash<K,T> {
    public void put(K key, T value);
    public boolean containsKey(K key);
    public void remove(K clave);
    public int size();
    public T get(K key);
    public boolean containsValue(T value);
    public Mylist<T> values();
    public String[] keys();
}