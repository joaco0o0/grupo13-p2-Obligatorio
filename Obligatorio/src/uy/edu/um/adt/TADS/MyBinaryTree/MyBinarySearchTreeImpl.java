package uy.edu.um.adt.TADS.MyBinaryTree;

public class MyBinarySearchTreeImpl<K extends Comparable<K>,T> implements MySearchBinaryTree<K,T>{
    private TreeNode<K,T> root;

    @Override
    public T find(K key) {
        return find(key, root);
    }

    private T find(K key,TreeNode<K,T> root){
        T value = null;
        if (root != null) {
            int nValue = key.compareTo(root.getKey());
            if (nValue == 0) {
                value = root.getValue();
            } else if (nValue > 0) {
                value = find(key, root.getRight());
            } else {
                value = find(key, root.getLeft());
            }
        }
        return value;
    }

    @Override
    public void insert(K key, T value) {
        TreeNode<K, T> elementToAdd = new TreeNode<>(key, value);

        if (root == null) {

            root = elementToAdd;

        } else {

            root.add(key, value);
        }
    }

    @Override
    public void delete(K key) {
        if (root != null) {
            root = root.remove(key);
        }
    }

    @Override
    public boolean contains(K key) {
        return contains(key, root);
    }
    private boolean contains(K key , TreeNode<K,T> root){
        boolean contains = false;
        if (root != null) {
            int nValue = key.compareTo(root.getKey());
            if (nValue == 0) {
                contains = true;
            } else if (nValue > 0) {
                contains = contains(key, root.getRight());
            } else {
                contains = contains(key, root.getLeft());
            }
        }
        return contains;
    }
}
