package stack.test;

import java.util.EmptyStackException;

public class ArrayStackTest {
    public static void main(String[] args) {
        ArrayStack<String> stack = new ArrayStack<>(5);

    }
}

class ArrayStack<T> {
    private int elementCount;
    private Object[] elementData = {} ;
    private int maxSize = 0;
    private int rear = -1;
    private int front = -1;

    public ArrayStack(int elementCount) {
        this.elementCount = elementCount;
        elementData = new Object[elementCount];
    }
    public boolean isFull() {
        return  false;
    }
    public T push(T item) {
        if(isFull()) {
             throw new RuntimeException("栈已满,不能添加数据!");
        }
        elementData[++rear] = item;
        return item;
    }
    public T pop() {
        if(empty()) {
            throw new EmptyStackException();
        }
        return null;
    }
    public T peak() {
        int len = size();
        if(len == 0)
            throw new EmptyStackException();
        return (T)elementData[len];
    }
    public boolean empty() {
        return size() == 0;
    }
    public int size() {
        return elementData.length;
    }


}
