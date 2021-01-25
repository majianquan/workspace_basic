package test.queue;

public class LinkedListQueue<E> implements Queue<E> {
    private Node head;
    private Node tail;
    private int size;

    public LinkedListQueue() {
        head = null;
        tail = null;
        size = 0;
    }

    @Override
    public void enqueue(E e) {
        if(head == null) {
            head = new Node(e);
            tail = head;
        } else {
            tail.next = new Node(e);
            tail = tail.next;
        }
        size++;
    }

    @Override
    public E dequeue() {
        if (isEmpty()) {
            throw new IllegalArgumentException("Cannot dequeue element form  an empty queue");
        }
        Node result = head;
        head = result.next;
        result.next = null;
        if(head == null) {
            tail = null;
        }
        size--;
        return result.e;
    }

    @Override
    public E getFront() {
        if (isEmpty()) {
            throw new IllegalArgumentException("Cannot get element form  an empty queue");
        }
        return head.e;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }
    private class Node {
        private E e;
        private Node next;

        public Node(E e, Node next) {
            this.e = e;
            this.next = next;
        }

        public Node(E e) {
            this(e,null);
        }

        public Node() {
            this(null,null);
        }
    }
    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append("LinkedListQueue front [");
        Node cur = head;
        while (cur != null) {
            res.append(cur.e.toString());
            cur = cur.next;
            if(cur != null) {
                res.append("=>");
            }
        }
        return "LinkedListQueue{}";
    }
}
