package test.tree;

public class SegmentTree<E> {
    private E[] data;
    private E[] tree;
    private Merger<E> merger;
    public SegmentTree(E[] arr, Merger<E> merger) {
        this.merger = merger;
        data = (E[]) new Object[arr.length];
        for (int i = 0; i < arr.length; i++) {
            data[i] = arr[i];
        }
        // 数组表示的完全二叉树,所需要的4n的容量
        tree = (E[])new Object[4 * arr.length];
        // 构建线段树
        buildSegmentTree(0, 0, data.length -1);
    }
    // 在treeIndex的位置创建表示区间[l...r]的线段树
    private void buildSegmentTree(int treeIndex, int l, int r) {
        // 递归到底的情况就是,当了l==r的时候,也就是最后的叶子节点
        if(l == r) {
            tree[treeIndex] = data[l];
            return;
        }
        // 得到左右两个孩子的的索引
        int leftChildIndex = leftChild(treeIndex);
        int rightChildIndex = rightChild(treeIndex);
        // 获取中间值
        int mid = l + (r - l) / 2;
        // 返回左右两个孩子的值
        buildSegmentTree(leftChildIndex,l,mid);
        buildSegmentTree(rightChildIndex,mid + 1, r);
        // 区间值进行合并
        tree[treeIndex] = merger.merge(tree[leftChildIndex],tree[rightChildIndex]);
    }
    // 查询某个区间的信息
    public E query(int l, int r) {
        if(l < 0 || l >= data.length || r < 0 || r > data.length) {
            throw new IllegalArgumentException("segment is illegal");
        }
        return query(0,0,data.length -1,l,r);
    }
    private E query(int treeIndex,int l, int r,int qL, int qR) {
        // 最基本的情况
        if(l == qL && r == qR) {
            return tree[treeIndex];
        }

        int mid = l + (r - l) / 2;
        int leftChildIndex = leftChild(treeIndex);
        int rightChildIndex = rightChild(treeIndex);
        if(qL >= mid + 1) {
            return query(rightChildIndex,mid+1,r,qL,qR);
        } else if(qR <= mid) {
            return query(leftChildIndex,l,mid,qL,qR);
        } else {
            return merger.merge(query(leftChildIndex,l,mid,qL,mid),query(rightChildIndex, mid + 1, r, mid+1, qR));
        }
    }
    // 根据获取某个节点值
    public E get(int index) {
        if(index < 0 || index >= data.length) {
            throw new IllegalArgumentException("index is  illegal");
        }
        return data[index];
    }
    // 返回节点的个数
    public int getSize() {
        return data.length;
    }
    // 返回完全二叉树的数组表示中, 一个索引所表示的的元素的左孩子节点的索引
    private int leftChild(int index) {
        return 2 * index + 1;
    }
    // 返回完全二叉树的数组表示中, 一个索引所表示的的元素的右孩子节点的索引
    private int rightChild(int index) {
        return 2 * index + 2;
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < tree.length; i++) {
            if(tree[i] != null) {
                res.append(tree[i]);
            } else {
                res.append("null");
            }
            if(i != tree.length -1) {
                res.append(", ");
            }
        }
        return res.toString();
    }
}
