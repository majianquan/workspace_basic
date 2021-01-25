package demo.tree;

public class SegmentTree<E> {
    private final E[] tree;
    private final E[] data;
    private final Merger<E> merger;

    public SegmentTree(E[] arr, Merger<E> merger) {
        this.tree = (E[]) new Object[4 * arr.length];
        this.data = (E[]) new Object[arr.length];
        this.merger = merger;
        for (int i = 0; i < arr.length; i++) {
            data[i] = arr[i];
        }
        buildSegmentTree(0, 0, data.length - 1);
    }

    private void buildSegmentTree(int treeIndex, int l, int r) {
        if (l == r) {
            tree[treeIndex] = data[l];
            return;
        }
        int leftTreeIndex = leftChild(treeIndex);
        int rightTreeIndex = rightChild(treeIndex);
        int mid = l + (r - l) / 2;
        buildSegmentTree(leftTreeIndex, l, mid);
        buildSegmentTree(rightTreeIndex, mid + 1, r);
        tree[treeIndex] = this.merger.merge(tree[leftTreeIndex], tree[rightTreeIndex]);
    }

    public int leftChild(int index) {
        return index * 2 + 1;
    }

    public int rightChild(int index) {
        return index * 2 + 2;
    }

    public E get(int index) {
        if (index < 0 || index >= data.length) {
            throw new IllegalArgumentException("Index is illegal");
        }
        return data[index];
    }

    public E query(int queryL, int queryR) {
        if (queryL < 0 || queryL >= data.length || queryR < 0 || queryR >= data.length) {
            throw new IllegalArgumentException("Index is illegal");
        }
        return query(0, 0, tree.length - 1, queryL, queryR);
    }

    private E query(int treeIndex, int l, int r, int queryL, int queryR) {
        if (l == queryL && r == queryR) {
            return tree[treeIndex];
        }
        int mid = l + (r - l) / 2;
        int leftTreeIndex = leftChild(treeIndex);
        int rightTreeIndex = rightChild(treeIndex);
        if (queryL >= mid + 1) {
            return query(rightTreeIndex, mid + 1, r, queryL, queryR);
        }
        else if (queryR <= mid) {
            return query(leftTreeIndex, l, mid, queryL, queryR);
        } else {
            E leftResult = query(leftTreeIndex, l, mid, queryL, queryR);
            E rightResult = query(rightTreeIndex, mid + 1, r, queryL, queryR);
            return this.merger.merge(leftResult,rightResult);
        }

    }

    public int getSize() {
        return data.length;
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append("SegmentTree: [");
        for (int i = 0; i < this.tree.length; i++) {
            if (this.tree[i] != null) {
                res.append(this.tree[i]);
            } else {
                res.append("null");
            }
            if (i != this.tree.length - 1) {
                res.append(", ");
            }
        }
        res.append("]");
        return res.toString();
    }
}
