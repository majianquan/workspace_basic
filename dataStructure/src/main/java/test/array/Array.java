package test.array;

public class Array<E> {
    private E[] data;
    private int size;
    private int capacity;


    public Array(int capacity) {
        this.data = (E[]) new Object[capacity];
        this.size = 0;
        this.capacity = capacity;
    }

    public Array() {
        this(10);
    }
    public  Array(E[] arr) {
        this.data = (E[]) new Object[capacity];
        for (int i = 0; i < arr.length; i++) {
            this.data[i] = arr[i];
        }
    }

    // 在第index个位置插入一个新元素e
    public void add(int index, E e) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("add failed , index >= 0 or index < size");
        }
        // 数组动态扩容,可以是原来的1.5倍,也可以是2倍
        if(size == data.length) {
            resize(2 * data.length);
        }
        for (int i = size - 1; i >= index; i--) {
            data[i + 1] = data[i];
        }
        data[index] = e;
        size++;
    }

    private void resize(int newCapacity) {
        E[] newData = (E[]) new Object[newCapacity];
        for (int i = 0; i < size; i++) {
            newData[i] = data[i];
        }
        this.capacity = capacity;
        this.data = newData;

    }

    // 在第一个元素中插入元素
    public void addFirst(E e) {
        add(0, e);
    }

    // 向所有元素后添加一个新的元素
    public void addLast(E e) {
        add(size, e);
    }

    // 删除指定位置的元素
    public E remove(int index) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("add failed , index >= 0 or index < size");
        }
        for (int i = index + 1; i < size; i++) {
             data[i -1] = data[i];
        }
        size--;
        data[size-1] = null;
        // 动态缩容,当size小于当前容量的1/4时,缩容为原来的一半
        // 为什么是1/4,因为是为了防止时间复杂度的震荡,
        if (size == capacity / 4 && data.length / 2 != 0) {
            resize(data.length / 2);
        }
        return null;
    }

    // 删除第一个元素
    public E removeFirst() {
        return remove(0);
    }

    // 删除最后一个元素
    public E removeLast() {
        return remove(size - 1);
    }

    // 更新第几个位置的值
    public void set(int index, E e) {
        if (index > size && index < 0) {
            throw new IllegalArgumentException(("get failed Index is illegal"));
        }
        data[index] = e;
    }

    // 获取指定索引的元素
    public E get(int index) {
        if (index > size && index < 0) {
            throw new IllegalArgumentException(("get failed Index is illegal"));
        }
        return data[index];
    }

    // 获取最后一个元素
    public E getLast() {
        return get(size - 1);
    }

    // 获取第一个元素
    public E getFirst() {
        return get(0);
    }

    // 查找元素对应的索引
    public int find(E e) {
        for (int i = 0; i < size; i++) {
            if (e.equals(data[i])) {
                return i;
            }
        }
        return -1;
    }

    // 交换动态数组中的两个元素
    public void swap(int i, int j) {
        if (i > size || i < 0 || j > size || j < 0) {
            throw new IllegalArgumentException(("get failed Index is illegal"));
        }
        E temp = data[i];
        data[i] = data[j];
        data[j] = temp;
    }

    // 是否包含某个元素
    public boolean contains(E e) {
        return find(e) != -1;
    }

    // 获取数组中的元素的个数
    public int getSize() {
        return size;
    }

    // 获取数组的容量
    public int getCapacity() {
        return capacity;
    }

    // 返回数组是否为空
    public boolean isEmpty() {
        return size == 0;
    }

    // 打印动态数组
    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append(String.format("Array: size = %d, capacity = %d\n",size, capacity));
        res.append("data = [");
        for (int i = 0; i < size; i++) {
            res.append(data[i]);
            if (i != size -1) {
                res.append(" ,");
            }
        }
        res.append("]");
        return res.toString();
    }
}
