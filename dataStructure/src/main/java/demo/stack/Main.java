package demo.stack;

import java.util.Random;

public class Main {
    public static void main(String[] args) {
        int opCount = 100000;
        Stack<Integer> stack = new ArrayStack<>();
//        for (int i = 0; i < 10; i++) {
//            stack.push(i);
//            System.out.println(stack);
//        }
//        stack.pop();
//        System.out.println(stack);
        System.out.println(testStack(stack,opCount));
        Stack<Integer> stack1 = new LinkedListStack<>();
//        for (int i = 0; i < 10; i++) {
//            stack1.push(i);
//            System.out.println(stack1);
//        }
//        stack1.pop();
//        System.out.println(stack1);
        System.out.println(testStack(stack1,opCount));
    }
    public static double testStack(Stack<Integer> s, int opCount) {
        long startTime = System.nanoTime();
        Random random = new Random();
        for (int i = 0; i < opCount; i++) {
            s.push(random.nextInt(Integer.MAX_VALUE));
        }
        for (int i = 0; i < opCount; i++) {
            s.pop();
        }
        long endTime = System.nanoTime();
        return (endTime - startTime) /1000000000.0;
    }
}
