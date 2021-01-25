package test.stack;

public interface Stack<E> {
    // 入栈
    void push(E e);
    // 出栈
    E pop();
    // 查看栈顶元素
    E peek();
    // 栈是否为空
    boolean isEmpty();
    // 栈元素的个数
    int getSize();
}
