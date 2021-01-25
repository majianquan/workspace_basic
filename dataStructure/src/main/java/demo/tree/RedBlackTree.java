package demo.tree;

import java.util.ArrayList;

/**
 *
 * 红黑树
 * 1.每个节点要么是红色,要么是黑色
 * 2.根节点是黑色
 * 3.每一个叶子节点(最后的空节点) 是黑色
 * 4.如果一个节点是红色的,那么他的孩子节点都是黑色的
 * 5.从任意一个节点到叶子节点, 经过的黑色节点都是一样的
 *
 */
public class RedBlackTree<K extends Comparable<K>,V> {
    private static final boolean RED = true;
    private static final boolean BLACK = false;

    private int size;
    private Node root;

    private class Node {
        private K key;
        private V value;
        private Node left, right;
        private boolean color;
        public Node(K key, V value, Node left, Node right) {
            this.key = key;
            this.value = value;
            this.left = left;
            this.right = right;
            this.color = RED;
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


    private void inOrder(Node node, ArrayList<K> keys) {
        inOrder(node.left, keys);
        keys.add(node.key);
        inOrder(node.right, keys);
    }
    private boolean isRed(Node node) {
        if(node == null) {
            return BLACK;
        }
        return node.color;
    }

    public void add(K key, V value) {
        root = add(root, key, value);
        root.color = BLACK;
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
        if(isRed(node.right) && !isRed(node.left)) {
            node = leftRotate(node);
        }
        if(isRed(node.left) && isRed(node.left.left)) {
            node = rightRotate(node);
        }
        if(isRed(node.left) && isRed(node.right)) {
            flipColors(node);
        }
        return node;
    }

    // 右旋转
    private Node rightRotate(Node node) {
        Node x = node.left;
        node.left = x.right;
        x.right = node;
        x.color = node.color;
        node.color = RED;
        return x;
    }

    // 左旋转
    private Node leftRotate(Node node) {
        Node x = node.right;
        node.right = x.left;
        x.left = node;
        x.color = node.color;
        node.color = RED;
        return x;

    }
    // 颜色反转
    private void flipColors(Node node) {
        node.color = RED;
        node.left.color = BLACK;
        node.right.color = BLACK;
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
