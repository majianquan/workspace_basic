package queue;


import java.util.Scanner;

public class QueueDemo {
    public static void main(String[] args) {
        ArrayQueue arrayQueue = new ArrayQueue(3);
        Scanner scanner = new Scanner(System.in);
        char key;
        Boolean loop = true;
        while (loop) {
            // 接收第一个字符
            System.out.println("s(show) 显示队列");
            System.out.println("a(add) 添加数据到队列");
            System.out.println("g(get) 从队列中取出数据");
            System.out.println("h(head) 查看队列头部数据");
            System.out.println("e(exit) 退出程序");
            key = scanner.next().charAt(0);
            switch (key) {
                case 's' :
                    arrayQueue.showQueue();
                    break;
                case 'a' :
                    System.out.println("请输入一个数字..");
                    int i = scanner.nextInt();
                    arrayQueue.addQueue(i);
                    break;
                case 'g' :
                    int queue = arrayQueue.getQueue();
                    System.out.println(queue);
                    break;
                case 'h' :
                    int i1 = arrayQueue.headQueue();
                    System.out.println(i1);
                    break;
                case 'e' :
                    scanner.close();
                    loop = false;
                    break;
                default:
                    scanner.close();
                    loop = false;

            }
            System.out.println("退出程序...");
        }
    }
}

class ArrayQueue {
    // 表示数组最大容量
    private int maxSize;
    // 队列尾
    private int rear = -1;
    // 队列头
    private int front = -1;
    // 存放数据的数组
    private int[] arr;

    public ArrayQueue(int maxSize) {
        this.maxSize = maxSize;
        arr = new int[maxSize];
    }
    // 是否满了
    public boolean isFull(){
        return  rear == maxSize -1;
    }
    // 是否为空
    public boolean isEmpty() {
        return rear == front;
    }
    // 添加队列
    public void addQueue(int i){
        if(isFull()) {
            System.out.println("队列满,不能加入数据...");
            return;
        }
        rear++;
        arr[rear] = i;
    }
    // 获取队列头部
    public int getQueue() {
        if(isEmpty()) {
            throw new RuntimeException("队列空,不能获取数据...");
        }
        front++;
        return arr[front];
    }
    // 显示头部数据
    public int headQueue(){
        if(isEmpty()) {
            throw new RuntimeException("队列空,不能获取数据...");
        }
        return arr[front+1];

    }
    // 显示整个队列
    public void showQueue() {
        if(isEmpty()) {
            throw new RuntimeException("队列空,不能获取数据...");
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.printf("arr[%d]=%d\n",i,arr[i]);
        }
    }
}

class CircularQueue{
    private int rear = 0;
    private int front = 0;
    private  int maxSize;
    private int[] arr;

    public CircularQueue(int maxSize) {
        this.maxSize = maxSize;
        arr = new int[maxSize];
    }
    // 是否满了
    public boolean isFull(){
        return false;
    }
    // 是否为空
    public boolean isEmpty() {
        return rear == front;
    }
    // 添加队列
    public void addQueue(int i){
        if(isFull()) {
            System.out.println("队列满,不能加入数据...");
            return;
        }
        arr[rear] = i;
        rear  = (rear + 1) % maxSize;
    }
    // 获取队列头部
    public int getQueue() {
        if(isEmpty()) {
            throw new RuntimeException("队列空,不能获取数据...");
        }
        int value = arr[front];
        front = (front + 1) % maxSize;
        return value;
    }
    // 显示头部数据
    public int headQueue(){
        if(isEmpty()) {
            throw new RuntimeException("队列空,不能获取数据...");
        }
        return arr[front];

    }
    // 显示整个队列
    public void showQueue() {
        if(isEmpty()) {
            throw new RuntimeException("队列空,不能获取数据...");
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.printf("arr[%d]=%d\n",i,arr[i]);
        }
    }
    public int size(){
        return (rear + maxSize -front) % maxSize;
    }
}