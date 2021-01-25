package demo.tree;

public class UnionFind1 implements UF {
    private int[] id;

    public UnionFind1(int size) {
        this.id = new int[size];
        for (int i = 0; i < size; i++) {
            id[i] = i;
        }
    }
    // 查看元素p和原始q是否同属于一个集合编号
    @Override
    public boolean isConnected(int p, int q) {
        return find(p) == find(q);
    }

    @Override
    public void unionElement(int p, int q) {
        int pId = find(p);
        int qId = find(q);
        if(pId == qId) {
            return;
        }
        for (int i = 0; i < getSize(    ); i++) {
            if(id[i] == pId) {
                id[i] = qId;
            }
        }
    }
    // 查找元素p所对应的集合编号
    private int find(int p) {
        if(p < 0 && p >= id.length) {
            throw new IllegalArgumentException("p is out of bound.");
        }
        return id[p];
    }
    @Override
    public int getSize() {
        return id.length;
    }
}
