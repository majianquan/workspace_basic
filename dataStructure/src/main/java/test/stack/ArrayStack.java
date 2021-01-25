package test.stack;

import test.array.Array;

public class ArrayStack<E> implements Stack<E> {
    private Array<E> array;

    public ArrayStack(int capacity) {
        array = new Array<>(capacity);
    }

    public ArrayStack() {
        array = new Array<>();
    }

    @Override
    public void push(E e) {
        array.addLast(e);
    }

    @Override
    public E pop() {
        return array.removeLast();
    }

    @Override
    public E peek() {
        return array.get(0);
    }

    @Override
    public boolean isEmpty() {
        return array.isEmpty();
    }

    @Override
    public int getSize() {
        return array.getSize();
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        str.append(String.format("Stack: "));
        str.append("[");
        for (int i = 0; i < array.getSize(); i++) {
            str.append(array.get(i));
            if( i!= array.getSize() -1) {
                str.append(", ");
            }
        }
        str.append(']');
        return str.toString();
    }
}
