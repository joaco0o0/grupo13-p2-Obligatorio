package uy.edu.um.adt.TADS.MyStack;

public interface MyStack<T> {
    void push(T value);
    T pop();
    T peek();
    int size();
    T get(int index);
}
