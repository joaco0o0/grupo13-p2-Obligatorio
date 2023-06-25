package uy.edu.um.adt.TADS.MyLinkedList;
import uy.edu.um.adt.TADS.MyQueue.MyQueue;
import uy.edu.um.adt.TADS.MyStack.MyStack;


public class MyLinkedList<T> implements Mylist<T>, MyStack<T>,MyQueue<T> {
    private Node<T> first;
    private Node<T> last;
    private int size = 0;

    public MyLinkedList() {
        this.first = null;
        this.last = null;
    }

    public boolean isEmpty() {
        return this.first == null;
    }

    @Override
    public void add(T value) {
        if (value != null) {

            Node<T> elementToAdd = new Node<>(value);

            if (this.first == null) {
                this.first = elementToAdd;

            } else {
                elementToAdd.setPrevious(this.last);
                this.last.setNext(elementToAdd);
            }
            this.last = elementToAdd;
            size++;
        }
    }
    @Override
    public void addAt(int index, T value) {
        if (value != null) {
            Node<T> elementToAdd = new Node<>(value);
            if (this.first == null) {
                this.first = elementToAdd;
                this.last = elementToAdd;
            } else if(index > this.size()) {
                this.add(value);
            }else {
                if (index == 0) {
                    elementToAdd.setNext(this.first);
                    this.first = elementToAdd;
                } else {
                    Node<T> previous = null;
                    Node<T> current = this.first;
                    int tempIndex = 0;

                    while (current != null) {
                        if (tempIndex == index) {
                            elementToAdd.setNext(current);
                            previous.setNext(elementToAdd);
                            break;
                        }
                        previous = current;
                        current = current.getNext();
                        tempIndex++;
                    }
                }
            }
            size++;
        }
    }

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public void clear() {
        this.first = null;
        this.last = null;
    }

    @Override
    public void remove(T value) {
        Node<T> temp = this.first;
        Node<T> previous = null;
        while (temp != null) {
            if (temp.getValue().equals(value)) {
                if (previous == null) {
                    this.first = temp.getNext();
                } else {
                    previous.setNext(temp.getNext());
                }
                if (temp == this.last) {
                    this.last = previous;
                }
                size--;
                break;
            }
            previous = temp;
            temp = temp.getNext();
        }
    }


    public void removeWithIndex(int index) {
        Node<T> temp = this.first;
        Node<T> previous = null;
        int tempIndex = 0;
        while (temp != null) {
            if (tempIndex == index) {
                if (previous == null) {
                    this.first = temp.getNext();
                } else {
                    previous.setNext(temp.getNext());
                }
                if (temp == this.last) {
                    this.last = previous;
                }
                break;
            }
            previous = temp;
            temp = temp.getNext();
            tempIndex++;
        }
    }

    @Override
    public boolean contains(T value) {
        Node<T> temp = this.first;

        while (temp != null) {
            if (temp.getValue().equals(value)) {
                return true;
            }
            temp = temp.getNext();
        }
        return false;
    }

    @Override
    public int findPosition(T value) {
        Node<T> temp = this.first;
        int position = 0;
        while (temp != null) {
            if (temp.getValue().equals(value)) {
                return position;
            }
            temp = temp.getNext();
            position++;
        }
        return position;
    }

    @Override
    public T get(int position) {
        T valueToReturn = null;
        int tempPosition = 0;
        Node<T> temp = this.first;
        while (temp != null) {
            if (tempPosition == position) {
                valueToReturn = temp.getValue();
                break;
            }
            temp = temp.getNext();
            tempPosition++;
        }
        return valueToReturn;
    }

    @Override
    public void enqueueWithPriority(T value, int prioridad) {
        if (value != null) {
            Node<T> elementToAdd = new Node<>(value, prioridad);
            Node<T> aux = this.first;
            if (this.first == null) {
                this.first = elementToAdd;
                this.last = elementToAdd;
            } else {
                if (prioridad > this.first.getPriority()) {
                    this.first.setPrevious(elementToAdd);
                    this.first = elementToAdd;
                    this.first.setNext(aux);
                } else {
                    while (aux.getNext() != null && prioridad <= aux.getNext().getPriority()) {
                        aux = aux.getNext();
                    }                                // se recorre la lista hasta encontrar el elemento con menor prioridad
                    if (aux.getNext() == null) {
                        aux.setNext(elementToAdd);
                        this.last = elementToAdd;    // si la prioridad es mayor a todos los elementos se agrega al final
                    } else {
                        elementToAdd.setNext(aux.getNext());
                        aux.getNext().setPrevious(elementToAdd);
                        aux.setNext(elementToAdd);
                    }
                }
            }
            this.size++;
        }
    }

    @Override
    public void enqueue(T value) {
        this.add(value);
    }

    @Override
    public T dequeue() {
        this.remove(this.first.getValue());
        return null;
    }

    @Override
    public T peekElement(){
        return this.first.getValue();
    }

    @Override
    public void push(T value) {
        this.add(value);
    }

    @Override
    public T pop() {
        this.remove(this.last.getValue());
        return null;
    }

    @Override
    public T peek() {
        if(this.isEmpty()) {
            return null;
        }else{
            return this.last.getValue();
        }
    }

    public void print() {
        Node<T> temp = this.first;
        while (temp != null) {
            System.out.println(temp.getValue());
            temp = temp.getNext();
        }
    }



}
