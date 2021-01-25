package demo.map;

public class BSTMap<K extends Comparable,V extends Comparable> implements Map<K,V> {
    private int size;
    private Node root;
    private class Node {
        private K key;
        private V value;
        private Node left, right;

        public Node(K key, V value, Node left, Node right) {
            this.key = key;
            this.value = value;
            this.left = left;
            this.right = right;
        }

        public Node(K key, V value, Node left) {
            this(key,value,left,null);
        }

        public Node(K key, V value) {
            this(key,value,null,null);
        }

        public Node(K key) {
            this(key,null,null,null);
        }
    }

    public BSTMap() {
        this.size = 0;
        this.root = null;
    }

    @Override
    public void add(K key, V value) {
        root = add(root, key,value);
    }
    private Node add(Node node, K key, V value) {
        if(node == null) {
            size++;
            return new Node(key,value);
        }
        if(node.value.compareTo(value) >0) {
            node.left = add(node.left,key,value);
        } else if(node.value.compareTo(value) < 0) {
            node.right = add(node.right,key,value);
        }
        return node;
    }
    @Override
    public V remove(K key) {
        Node delNode = getNode(key);
        root = remove(root,key);
        return delNode != null ? delNode.value : null;
    }
    private Node remove(Node node,K key) {
        if(node == null) {
            return null;
        }
        if(key.compareTo(node.key) > 0) {
            node.right = remove(node.right ,key);
            return node;
        } else if(key.compareTo(node.key) < 0) {
            node.left = remove(node.left, key);
            return node;
        } else {
            if(node.left == null) {
                Node rightNode = node.right;
                node.right = null;
                size--;
                return rightNode;
            } else if(node.right ==null) {
                Node leftNode = node.left;
                node.left = null;
                size--;
                return leftNode;
            } else {
                Node successor = minimum(node.right);
                successor.right = removeMin(node.right);
                successor.left = node.left;
                node.right = node.left = null;
                return successor;
            }
        }
    }
    private Node minimum(Node node) {
        if (node.left == null) {
            return node;
        }
        return minimum(node.left);
    }
    private Node removeMin(Node node) {
        if (node.left == null) {
            Node rightNode = node.right;
            node.right = null;
            size--;
            return rightNode;
        }
        node.left = removeMin(node.left);
        return node;
    }
    @Override
    public boolean contains(K key) {
        return getNode(root,key) != null;
    }

    @Override
    public V get(K key) {
        Node node = getNode(key);
        return node != null ? node.value :  null;
    }

    @Override
    public void set(K key, V newValue) {
        Node node = getNode(key);
        if(node == null) {
            throw new IllegalArgumentException("Map is empty");
        }
        node.value = newValue;
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
        return getNode(root,key);
    }
    private Node getNode(Node node,K key) {
        if(node == null) {
            return null;
        }
        if(node.key.compareTo(key) == 0) {
            return node;
        } else if(node.key.compareTo(key) > 0) {
            return getNode(node.left,key);
        } else {
            return getNode(node.right,key);
        }
    }
}
