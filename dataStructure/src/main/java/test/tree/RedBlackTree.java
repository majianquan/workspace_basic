package test.tree;

import java.util.LinkedList;

public class RedBlackTree<K extends Comparable<K>, V> {
    private static final boolean BLACK = false;
    private static final boolean RED = true;

    // 树中的节点为私有的类, 外界不需要了解红黑树节点的具体实现
    private class Node {
        private K key;
        private V value;
        private Node left, right;
        private boolean color;

        public Node(K key, V value) {
            this.key = key;
            this.value = value;
            left = right = null;
            color = RED;
        }

        public Node(Node node) {
            this.key = node.key;
            this.value = node.value;
            this.left = node.left;
            this.right = node.right;
            this.color = node.color;
        }
    }

    private Node root;  // 根节点
    private int count;  // 树种的节点个数

    // 构造函数, 默认构造一棵空红黑树
    public RedBlackTree() {
        root = null;
        count = 0;
    }

    // 返回红黑树的节点个数
    public int size() {
        return count;
    }

    // 返回红黑树是否为空
    public boolean isEmpty() {
        return count == 0;
    }

    // 向红黑树中插入一个新的(key, value)数据对
    public void insert(K key, V value) {
        root = insert(root, key, value);
        root.color = BLACK;
    }

    // 查看红黑树中是否存在键key
    public boolean contain(K key) {
        return contain(root, key);
    }

    // 在红黑树中搜索键key所对应的值。如果这个值不存在, 则返回null
    public V search(K key) {
        return search(root, key);
    }

    // 红黑树的前序遍历
    public void preOrder() {
        preOrder(root);
    }

    // 红黑树的中序遍历
    public void inOrder() {
        inOrder(root);
    }

    // 红黑树的后序遍历
    public void postOrder() {
        postOrder(root);
    }

    // 红黑树的层序遍历
    public void levelOrder() {

        // 我们使用LinkedList来作为我们的队列
        LinkedList<Node> q = new LinkedList<Node>();
        q.add(root);
        while (!q.isEmpty()) {

            Node node = q.remove();

            System.out.println(node.key);

            if (node.left != null)
                q.add(node.left);
            if (node.right != null)
                q.add(node.right);
        }
    }

    // 寻找红黑树的最小的键值
    public K minimum() {
        assert count != 0;
        Node minNode = minimum(root);
        return minNode.key;
    }

    // 寻找红黑树的最大的键值
    public K maximum() {
        assert count != 0;
        Node maxNode = maximum(root);
        return maxNode.key;
    }

    // 从红黑树中删除最小值所在节点
    public void removeMin() {
        if (root != null)
            root = removeMin(root);
    }

    // 从红黑树中删除最大值所在节点
    public void removeMax() {
        if (root != null)
            root = removeMax(root);
    }

    // 从红黑树中删除键值为key的节点
    public void remove(K key) {
        root = remove(root, key);
    }

    // 寻找key的floor值, 递归算法
    // 如果不存在key的floor值(key比BST中的最小值还小), 返回NULL
    public K floor(K key) {

        if (count == 0 || key.compareTo(minimum()) < 0)
            return null;

        Node floorNode = floor(root, key);
        return floorNode.key;
    }

    // 寻找key的ceil值, 递归算法
    // 如果不存在key的ceil值(key比BST中的最大值还大), 返回NULL
    K ceil(K key) {

        if (count == 0 || key.compareTo(maximum()) > 0)
            return null;

        Node ceilNode = ceil(root, key);
        return ceilNode.key;
    }

    //********************
    //* 红黑树的辅助函数
    //********************

    // 向以node为根的红黑树中, 插入节点(key, value), 使用递归算法
    // 返回插入新节点后的红黑树的根
    private Node insert(Node node, K key, V value) {

        if (node == null) {
            count++;
            return new Node(key, value);
        }

        if (key.compareTo(node.key) == 0)
            node.value = value;
        else if (key.compareTo(node.key) < 0)
            node.left = insert(node.left, key, value);
        else    // key > node->key
            node.right = insert(node.right, key, value);
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
    private boolean isRed(Node node) {
        if (node == null) {
            return BLACK;
        }
        return node.color;
    }
    // 红黑树中添加节点 ,左旋转
    private Node leftRotate(Node node) {
        Node x = node.right;
        node.right = x.left;
        x.left = node;
        x.color = node.color;
        node.color = RED;
        return x;
    }
    // 红黑树中添加节点,右旋转
    private Node rightRotate(Node node) {
        Node x = node.left;
        node.left  = x.right;
        x.right= node;
        x.color = node.color;
        node.color = RED;
        return x;
    }
    // 颜色翻转
    private void flipColors(Node node) {
        node.color = RED;
        node.left.color = BLACK;
        node.right.color = BLACK;
    }
    // 查看以node为根的红黑树中是否包含键值为key的节点, 使用递归算法
    private boolean contain(Node node, K key) {

        if (node == null)
            return false;

        if (key.compareTo(node.key) == 0)
            return true;
        else if (key.compareTo(node.key) < 0)
            return contain(node.left, key);
        else // key > node->key
            return contain(node.right, key);
    }

    // 在以node为根的红黑树中查找key所对应的value, 递归算法
    // 若value不存在, 则返回NULL
    private V search(Node node, K key) {

        if (node == null)
            return null;

        if (key.compareTo(node.key) == 0)
            return node.value;
        else if (key.compareTo(node.key) < 0)
            return search(node.left, key);
        else // key > node->key
            return search(node.right, key);
    }

    // 对以node为根的二叉搜索树进行前序遍历, 递归算法
    private void preOrder(Node node) {

        if (node != null) {
            System.out.println(node.key);
            preOrder(node.left);
            preOrder(node.right);
        }
    }

    // 对以node为根的二叉搜索树进行中序遍历, 递归算法
    private void inOrder(Node node) {

        if (node != null) {
            inOrder(node.left);
            System.out.println(node.key);
            inOrder(node.right);
        }
    }

    // 对以node为根的二叉搜索树进行后序遍历, 递归算法
    private void postOrder(Node node) {

        if (node != null) {
            postOrder(node.left);
            postOrder(node.right);
            System.out.println(node.key);
        }
    }

    // 返回以node为根的红黑树的最小键值所在的节点
    private Node minimum(Node node) {
        if (node.left == null)
            return node;

        return minimum(node.left);
    }

    // 返回以node为根的红黑树的最大键值所在的节点
    private Node maximum(Node node) {
        if (node.right == null)
            return node;

        return maximum(node.right);
    }

    // 删除掉以node为根的红黑树中的最小节点
    // 返回删除节点后新的红黑树的根
    private Node removeMin(Node node) {

        if (node.left == null) {

            Node rightNode = node.right;
            node.right = null;
            count--;
            return rightNode;
        }

        node.left = removeMin(node.left);
        return node;
    }

    // 删除掉以node为根的红黑树中的最大节点
    // 返回删除节点后新的红黑树的根
    private Node removeMax(Node node) {

        if (node.right == null) {

            Node leftNode = node.left;
            node.left = null;
            count--;
            return leftNode;
        }

        node.right = removeMax(node.right);
        return node;
    }

    // 删除掉以node为根的红黑树中键值为key的节点, 递归算法
    // 返回删除节点后新的红黑树的根
    private Node remove(Node node, K key) {

        if (node == null)
            return null;

        if (key.compareTo(node.key) < 0) {
            node.left = remove(node.left, key);
            return node;
        } else if (key.compareTo(node.key) > 0) {
            node.right = remove(node.right, key);
            return node;
        } else {   // key == node->key

            // 待删除节点左子树为空的情况
            if (node.left == null) {
                Node rightNode = node.right;
                node.right = null;
                count--;
                return rightNode;
            }

            // 待删除节点右子树为空的情况
            if (node.right == null) {
                Node leftNode = node.left;
                node.left = null;
                count--;
                return leftNode;
            }

            // 待删除节点左右子树均不为空的情况

            // 找到比待删除节点大的最小节点, 即待删除节点右子树的最小节点
            // 用这个节点顶替待删除节点的位置
            Node successor = new Node(minimum(node.right));
            count++;

            successor.right = removeMin(node.right);
            successor.left = node.left;

            node.left = node.right = null;
            count--;

            return successor;
        }
    }

    // 在以node为根的二叉搜索树中, 寻找key的floor值所处的节点, 递归算法
    private Node floor(Node node, K key) {

        if (node == null)
            return null;

        // 如果node的key值和要寻找的key值相等
        // 则node本身就是key的floor节点
        if (node.key.compareTo(key) == 0)
            return node;

        // 如果node的key值比要寻找的key值大
        // 则要寻找的key的floor节点一定在node的左子树中
        if (node.key.compareTo(key) > 0)
            return floor(node.left, key);

        // 如果node->key < key
        // 则node有可能是key的floor节点, 也有可能不是(存在比node->key大但是小于key的其余节点)
        // 需要尝试向node的右子树寻找一下
        Node tempNode = floor(node.right, key);
        if (tempNode != null)
            return tempNode;

        return node;
    }


    // 在以node为根的二叉搜索树中, 寻找key的ceil值所处的节点, 递归算法
    Node ceil(Node node, K key) {

        if (node == null)
            return null;

        // 如果node的key值和要寻找的key值相等
        // 则node本身就是key的ceil节点
        if (node.key.compareTo(key) == 0)
            return node;

        // 如果node的key值比要寻找的key值小
        // 则要寻找的key的ceil节点一定在node的右子树中
        if (node.key.compareTo(key) < 0)
            return ceil(node.right, key);

        // 如果node->key > key
        // 则node有可能是key的ceil节点, 也有可能不是(存在比node->key小但是大于key的其余节点)
        // 需要尝试向node的左子树寻找一下
        Node tempNode = ceil(node.left, key);
        if (tempNode != null)
            return tempNode;

        return node;
    }

}
