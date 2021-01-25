package demo.set;

import demo.linkedList.SingleLinkedList;

public class SingleLinkedListSet<E extends Comparable<E>> implements Set<E>{
    private SingleLinkedList<E> list;

    public SingleLinkedListSet() {
        list = new SingleLinkedList<>();
    }

    @Override
    public void add(E e) {
        if(!list.contains(e)){
            list.addFirst(e);
        }
    }

    @Override
    public void remove(E e) {
        list.removeElement(e);
    }

    @Override
    public boolean contains(E e) {
        return list.contains(e);
    }

    @Override
    public boolean isEmpty() {
        return list.getSize() == 0;
    }
}
