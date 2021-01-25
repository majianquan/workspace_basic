package demo.set;

import demo.tree.AVLTree;

public class AVLSet<E extends Comparable<E>> implements Set<E> {
    private AVLTree<E,Object> avl;

    public AVLSet() {
        this.avl = new AVLTree<>();
    }

    @Override
    public void add(E e) {
        this.avl.add(e,null);
    }

    @Override
    public void remove(E e) {
        this.avl.remove(e);
    }

    @Override
    public boolean contains(E e) {
        return this.avl.contains(e);
    }

    @Override
    public boolean isEmpty() {
        return this.avl.isEmpty();
    }
    public int getSize() {
        return this.avl.getSize();
    }
}
