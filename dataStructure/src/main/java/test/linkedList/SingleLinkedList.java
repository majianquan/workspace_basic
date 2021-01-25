package test.linkedList;

// 单向链表(递归版)
public class SingleLinkedList<E> {
    private Node tail;
    private Node head;
    private int size;

    public SingleLinkedList() {
        this.head = new Node();
        size = 0;
    }

    public int getSize() {
        return size;
    }

    // 向链表中添加元素
    public void add(int index, E e) {
        if (index < 0 && index > size) {
            throw new IllegalArgumentException("add fail, index illegal");
        }
        Node prev = head;
        for (int i = 0; i < index; i++) {
            prev = prev.next;
        }
        prev.next = new Node(e, prev.next);
        size++;
    }

    // 在链表头部添加节点
    public void addFirst(E e) {
        add(0, e);
    }

    // 在链表尾部添加节点
    public void addLast(E e) {
        add(size, e);
    }

    // 获取链表中第index个索引对应的值
    public E get(int index) {
        if (index < 0 && index >= size) {
            throw new IllegalArgumentException("get fail, index illegal");
        }
        Node cur = head.next;
        for (int i = 0; i < index; i++) {
            cur = cur.next;
        }
        return cur.e;
    }

    // 获取链表中的第一个元素
    public E getFirst() {
        return get(0);
    }

    // 获取链表中的最后一个元素
    public E getLast() {
        return get(size - 1);
    }

    // 删除链表中第index个节点的数据
    public E remove(int index) {
        if (index < 0 && index >= size) {
            throw new IllegalArgumentException("remove fail, index illegal");
        }
        Node prev = head;
        for (int i = 0; i < index; i++) {
            prev = prev.next;
        }
        Node delNode = prev.next;
        prev.next = delNode.next;
        delNode.next = null;
        size--;
        return delNode.e;
    }

    // 删除链表中第一个元素
    public E removeFirst() {
        return remove(0);
    }

    // 删除链表中最后一个元素
    public E removeLast() {
        return remove(size - 1);
    }

    // 删除某个元素
    public void removeElement(E e) {
        Node prev = head;
        while (prev.next != null) {
            if (prev.next.e.equals(e)) {
                break;
            }
            prev = prev.next;
        }
        if (prev.next != null) {
            Node delNode = prev.next;
            prev.next = delNode.next;
            delNode.next = null;
        }
    }

    // 更新第index的值
    public void update(int index, E e) {
        if (index < 0 && index >= size) {
            throw new IllegalArgumentException("update fail, index illegal");
        }
        Node cur = head.next;
        for (int i = 0; i < index; i++) {
            cur = cur.next;
        }
        cur.e = e;
    }

    // 查找链表是否有某个元素
    public boolean contains(E e) {
        Node cur = head.next;
        while (cur != null) {
            if (cur.e.equals(e)) {
                return true;
            }
            cur = cur.next;
        }
        return false;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        str.append(" {");
        Node cur = head.next;
        while (cur != null) {
            str.append(cur.e.toString());
            cur = cur.next;
            if (cur != null) {
                str.append(" -> ");
            }
        }
        str.append("}");
        return str.toString();
    }

    private class Node {
        private E e;
        private Node next;

        public Node(E e, Node next) {
            this.e = e;
            this.next = next;
        }

        public Node(E e) {
            this(e, null);
        }

        public Node() {
            this(null, null);
        }

        @Override
        public String toString() {
            return "Node{" +
                    "e=" + e +
                    '}';
        }
    }
}
