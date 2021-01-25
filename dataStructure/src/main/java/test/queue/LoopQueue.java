package test.queue;

public class LoopQueue<E> implements Queue<E> {
    private E[] data;
    private int front;
    private int tail;
    private int size;

    public LoopQueue(int capacity) {
        data = (E[]) new Object[capacity + 1];
        front = 0;
        tail = 0;
        size = 0;
    }

    public LoopQueue() {
        this(10);
    }
    public int getCapacity() {
        return data.length - 1;
    }
    @Override
    public void enqueue(E e) {
        // 队列满判断,并且自动缩容
        if((tail+1)%data.length == front) {
            resize(getCapacity() * 2);
        }
        data[tail] = e;
        tail = (tail + 1)/data.length;
        size++;
    }

    private void resize(int newCapacity) {
        E[] newData = (E[])new Object[newCapacity];
        for (int i = 0; i <size ; i++) {
            newData[i] = data[(front+i)%data.length];
        }
        data = newData;
        front = 0;
        tail = size;
    }

    @Override
    public E dequeue() {
        if (isEmpty()) {
            throw new IllegalArgumentException("Cannot dequeue form an empty queue");
        }
        E  result = data[front];
        data[front] = null;
        front=(front + 1) % data.length;
        size--;
        // 缩容操作
        if(size == getCapacity() / 4 && getCapacity()/2 > 0) {
            resize(getCapacity() / 2);
        }
        return result;
    }

    @Override
    public E getFront() {
        if(isEmpty()){
            throw new IllegalArgumentException("LoopQueue is empty");
        }
        return data[front];
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        str.append(String.format("Queue: size = %d, capacity = %d\n", size, getCapacity()));
        str.append("front [");
        for (int i = front; i != tail; i = (i + 1) % data.length) {
            str.append(data[i]);
            if ((i+1) % data.length != tail) {
                str.append(", ");
            }
        }
        str.append("] tail");
        return str.toString();
    }
}
