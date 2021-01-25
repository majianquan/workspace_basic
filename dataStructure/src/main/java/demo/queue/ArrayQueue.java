package demo.queue;

import demo.array.MyArrayList;

public class ArrayQueue<E> implements Queue<E> {
    private MyArrayList<E> array;

    public ArrayQueue(int capacity) {
        this.array = new MyArrayList<>(capacity);
    }
    public ArrayQueue() {
        this.array = new MyArrayList<>();
    }

    @Override
    public void enqueue(E e) {
        array.addLast(e);
    }

    @Override
    public E dequeue() {
        return array.removeFirst();
    }

    @Override
    public E getFront() {
        return array.getFirst();
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
        str.append("ArrayQueue: front[");
        for (int i = 0; i < array.getSize(); i++) {
            str.append(array.get(i));
            if(i!=array.getSize() -1) {
                str.append(", ");
            }
        }
        str.append("] tail");
        return str.toString();
    }
}
