package test.map;

public class BSTMap<K extends Comparable, V> implements Map<K, V> {
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
            this(key, value, left, null);
        }

        public Node(K key, V value) {
            this(key, value, null, null);
        }

        public Node(K key) {
            this(key, null, null, null);
        }
    }

    public BSTMap(int size, Node root) {
        this.size = 0;
        this.root = null;
    }

    @Override
    public void add(K key, V value) {
        root = add(root, key, value);
    }

    private Node add(Node node, K key, V value) {
        if (node == null) {
            size++;
            return new Node(key, value);
        } else {
            if (node.key.compareTo(key) > 0) {
                node.right = add(node.right, key, value);
            } else if (node.key.compareTo(key) < 0) {
                node.left = add(node.left, key, value);
            } else {
                node.value = value;
            }
            return node;
        }
    }

    @Override
    public V remove(K key) {
        Node node = getNode(root, key);
        root = remove(root,key);
        return node != null ? node.value : null;
    }
    private Node remove(Node node, K key) {
        if(node == null) {
            return null;
        } else {
            if(node.key.compareTo(key) <0) {
                node.right = remove(node.right,key);
                return node;
            } else if(node.key.compareTo(key) > 0) {
                node.left = remove(node.left,key);
                return node;
            } else {
                if(node.left == null) {
                    Node rightNode = node.right;
                    node.right = null;
                    size--;
                    return rightNode;

                } else if(node.right == null) {
                    Node leftNode = node.left;
                    node.left = null;
                    size--;
                    return leftNode;
                } else {
                    Node successor = minmum(node.right);
                    successor.right = removeMin(node.right);
                    successor.left = node.left;
                    size--;
                    node.left = node.right = null;
                    return successor;
                }
            }
        }
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

    private Node minmum(Node node) {
        if (node.left == null) {
            return node;
        }
        return minmum(node.left);
    }

    @Override
    public boolean contains(K key) {
        Node node = getNode(root, key);
        return node != null;
    }

    @Override
    public V get(K key) {
        Node node = getNode(root, key);
        return node != null ? node.value : null;
    }

    @Override
    public void set(K key, V value) {
        Node node = getNode(root, key);
        if (node == null) {
            throw new IllegalArgumentException("dons't exist");
        }
        node.value = value;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    private Node getNode(Node node, K key) {
        if (node == null) {
            return null;
        }
        if (node.key.compareTo(key) > 0) {
            return getNode(node.right, key);
        } else if (node.key.compareTo(key) < 0) {
            return getNode(node.left, key);
        } else {
            return node;
        }
    }
}
