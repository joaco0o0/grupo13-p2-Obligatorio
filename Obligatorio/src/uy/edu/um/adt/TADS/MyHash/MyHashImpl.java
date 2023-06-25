package uy.edu.um.adt.TADS.MyHash;

import uy.edu.um.adt.TADS.MyLinkedList.MyLinkedList;
import uy.edu.um.adt.TADS.MyLinkedList.Mylist;

public class MyHashImpl<K,T> implements MyHash<K,T> {
    private int capacity;
    private HashNode[] table;
    private int contadorSize = 0;

    public MyHashImpl(int capacity) {
        this.capacity = capacity;
        this.table = new HashNode[capacity];
        arrayfill();
    }
    private void arrayfill(){
        for (int i = 0; i < capacity; i++) {
            table[i] = null;
        }

    }
    @Override
    public void put(K key, T value) {
        int position = normalizeIndex(key.hashCode());

        HashNode<K, T> node = new HashNode<>(key, value);

        if (table[position] == null || table[position].isDeleted()) {
            table[position] = node;
            contadorSize++;
            return;
        }

        int i = 1;
        int newPosition;

        while (i <= capacity) {
            newPosition = normalizeIndex(position + linearCollision(i));

            if (table[newPosition] == null || table[newPosition].isDeleted()) {
                table[newPosition] = node;
                contadorSize++;
                return;
            }

            if (table[newPosition].getKey().equals(key)) {
                table[newPosition].setValue(value);
                return;
            }

            i++;
        }

        doubleSize();
        put(key, value);
    }
    @Override
    public boolean containsKey(K key) {
        int position = normalizeIndex(key.hashCode());
        if (table[position] == null) {
            return false;
        }
        if (table[position].getKey().equals(key) && !table[position].isDeleted()) {
            return true;
        }
        int i = 1;
        int newPosition;

        while (i <= capacity) {
            newPosition = normalizeIndex(position + linearCollision(i));

            if (table[newPosition] == null) {
                return false;
            }

            if (table[newPosition].getKey().equals(key) && !table[newPosition].isDeleted()) {
                return true;
            }

            i++;
        }
        return false;
    }
    @Override
    public boolean containsValue(T value) {
        for (int i = 0; i < capacity; i++) {
            if(table[i] != null && table[i].getValue().equals(value)){
                return true;
            }
        }
        return false;
    }
    @Override
    public void remove(K clave) {
        int lugar = clave.hashCode() % capacity;
        if(lugar < 0){
            lugar = lugar * -1;
        }
        if (table[lugar] != null && table[lugar].getKey().equals(clave)) {
            table[lugar].setDeleted(true);
            contadorSize--;
        } else {
            int i = 1;
            int newPosition = ((clave.hashCode() + linearColision(i)) % capacity);
            if(newPosition < 0){
                newPosition = newPosition * -1;
            }
            while (table[newPosition] != null && !table[newPosition].isDeleted() && !table[newPosition].getKey().equals(clave) && i <= capacity) {
                i++;
                newPosition = ((clave.hashCode() + linearColision(i)) % capacity);
                if(newPosition < 0){
                    newPosition = newPosition * -1;
                }
            }
            if (i <= capacity) {
                table[newPosition].setDeleted(true);
                contadorSize--;
            }
        }


    }

    @Override
    public int size() {
        return contadorSize;
    }
    @Override
    public T get(K key) {
        int position = normalizeIndex(key.hashCode());

        if (table[position] == null) {
            return null;
        }

        if (table[position].getKey().equals(key) && !table[position].isDeleted()) {
            return (T) table[position].getValue();
        }

        int i = 1;
        int newPosition;

        while (i <= capacity) {
            newPosition = normalizeIndex(position + linearCollision(i));

            if (table[newPosition] == null || table[newPosition].isDeleted()) {
                return null;
            }

            if (table[newPosition].getKey().equals(key)) {
                return (T) table[newPosition].getValue();
            }

            i++;
        }

        return null;
    }
    private int normalizeIndex(int index) {
        return (index % capacity + capacity) % capacity;
    }
    private int linearCollision(int attempt) {
        return attempt;
    }
    private void doubleSize() {
        capacity *= 2;
        HashNode[] oldTable = table;
        table = new HashNode[capacity];
        arrayfill();
        for (int i = 0; i < oldTable.length; i++) {
            if (oldTable[i] != null) {
                put((K) oldTable[i].getKey(), (T) oldTable[i].getValue());
            }
        }
    }
    private int linearColision(int i) {
        return i;
    }
    @Override
    public Mylist<T> values() {
        Mylist<T> lista = new MyLinkedList<>();
        for (int i = 0; i < capacity; i++) {
            if(table[i] != null && !table[i].isDeleted()){
                lista.add((T) table[i].getValue());
            }
        }
        return lista;
    }
    @Override
    public String[] keys() {
        String[] keys = new String[capacity];
        for (int i = 0; i < capacity; i++) {
            if(table[i] != null && !table[i].isDeleted()){
                keys[i] = table[i].getKey().toString();
            }
        }
        return keys;
    }
    @Override
    public boolean contains(K value) {
        for (int i = 0; i < capacity; i++) {
            if(table[i] != null && table[i].getValue().equals(value)){
                return true;
            }
        }
        return false;
    }
}