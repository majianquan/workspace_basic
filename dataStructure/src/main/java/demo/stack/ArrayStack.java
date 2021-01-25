package demo.stack;

import demo.array.MyArrayList;

public class ArrayStack<E> implements Stack<E>{
    private MyArrayList<E> array;
    public ArrayStack(int capacity) {
        array = new MyArrayList<>(capacity);
    }

    public ArrayStack() {
        array = new MyArrayList<>();
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
        return array.getLast();
    }

    @Override
    public int getSize() {
        return array.getSize();
    }

    @Override
    public boolean isEmpty() {
        return array.isEmpty();
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
