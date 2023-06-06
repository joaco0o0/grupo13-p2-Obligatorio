package uy.edu.um.adt.TADS.MyHash;


import java.util.Arrays;

public class MyHashImpl<K,V> implements MyHash<K,V> {
    private int capacity;
    private HashNode[] table;

    public MyHashImpl(int capacity) {
        this.capacity = capacity;
        this.table = new HashNode[capacity];
        Arrays.fill(table, null);
    }

    public MyHashImpl() {
        this.capacity = 1;
        this.table = new HashNode[capacity];
        Arrays.fill(table, null);
    }

    @Override
    public void put(K key, V value) {
        int lugar = key.hashCode() % capacity;
        HashNode<K,V> node = new HashNode<>(key, value);
        if (table[lugar] == null || table[lugar].isDeleted()) {
            table[lugar] = node;
        } else {
            int i = 1;
            int newPosition = ((key.hashCode() + linearColision(i)) % capacity);
            while (table[newPosition] != null && !table[newPosition].isDeleted() && i <= capacity) {
                if (table[newPosition].getKey().equals(key)) {
                    table[newPosition].setValue(value);
                    return;
                }
                i++;
                newPosition = ((key.hashCode() + linearColision(i)) % capacity);
            }
            if (i > capacity) {
                doubleSize();
            }
            if(table[newPosition] == null || table[newPosition].isDeleted()) {
                table[newPosition] = node;
            } else{
                this.put(key, value);
            }
        }

    }

    @Override
    public boolean contains(K key) {
        int lugar = key.hashCode() % capacity;
        int i = 1;
        if(table[lugar] == null){
            return false;
        }
        else
        if(table[lugar].getKey().equals(key)){
            return !table[lugar].isDeleted();
        }
        else{
            int newPosition = ((key.hashCode() + linearColision(i)) % capacity);
            while (i <= capacity && table[newPosition] != null && !table[newPosition].isDeleted() && !table[newPosition].getKey().equals(key)) {
                i++;
                newPosition = ((key.hashCode() + linearColision(i)) % capacity);
            }
            return i <= capacity && table[newPosition].getKey().equals(key) && !table[newPosition].isDeleted();
        }
    }

    @Override
    public void remove(K clave) {
        int lugar = clave.hashCode() % capacity;
        if (table[lugar] != null && table[lugar].getKey().equals(clave)) {
            table[lugar].setDeleted(true);
        } else {
            int i = 1;
            int newPosition = ((clave.hashCode() + linearColision(i)) % capacity);
            while (table[newPosition] != null && !table[newPosition].isDeleted() && !table[newPosition].getKey().equals(clave) && i <= capacity) {
                i++;
                newPosition = ((clave.hashCode() + linearColision(i)) % capacity);
            }
            if (i <= capacity) {
                table[newPosition].setDeleted(true);
            }
        }
    }

    @Override
    public int size() {
        int contador = 0;
        for (int i = 0; i < capacity; i++) {
            if (table[i] != null && !table[i].isDeleted()) {
                contador++;
            }
        }
        return contador;
    }

    @Override
    public V get(K key) {
        int lugar = key.hashCode() % capacity;
        int i = 1;
        if(table[lugar] == null){
            return null;
        }
        else
        if(table[lugar].getKey().equals(key)){
            if(table[lugar].isDeleted()){
                return null;
            }
            else {
                return (V) table[lugar].getValue();
            }
        }
        else {
            int newPosition = ((key.hashCode() + linearColision(i)) % capacity);
            while (i <= capacity && table[newPosition] != null && !table[newPosition].isDeleted() && !table[newPosition].getKey().equals(key)) {
                i++;
                newPosition = ((key.hashCode() + linearColision(i)) % capacity);
            }
            if (table[newPosition] == null || table[newPosition].isDeleted()) {
                return null;
            }

            return (V) table[newPosition].getValue();
        }
    }

    private void doubleSize() {
        capacity *= 2;
        HashNode[] oldTable = table;
        table = new HashNode[capacity];
        Arrays.fill(table, null);
        for (HashNode hashNode : oldTable) {
            if (hashNode != null) {
                put((K) hashNode.getKey(), (V) hashNode.getValue());
            }
        }
    }

    private int linearColision(int i) {
        return i;
    }

    public boolean isDeleted(K key){
        int lugar = key.hashCode() % capacity;
        if(table[lugar] == null){
            return false;
        }
        else
        if(table[lugar].getKey().equals(key)){
            return table[lugar].isDeleted();
        }
        else{
            int i = 1;
            int newPosition = ((key.hashCode() + linearColision(i)) % capacity);
            while (i <= capacity && table[newPosition] != null && !table[newPosition].isDeleted() && !table[newPosition].getKey().equals(key)) {
                i++;
                newPosition = ((key.hashCode() + linearColision(i)) % capacity);
            }
            return i <= capacity && table[newPosition].getKey().equals(key) && table[newPosition].isDeleted();
        }
    }

    public boolean isFull(){
        return size() == capacity;
    }

    public void reHash(K key){
        int lugar = key.hashCode() % capacity;
        HashNode<K,V> node = new HashNode<>(key, get(key));
        if (table[lugar] == null || table[lugar].isDeleted()) {
            table[lugar] = node;
        } else {
            int i = 1;
            int newPosition = ((key.hashCode() + linearColision(i)) % capacity);
            while (table[newPosition] != null && !table[newPosition].isDeleted() && i <= capacity) {
                if (table[newPosition].getKey().equals(key)) {
                    table[newPosition].setValue(get(key));
                    return;
                }
                i++;
                newPosition = ((key.hashCode() + linearColision(i)) % capacity);
            }
            if (i > capacity) {
                doubleSize();
            }
            if(table[newPosition] == null || table[newPosition].isDeleted()) {
                table[newPosition] = node;
            } else{
                this.put(key, get(key));
            }
        }
    }

    public void print(){
        for (int i = 0; i < capacity; i++) {
            if(table[i] != null && !table[i].isDeleted()){
                System.out.println(table[i].getKey() + " " + table[i].getValue());
            }
        }
    }
}