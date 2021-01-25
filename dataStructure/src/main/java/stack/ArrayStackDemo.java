package stack;

import java.util.Scanner;

public class ArrayStackDemo {
    public static void main(String[] args) {
        ArrayStack stack = new ArrayStack(4);
        Scanner scanner = new Scanner(System.in);
        String key = "";
        boolean loop = true;
        while (loop) {
            System.out.println("show: 表示显示栈");
            System.out.println("exit: 退出程序");
            System.out.println("push: 表示向栈中推送数据(入栈)");
            System.out.println("pop:  表示从栈中取出数据(出战)");

            key = scanner.next();
            switch (key){
                case "show":
                    stack.list();
                    break;
                case "exit":
                    scanner.close();
                    loop = false;
                    break;
                case "push":
                    System.out.println("请输入一个数字");
                    int value = scanner.nextInt();
                    stack.push(value);
                    break;
                case "pop":
                    int res = stack.pop();
                    System.out.printf("出栈的数据是%d\n", res);
                    break;
                default:
                    break;
            }

        }
        System.out.println("程序退出...");
    }
}

class ArrayStack {
    private int maxSize;
    private int top = -1;
    private int[] stack;

    public ArrayStack(int maxSize) {
        this.maxSize = maxSize;
        stack = new int[maxSize];
    }

    public int pop() {
        if(isEmpty()) {
            throw new RuntimeException("栈空,没有数据");
        }
        int value = stack[top];
        top--;
        return value;
    }
    public void push(int value) {
        if(isFull()) {
            System.out.println("栈满");
            return;
        }
        top++;
        stack[top] = value;
    }
    public void list() {
        if(isEmpty()) {
            throw new RuntimeException("栈空,没有数据");
        }
        for (int i = 0; i <= top; i++) {
            System.out.printf("stack[%d]=%d\n", i, stack[i]);
        }
    }
    public boolean isFull() {
        return  top == maxSize - 1;
    }
    public boolean isEmpty() {
        return  top == -1;
    }
}


