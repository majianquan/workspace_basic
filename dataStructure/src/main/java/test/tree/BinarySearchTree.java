package test.tree;

import test.queue.LinkedListQueue;

public class BinarySearchTree<E extends Comparable> {
    private Node root;
    private int size;

    public BinarySearchTree() {
        this.root = null;
    }

    public int getSize() {
        return size;
    }
    // 是否包含某个值
    public boolean contains(E e) {
        return contains(root,e);
    }
    public boolean contains(Node node, E e) {
        if(node == null) {
            return false;
        }
        if(e.compareTo(node.e) == 0) {
            return true;
        } else if(e.compareTo(node.e) > 0) {
            return contains(node.right,e);
        } else {
            return contains(node.left,e);
        }
    }
    // 添加元素
    public void add(E e) {
        root = add(root,e);
    }
    public Node add(Node node, E e) {
        if(node == null) {
            size++;
            return new Node(e);
        } else {
            if(e.compareTo(node.e) > 0) {
                node.right = add(node.right,e);
            } else if(e.compareTo(node.e) < 0) {
                node.left = add(node.left,e);
            }
            return node;
        }
    }
    // 寻找最小的节点的值
    public E minmum() {
        if (size == 0) {
            throw new IllegalArgumentException("BST is empty");
        }
        return minmum(root).e;
    }
    private Node minmum(Node node) {
        if(node.left == null) {
            return node;
        }
        return minmum(node);
    }
    // 寻找最大节点的值
    public E maxmum() {
        if (size == 0) {
            throw new IllegalArgumentException("BST is empty");
        }
        return maxmum(root).e;
    }
    private Node maxmum(Node node) {
        if(node.right == null) {
            return node;
        }
        return maxmum(node);
    }
    // 删除最小的元素
    public E removeMin() {
        if (size == 0) {
            throw new IllegalArgumentException("BST is empty");
        }
        Node result = minmum(root);
        root = removeMin(root);
        return result.e;
    }
    private Node removeMin(Node node) {
        if(node.left == null) {
            Node rightNode = node.right;
            node.right = null;
            size--;
            return rightNode;
        }
        return removeMin(node.left);

    }
    // 删除最大的元素
    public E removeMax() {
        if (size == 0) {
            throw new IllegalArgumentException("BST is empty");
        }
        Node result = maxmum(root);
        root = removeMax(root);
        return result.e;
    }
    public Node removeMax(Node node) {
        if(node.right == null) {
            Node leftNode = node.left;
            node.left = null;
            size--;
            return leftNode;
        }
        return removeMax(node.right);
    }
    // 删除指定的元素
    public void remove(E e) {
        if (size == 0) {
            throw new IllegalArgumentException("BST is empty");
        }
        root = remove(root,e);
    }
    private Node remove(Node node, E e) {
        if(node == null) {
            return null;
        } else {
            if(e.compareTo(node.e) > 0) {
                return remove(node.right, e);
            } else if(e.compareTo(node.e) < 0) {
                return remove(node.left,e);
            } else {
                if(node.left == null) {
                    Node nodeRight = node.right;
                    node.right = null;
                    size--;
                    return nodeRight;
                } else if(node.right == null) {
                    Node nodeLeft = node.left;
                    node.left = null;
                    size--;
                    return nodeLeft;
                } else {
//                    Node successor = minmum(node.right);
//                    successor.right = removeMin(node.right);
//                    successor.left = node.left;
//                    node.left = node.right = null;
//                    size--;
//                    return successor;
                    Node successor = maxmum(node.left);
                    successor.left = removeMax(node.left);
                    successor.right = node.right;
                    node.left = node.right = null;
                    size--;
                    return successor;
                }
            }
        }
    }
    // 前序遍历
    public void preOrder() {
        preOrder(root);
    }

    private void preOrder(Node node) {
        if (node != null) {
            System.out.println(node.e);
            preOrder(node.left);
            preOrder(node.right);
        }
    }

    // 中序遍历
    public void inOrder() {
        inOrder(root);
    }

    private void inOrder(Node node) {
        if (node != null) {
            inOrder(node.left);
            System.out.println(node.e);
            inOrder(node.right);
        }
    }

    // 后序遍历
    public void postOrder() {
        postOrder(root);
    }

    private void postOrder(Node node) {
        if (node != null) {
            postOrder(node.left);
            postOrder(node.right);
            System.out.println(node.e);
        }
    }

    // 层序遍历(非递归)
    public void levelOrder() {
        LinkedListQueue<Node> queue = new LinkedListQueue<>();
        queue.enqueue(root);
        while (!queue.isEmpty()) {
            Node node = queue.dequeue();
            System.out.println(node.e);
            if(node.left != null) {
                queue.enqueue(node.left);
            }
            if(node.right != null) {
                queue.enqueue(node.right);
            }
        }
    }
    // 二分搜索是否为空
    public boolean isEmpty() {
        return size == 0;
    }
    @Override
    public String toString() {
        return "BinarySearchTree{" +
                "root=" + root +
                ", size=" + size +
                '}';
    }

    private class Node {
        private E e;
        private Node left, right;

        public Node(E e) {
            this.e = e;
            this.left = null;
            this.right = null;
        }
    }
}
