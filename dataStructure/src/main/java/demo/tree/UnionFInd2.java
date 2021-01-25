package demo.tree;

/**
 * 并查集
 * 分别基于size和rank的优化,二选一,但是rank的优化最优
 */
public class UnionFInd2 implements UF {
    private int[] parent;
    private int[] sz;  // sz[i]表示以元素i为根的元素的个数 // 基于size的优化
    private int[] rank; // rank[i] 表示以元素i为根集合的深度 // 基于rank的优化
    public UnionFInd2(int size) {
        this.parent = new int[size];
        this.sz = new int[size];
        this.rank = new int[size];
        for (int i = 0; i < size; i++) {
            parent[i] = i;
            sz[i] = 1;
            rank[i] = 1;
        }

    }

    @Override
    public boolean isConnected(int p, int q) {
        return find(p) == find(q);
    }

    @Override
    public void unionElement(int p, int q) {
        int pRoot = find(p);
        int qRoot = find(q);
        if(qRoot == qRoot) {
            return;
        }
        // 根据元素的个数来合并的
//        if(sz[pRoot] < sz[qRoot]) {
//            parent[pRoot] = qRoot;
//            sz[pRoot] += sz[qRoot];
//        } else {
//            parent[qRoot] = pRoot;
//            sz[qRoot] += sz[pRoot];
//        }
        // 根据元素的深度来合并的
        if(rank[pRoot] < rank[qRoot]) {
            parent[pRoot] = qRoot;
        } else if(rank[pRoot] > rank[qRoot]){
            parent[qRoot] = pRoot;
        } else {
            parent[qRoot] = pRoot;
            rank[pRoot] += 1;
        }
    }
    // 查找过程,查找元素p所对应的集合编号
    // O(h) 复杂度 ,h为树的高度
    public int find(int p) {
        if(p < 0 && p >= parent.length) {
            throw new IllegalArgumentException("p is out of bound.");
        }
        while (p != parent[p]) {
            // 路径压缩
            parent[p] = parent[parent[p]]; // 只能压缩成二分树

            p = parent[p];
        }
        return p;
    }
    // 查找最优化,路径压缩
    public int findOpt(int p) {
        if(p < 0 && p >= parent.length) {
            throw new IllegalArgumentException("p is out of bound.");
        }
        if (p != parent[p]) {
            parent[p] = findOpt(parent[p]); // 形成一个深度为1的 多分钟树
        }
        return parent[p];
    }
    @Override
    public int getSize() {
        return parent.length;
    }
}
