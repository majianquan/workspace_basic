package test.tree;


import java.util.ArrayList;
import java.util.LinkedList;

// 二分搜索树
// 由于K需要能够进行比较，所以需要extends Comparable<K>
public class AVLTree<K extends Comparable<K>, V> {

    // 树中的节点为私有的类, 外界不需要了解二分搜索树节点的具体实现
    private class Node {
        private K key;
        private V value;
        private Node left, right;
        private int height;

        public Node(K key, V value) {
            this.key = key;
            this.value = value;
            left = right = null;
            height = 1;
        }

        public Node(Node node) {
            this.key = node.key;
            this.value = node.value;
            this.left = node.left;
            this.right = node.right;
            this.height = node.height;
        }
    }

    private Node root;  // 根节点
    private int count;  // 树种的节点个数

    // 构造函数, 默认构造一棵空二分搜索树
    public AVLTree() {
        root = null;
        count = 0;
    }
    // 获取节点的高度
    public int getHeight(Node node) {
        if(node == null) {
            return 0;
        }
        return node.height;
    }
    // 获取节点的平衡因子
    public int getBalanceFactor(Node node) {
        if(node == null) {
            return 0;
        }
        return getHeight(node.left) - getHeight(node.right);
    }
    // 判断是否是BST树
    public boolean isBST() {
      ArrayList<K> array  = new ArrayList<>();
      inOrderAdd(root, array);
        for (int i = 1; i < array.size(); i++) {
            if(array.get(i).compareTo(array.get(i -1)) < 0) {
                return false;
            }
        }
        return true;
    }
    // 判断二叉树是否是平衡二叉树
    public boolean isBalanced() {
        return isBalanced(root);
    }

    private boolean isBalanced(Node node) {
        if(node == null) {
            return true;
        }
        int balanceFactor = getBalanceFactor(node);
        if (Math.abs(balanceFactor) > 1) {
            return false;
        } else {
            return isBalanced(node.left) && isBalanced(node.right);
        }
    }

    private void inOrderAdd(Node node, ArrayList<K> array) {
        if (node != null) {
            inOrderAdd(node.left, array);
            array.add(node.key);
            inOrderAdd(node.right, array);
        }
    }

    // 返回二分搜索树的节点个数
    public int size() {
        return count;
    }

    // 返回二分搜索树是否为空
    public boolean isEmpty() {
        return count == 0;
    }

    // 向二分搜索树中插入一个新的(key, value)数据对
    public void insert(K key, V value) {
        root = insert(root, key, value);
    }

    // 查看二分搜索树中是否存在键key
    public boolean contain(K key) {
        return contain(root, key);
    }

    // 在二分搜索树中搜索键key所对应的值。如果这个值不存在, 则返回null
    public V search(K key) {
        return search(root, key);
    }

    // 二分搜索树的前序遍历
    public void preOrder() {
        preOrder(root);
    }

    // 二分搜索树的中序遍历
    public void inOrder() {
        inOrder(root);
    }

    // 二分搜索树的后序遍历
    public void postOrder() {
        postOrder(root);
    }

    // 二分搜索树的层序遍历
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

    // 寻找二分搜索树的最小的键值
    public K minimum() {
        assert count != 0;
        Node minNode = minimum(root);
        return minNode.key;
    }

    // 寻找二分搜索树的最大的键值
    public K maximum() {
        assert count != 0;
        Node maxNode = maximum(root);
        return maxNode.key;
    }

    // 从二分搜索树中删除最小值所在节点
    public void removeMin() {
        if (root != null)
            root = removeMin(root);
    }

    // 从二分搜索树中删除最大值所在节点
    public void removeMax() {
        if (root != null)
            root = removeMax(root);
    }

    // 从二分搜索树中删除键值为key的节点
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
    //* 二分搜索树的辅助函数
    //********************

    // 向以node为根的二分搜索树中, 插入节点(key, value), 使用递归算法
    // 返回插入新节点后的二分搜索树的根
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
        // 更新高度值
        // 取左右子树中最高的,然后+1
        node.height = 1 + Math.max(getHeight(node.left),getHeight(node.right));
        // 计算平衡因子
        int balanceFactor = getBalanceFactor(node);
        if(balanceFactor > 1 && getBalanceFactor(node.left) >= 0) {
            // LL
            return rightRotate(node);
        } else if(balanceFactor < -1 && getBalanceFactor(node.right) <=0){
            // RR
            return leftRotate(node);
        } else if(balanceFactor > 1 && getBalanceFactor(node.left) < 0) {
            // LR
            node.left = leftRotate(node);
            return rightRotate(node);
        } else if(balanceFactor < -1 && getBalanceFactor(node.right) >0) {
            // RL
            node.right = rightRotate(node);
            return leftRotate(node);
        }
        return node;
    }
    // 右旋转
    private Node rightRotate(Node node) {
        Node x = node.left;
        node.left = x.right;
        x.right = node;
        // 更新高度
        node.height = Math.max(getHeight(node.left),getHeight(node.right)) + 1;
        x.height = Math.max(getHeight(x.left),getHeight(x.right)) + 1;
        return x;
    }
    // 左旋转
    private Node leftRotate(Node node) {
        Node x = node.right;
        node.right = x.left;
        x.left = node;
        // 更新节点的高度
        node.height = Math.max(getHeight(node.right), getHeight(node.left)) + 1;
        x.height = Math.max(getHeight(x.right), getHeight(x.left)) + 1;
        return x;
    }

    // 查看以node为根的二分搜索树中是否包含键值为key的节点, 使用递归算法
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

    // 在以node为根的二分搜索树中查找key所对应的value, 递归算法
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

    // 返回以node为根的二分搜索树的最小键值所在的节点
    private Node minimum(Node node) {
        if (node.left == null)
            return node;

        return minimum(node.left);
    }

    // 返回以node为根的二分搜索树的最大键值所在的节点
    private Node maximum(Node node) {
        if (node.right == null)
            return node;

        return maximum(node.right);
    }

    // 删除掉以node为根的二分搜索树中的最小节点
    // 返回删除节点后新的二分搜索树的根
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

    // 删除掉以node为根的二分搜索树中的最大节点
    // 返回删除节点后新的二分搜索树的根
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

    // 删除掉以node为根的二分搜索树中键值为key的节点, 递归算法
    // 返回删除节点后新的二分搜索树的根
    private Node remove(Node node, K key) {

        if (node == null)
            return null;
        Node retNode;
        if (key.compareTo(node.key) < 0) {
            node.left = remove(node.left, key);
            retNode = node;
        } else if (key.compareTo(node.key) > 0) {
            node.right = remove(node.right, key);
            retNode = node;
        } else {   // key == node->key

            // 待删除节点左子树为空的情况
            if (node.left == null) {
                Node rightNode = node.right;
                node.right = null;
                count--;
                retNode = rightNode;
            } else if (node.right == null) {
                // 待删除节点右子树为空的情况
                Node leftNode = node.left;
                node.left = null;
                count--;
                retNode = leftNode;
            } else {
                // 待删除节点左右子树均不为空的情况

                // 找到比待删除节点大的最小节点, 即待删除节点右子树的最小节点
                // 用这个节点顶替待删除节点的位置
                Node successor = new Node(minimum(node.right));
                count++;
                // removeMin并没有维持平衡
                // successor.right = removeMin(node.right);
                // 优化
                // 因为我们要删除右子树中最小的值,而最小值的key又保存在successor中的,
                // 所以可以递归调用remove 方法
                successor.right = remove(node.right,successor.key);
                successor.left = node.left;

                node.left = node.right = null;
                count--;

                retNode = successor;
            }

        }
        // 可能删除节点时叶子节点,存在空指针的情况,
        if(retNode == null) {
            return null;
        }
        // 计算平衡因子
        int balanceFactor = getBalanceFactor(retNode);
        if(balanceFactor > 1 && getBalanceFactor(retNode.left) >= 0) {
            // LL
            return rightRotate(retNode);
        } else if(balanceFactor < -1 && getBalanceFactor(retNode.right) <=0){
            // RR
            return leftRotate(retNode);
        } else if(balanceFactor > 1 && getBalanceFactor(retNode.left) < 0) {
            // LR
            retNode.left = leftRotate(retNode);
            return rightRotate(retNode);
        } else if(balanceFactor < -1 && getBalanceFactor(retNode.right) >0) {
            // RL
            retNode.right = rightRotate(retNode);
            return leftRotate(retNode);
        }
        return retNode;
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


    // 测试二分搜索树
    public static void main(String[] args) {

        int N = 1000000;

        // 创建一个数组，包含[0...N)的所有元素
        Integer[] arr = new Integer[N];
        for (int i = 0; i < N; i++)
            arr[i] = new Integer(i);

        // 打乱数组顺序
        for (int i = 0; i < N; i++) {
            int pos = (int) (Math.random() * (i + 1));
            Integer t = arr[pos];
            arr[pos] = arr[i];
            arr[i] = t;
        }
        // 由于我们实现的二分搜索树不是平衡二叉树，
        // 所以如果按照顺序插入一组数据，我们的二分搜索树会退化成为一个链表
        // 平衡二叉树的实现，我们在这个课程中没有涉及，
        // 有兴趣的同学可以查看资料自学诸如红黑树的实现
        // 以后有机会，我会在别的课程里向大家介绍平衡二叉树的实现的：）


        // 我们测试用的的二分搜索树的键类型为Integer，值类型为String
        // 键值的对应关系为每个整型对应代表这个整型的字符串
        AVLTree<Integer, String> bst = new AVLTree<Integer, String>();
        for (int i = 0; i < N; i++)
            bst.insert(new Integer(arr[i]), Integer.toString(arr[i]));

        // 对[0...2*N)的所有整型测试在二分搜索树中查找
        // 若i在[0...N)之间，则能查找到整型所对应的字符串
        // 若i在[N...2*N)之间，则结果为null
        for (int i = 0; i < 2 * N; i++) {
            String res = bst.search(new Integer(i));
            if (i < N)
                assert res == Integer.toString(i);
            else
                assert res == null;
        }
    }
}