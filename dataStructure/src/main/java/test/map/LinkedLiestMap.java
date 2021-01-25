package test.map;

public class LinkedLiestMap<K,V> implements Map<K,V> {
    private Node head;
    private int size;
    private class Node {
        private K key;
        private V value;
        private Node next;
        public Node(K key, V value, Node next) {
            this.key = key;
            this.value = value;
            this.next = next;
        }

        public Node(K key) {
            this(key, null, null);
        }

        public Node() {
            this(null, null, null);
        }

        @Override
        public String toString() {
            return key.toString() + " : " + value.toString();
        }
    }
    public LinkedLiestMap() {
        head = new Node();
        size = 0;
    }

    @Override
    public void add(K key, V value) {
        Node node = getNode(key);
        if(node == null) {
            head.next = new Node(key,value,head.next);
        } else {
            node.value = value;
        }
    }

    @Override
    public V remove(K key) {
        Node prev = head;
        while (prev.next != null) {
            if(prev.next.key.equals(key)) {
                break;
            }
            prev = prev.next;
        }
        if(prev.next != null) {
            Node delNode = prev.next;
            prev.next = delNode.next;
            delNode.next = null;
            size--;
            return delNode.value;
        }
        return null;
    }

    @Override
    public boolean contains(K key) {
        Node node = getNode(key);
        return node != null;
    }

    @Override
    public V get(K key) {
        Node node = getNode(key);
        return node == null ? null : node.value;
    }

    @Override
    public void set(K key, V value) {
        Node node = getNode(key);
        if (node == null) {
            throw new IllegalArgumentException(key + " does`n exist");
        } else {
            node.value = value;
        }
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }
    private Node getNode(K key) {
        Node cur = head;
        while (cur != null) {
            if(cur.key.equals(key)) {
                return cur;
            }
            cur = cur.next;
        }
        return null;
    }
}
