package test.queue;

public interface Queue<E> {
    // 入队
    void enqueue(E e);
    // 出队
    E dequeue();
    // 获取队首的元素
    E getFront();
    // 获取队列的大小
    int getSize();
    // 判断队列是否为空
    boolean isEmpty();
}
