package test.stack;

import test.linkedList.SingleLinkedList;

public class LinkedListStack<E> implements Stack<E> {
    private SingleLinkedList<E> linkedList;

    public LinkedListStack() {
        this.linkedList = new SingleLinkedList();
    }

    @Override
    public void push(E e) {
        linkedList.addFirst(e);
    }

    @Override
    public E pop() {
        return linkedList.removeFirst();
    }

    @Override
    public E peek() {
        return linkedList.getFirst();
    }

    @Override
    public boolean isEmpty() {
        return linkedList.isEmpty();
    }

    @Override
    public int getSize() {
        return linkedList.getSize();
    }

    @Override
    public String toString() {
        StringBuffer str = new StringBuffer();
        str.append("LinkedListStack: top");
        str.append(linkedList);
        return str.toString();
    }
}
