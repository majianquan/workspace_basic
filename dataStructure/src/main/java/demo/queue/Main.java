package demo.queue;

import java.util.Random;

public class Main {
    public static void main(String[] args) {
        int opCount = 10000000;
        // 单向队列
//        Queue<Integer> queue = new ArrayQueue<>();
//        double time1 = testQueue(queue, opCount);
//        System.out.println("ArrayQueue, time: " + time1 + " s");
//        for (int i = 0; i < 10; i++) {
//            queue.enqueue(i);
//        }
//        System.out.println(queue);
//        queue.dequeue();
//        System.out.println(queue);
        // 循环队列
        Queue<Integer> queue2 = new LoopQueue<>();
//        for (int i = 0; i < 10; i++) {
//            queue.enqueue(i);
//        }
//        System.out.println(queue);
//        queue.dequeue();
//        System.out.println(queue);
//        double time2 = testQueue(queue2, opCount);
//        System.out.println("LoopQueue, time : " + time2 + " s");

        Queue<Integer> queue3 = new LinkedListQueue<>();
        for (int i = 0; i < 10; i++) {
            queue3.enqueue(i);
        }
        System.out.println(queue3);
        queue3.dequeue();
        System.out.println(queue3);
//        double time3 = testQueue(queue3, opCount);
//        System.out.println("LinkedListQueue, time : " + time3 + " s");
    }

    public static double testQueue(Queue<Integer> q, int opCount) {
        long startTime = System.nanoTime();
        Random random = new Random();
        for (int i = 0; i < opCount; i++) {
            q.enqueue(random.nextInt(Integer.MAX_VALUE));
        }
        for (int i = 0; i < opCount; i++) {
            q.dequeue();
        }
        long endTime = System.nanoTime();
        return (endTime - startTime) / 1000000000.0;
    }
}
