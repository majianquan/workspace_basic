package test.heap;

import test.array.Array;

public class MaxHeap<E extends Comparable> {
    private Array<E> data;

    public MaxHeap(int capacity) {
        this.data = new Array<>(capacity);
    }

    public MaxHeap(E[] arr) {
        data = new Array<>(arr);
        for (int i = parent(arr.length -1); i >= 0; i--) {
            shitUp(i);
        }
    }

    public MaxHeap() {
        this.data = new Array<>();
    }

    // 获取父亲节点的索引
    private int parent(int index) {
        if(index == 0) {
            throw new IllegalArgumentException("index-0 does't have parent");
        }
        return (index -1) / 2;
    }
    // 根据index获取左孩子索引
    private int leftChild(int index) {
        return index * 2 + 1;
    }
    // 根据index获取该节点的右孩子索引
    private int rightChild(int index) {
        return index * 2 + 2;
    }
    // 获取最大的元素
    public E findMax() {
        if(data.getSize() == 0) {
            throw new IllegalArgumentException("Can not findMax when heap is empty");
        }
        return data.get(0);
    }
    public int size() {
        return data.getSize();
    }
    // 添加元素
    public void add(E e) {
        data.addLast(e);
        shitUp(data.getSize() - 1);
    }
    // 上浮
    private void shitUp(int index) {
        while (index > 0 && data.get(parent(index)).compareTo(data.get(index)) < 0) {
            data.swap(index,parent(index));
            index = parent(index);
        }
    }
    // 取出堆中最大的元素.
    public E extractMax() {
        E ret = findMax();
        data.swap(0,data.getSize() -1);
        data.remove(data.getSize() -1);
        shitDown(0);
        return ret;
    }
    // 下沉
    private void shitDown(int index) {
        // 当循环到最后的叶子节点时退出循环
        while (leftChild(index) < data.getSize()) {
            int j = leftChild(index);
            // 如果有右节点,对比左右两个节点谁大
            if(j+1 < data.getSize() && data.get(j+1).compareTo(data.get(j)) > 0) {
                j = rightChild(index);
            }
            // 如果父节点大于或等于孩子中最大的元素,则什么不用做
            if(data.get(index).compareTo(data.get(j)) >= 0) {
                break;
            }
            // 如果父节点小于孩子中最大的元素,则对调
            data.swap(index,j);
            // 更新index,往下循环
            index = j;
        }
    }
    // 取出堆中的最大元素,然后在放入一个新的元素
    public E replace(E e) {
        E ret = findMax();
        data.set(0,e);
        shitDown(0);
        return ret;
    }
}
