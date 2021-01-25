package demo.heap;

import demo.array.MyArrayList;

public class MaxHeap<E extends Comparable<E>> {
    private MyArrayList<E> data;
    public MaxHeap(int capacity) {
        data = new MyArrayList<>(capacity);
    }

    public MaxHeap() {
        data = new MyArrayList<>();
    }
    public MaxHeap(E[] arr) {
        data = new MyArrayList<>(arr);
        for (int i = parent(arr.length -1); i >= 0; i--) {
            shitUp(i);
        }
    }
    public int size() {
        return data.getCapacity();
    }
    public boolean isEmpty(){
        return data.isEmpty();
    }
    // 返回完全二叉树的数组表示中, 一个索引所表示的元素的父亲节点的索引
    private int parent(int  index) {
        if(index == 0) {
            throw new IllegalArgumentException("index-0 does't have parent");
        }
        return (index - 1) / 2;
    }
    // 返回完全二叉树的数组表示中,一个索引所表示的元素的左孩子节点的索引
    private int leftChild(int index) {
        return index * 2 + 1;
    }
    // 返回完全二叉树的数组表示中,一个索引所表示的元素的右孩子节点的索引
    private int rightChild(int index) {
        return index * 2 + 2;
    }
    // 向堆中添加元素ShitUp
    public void add(E e) {
        data.addLast(e);
        shitUp(data.getSize() -1);
    }
    private void shitUp(int k) {
        while (k > 0 && data.get(parent(k)).compareTo(data.get(k)) < 0 ) {
            data.swap(k,parent(k));
            k = parent(k);
        }
    }
    public E findMax() {
        if(data.getSize() == 0) {
            throw new IllegalArgumentException("Can not findMax when heap is empty");
        }
        return data.get(0);
    }
    // 取出堆中最大的元素.
    public E extractMax() {
        E ret = findMax();
        data.swap(0,data.getSize() -1);
        data.remove(data.getSize() -1);
        shitDown(0);
        return ret;
    }
    private void shitDown(int k) {
        while (leftChild(k)< data.getSize()) {
            int j = leftChild(k);
            if(j+1 < data.getSize() && data.get(j+1).compareTo(data.get(j))> 0) {
                j = rightChild(k);
            }
            if(data.get(k).compareTo(data.get(j)) >=0) {
                break;
            }
            data.swap(k,j);
            k = j;
        }
    }
    public E replace(E e) {
        E ret = findMax();
        data.set(0,e);
        shitDown(0);
        return ret;
    }
}
