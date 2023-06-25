package uy.edu.um.adt.TADS.MyQueue;

public interface MyQueue<T> {
    void enqueueWithPriority(T value, int prioridad);
    void enqueue(T value);
    T dequeue();
    T peekElement();
    int size();
    T get(int index);


}
