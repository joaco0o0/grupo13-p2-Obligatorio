package uy.edu.um.adt.TADS.MyQueue;

public interface MyQueue<T> {
    void enqueue(T value);
    T dequeue();
    T peekElement();
    int size();
    T get(int index);
}
