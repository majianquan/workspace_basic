package demo.set;

import demo.tree.BinarySearchTree;

public class BSTSet<E extends Comparable<E>> implements Set<E> {
    private BinarySearchTree<E> bst;

    public BSTSet() {
        this.bst = new BinarySearchTree<>();
    }

    @Override
    public void add(E e) {
        bst.add(e);
    }

    @Override
    public void remove(E e) {
        bst.remove(e);
    }

    @Override
    public boolean contains(E e) {
        return bst.contains(e);
    }
    public int getSize(){
        return bst.getSize();
    }
    @Override
    public boolean isEmpty() {
        return bst.getSize() == 0;
    }
}
