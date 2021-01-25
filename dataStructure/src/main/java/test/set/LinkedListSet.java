package test.set;

import demo.linkedList.SingleLinkedList;

public class LinkedListSet<E> implements Set<E> {
    private SingleLinkedList<E> linkedList;

    public LinkedListSet() {
        this.linkedList = new SingleLinkedList<>();
    }

    @Override
    public void add(E e) {
        if(linkedList.contains(e)) {
            linkedList.addFirst(e);
        }
    }

    @Override
    public void remove(E e) {
        linkedList.removeElement(e);
    }

    @Override
    public boolean contains(E e) {
        return linkedList.contains(e);
    }

    @Override
    public int getSize() {
        return linkedList.getSize();
    }

    @Override
    public boolean isEmpty() {
        return linkedList.isEmpty();
    }
}
