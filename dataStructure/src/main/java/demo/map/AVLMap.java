package demo.map;

import demo.tree.AVLTree;

public class AVLMap<K extends Comparable<K>,V> implements Map<K,V> {
    private AVLTree<K,V> avl;

    public AVLMap() {
        this.avl = new AVLTree<>();
    }

    @Override
    public void add(K key, V value) {
        this.avl.add(key, value);
    }

    @Override
    public V remove(K key) {
        return this.avl.remove(key);
    }

    @Override
    public boolean contains(K key) {
        return this.avl.contains(key);
    }

    @Override
    public V get(K key) {
        return this.avl.get(key);
    }

    @Override
    public void set(K key, V newValue) {
        this.avl.set(key,newValue);
    }

    @Override
    public int getSize() {
        return this.avl.getSize();
    }

    @Override
    public boolean isEmpty() {
        return this.avl.isEmpty();
    }
}
