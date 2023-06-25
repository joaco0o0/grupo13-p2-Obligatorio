package uy.edu.um.adt.TADS.MyLinkedList;

public class Node<T> {
    private T value;
    private Node<T> next;
    private Node<T> previous;
    private int priority;
    public Node(T value) {
        this.value = value;
        this.next = null;
        this.previous = null;
        this.priority = 0;
    }

    public Node(T value, int priority) {
        this.value = value;
        this.next = null;
        this.previous = null;
        this.priority = priority;
    }

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    public Node getPrevious() {
        return previous;
    }

    public void setPrevious(Node previous) {
        this.previous = previous;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }
}
