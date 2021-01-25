package demo.tree;


import java.util.ArrayList;

public class AVLTree<K extends Comparable, V> {
    private int size;
    private Node root;

    private class Node {
        private K key;
        private V value;
        private Node left, right;
        public int height;

        public Node(K key, V value, Node left, Node right) {
            this.key = key;
            this.value = value;
            this.left = left;
            this.right = right;
            this.height = 1;
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

    public AVLTree() {
        this.size = 0;
        this.root = null;
    }

    public boolean isBST() {
        ArrayList<K> keys = new ArrayList<>();
        inOrder(root, keys);
        for (int i = 1; i < keys.size(); i++) {
            if (keys.get(i - 1).compareTo(keys.get(i)) > 0) {
                return false;
            }
        }
        return true;
    }

    public boolean isBalanced() {
        return isBalanced(root);
    }

    private boolean isBalanced(Node node) {
        if (node == null) {
            return true;
        }
        int balanceFactor = getBalanceFactor(node);
        if (balanceFactor > 1) {
            return false;
        }
        return isBalanced(node.left) && isBalanced(node.right);
    }

    private void inOrder(Node node, ArrayList<K> keys) {
        inOrder(node.left, keys);
        keys.add(node.key);
        inOrder(node.right, keys);
    }

    public void add(K key, V value) {
        root = add(root, key, value);
    }

    private Node add(Node node, K key, V value) {
        if (node == null) {
            size++;
            return new Node(key, value);
        }
        if (node.key.compareTo(key) > 0) {
            node.left = add(node.left, key, value);
        } else if (node.key.compareTo(key) < 0) {
            node.right = add(node.right, key, value);
        } else {
            node.value = value;
        }
        node.height = Math.max(getHeight(node.left), getHeight(node.right));
        int balanceFactor = getBalanceFactor(node);

        System.out.println("balanceFactor: " + Math.abs(balanceFactor));

        if (balanceFactor > 1 && getBalanceFactor(node.left) >= 0) {
            // 右旋转
            return rightRotate(node);
        } else if(balanceFactor > 1 && getBalanceFactor(node.left) < 0) {
            node.left = leftRotate(node.left);
            return rightRotate(node);
        }
        if (balanceFactor < -1 && getBalanceFactor(node.right) <= 0) {
            // 左旋转
            return leftRotate(node);
        } else if(balanceFactor < -1 && getBalanceFactor(node.right) > 0) {
            node.right = rightRotate(node.right);
            return leftRotate(node);
        }
        return node;
    }

    // 右旋转
    private Node rightRotate(Node y) {
        Node x = y.left;
        Node T3 = x.right;
        x.right = y;
        y.left = T3;
        // 更新节点的height值
        y.height = Math.max(getHeight(y.left), getHeight(y.right)) + 1;
        x.height = Math.max(getHeight(x.left), getHeight(x.right)) + 1;
        return x;
    }

    // 左选择
    private Node leftRotate(Node y) {
        Node x = y.right;
        Node T3 = x.left;

        x.left = y;
        y.right = T3;
        // 更新节点的height值
        y.height = Math.max(getHeight(y.left), getHeight(y.right)) + 1;
        x.height = Math.max(getHeight(x.left), getHeight(x.right)) + 1;
        return x;
    }

    public V remove(K key) {
        Node delNode = getNode(key);
        root = remove(root, key);
        return delNode != null ? delNode.value : null;
    }

    private Node remove(Node node, K key) {
        if (node == null) {
            return null;
        }
        if (key.compareTo(node.key) > 0) {
            node.right = remove(node.right, key);
            return node;
        } else if (key.compareTo(node.key) < 0) {
            node.left = remove(node.left, key);
            return node;
        } else {
            if (node.left == null) {
                Node rightNode = node.right;
                node.right = null;
                size--;
                return rightNode;
            } else if (node.right == null) {
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

    public boolean contains(K key) {
        return getNode(root, key) != null;
    }

    public V get(K key) {
        Node node = getNode(key);
        return node != null ? node.value : null;
    }

    public void set(K key, V newValue) {
        Node node = getNode(key);
        if (node == null) {
            throw new IllegalArgumentException("Map is empty");
        }
        node.value = newValue;
    }

    public int getSize() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int getHeight(Node node) {
        if (node == null) {
            return 0;
        }
        return node.height;
    }

    // 获得node的平衡因子
    private int getBalanceFactor(Node node) {
        if (node == null) {
            return 0;
        }
        return getHeight(node.left) - getHeight(node.right);
    }

    private Node getNode(K key) {
        return getNode(root, key);
    }

    private Node getNode(Node node, K key) {
        if (node == null) {
            return null;
        }
        if (node.key.compareTo(key) == 0) {
            return node;
        } else if (node.key.compareTo(key) > 0) {
            return getNode(node.left, key);
        } else {
            return getNode(node.right, key);
        }
    }
}
