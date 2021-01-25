package demo.array;

public class MyArrayList<E> {
    private int capacity;
    private int size;
    private E[] data;

    public MyArrayList(int capacity) {
        this.capacity = capacity;
        data = (E[]) new Object[capacity];
        size = 0;
    }

    public MyArrayList() {
        this(10);
    }

    public MyArrayList(E[] arr) {
        data = (E[]) new Object[arr.length];
        for (int i = 0; i < arr.length; i++) {
            data[i] = arr[i];
        }
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

    // 向所有元素后添加一个新的元素
    public void addLast(E e) {
        add(size, e);
    }

    public void addFirst(E e) {
        add(0, e);
    }

    // 在第index个位置插入一个新元素e
    public void add(int index, E e) {

        if (index < 0 || index > size) {
            throw new IllegalArgumentException("add failed , index >= 0 or index < size");
        }
        // if(size == data.length) {
        //     throw new IllegalArgumentException("addList failed , Array is full");
        // }
        // 动态扩容
        if (size == data.length) {
            resize(2 * data.length);
        }
        for (int i = size - 1; i >= index; i--) {
            data[i + 1] = data[i];
        }
        data[index] = e;
        size++;
    }

    private void resize(int newCapacity) {
        capacity = newCapacity;
        E[] newData = (E[]) new Object[newCapacity];
        for (int i = 0; i < size; i++) {
            newData[i] = data[i];
        }
        data = newData;
    }

    public void set(int index, E e) {
        data[index] = e;
    }

    // 获取index索引位置的元素
    public E get(int index) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException(("get failed Index is illegal"));
        }
        return data[index];
    }

    public E getFirst() {
        return get(0);
    }

    public E getLast() {
        return get(size - 1);
    }

    // 数组是否包含某个值
    public boolean contains(E e) {
        return find(e) == -1 ? false : true;
    }

    // 删除指定位置元素
    public E remove(int index) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException(("remove fail,Index is illegal"));
        }
        E ret = data[index];
        for (int i = index + 1; i < size; i++) {
            data[i - 1] = data[i];
        }
        size--;
        data[size] = null;
        if (size == capacity / 4 && data.length / 2 != 0) {
            resize(data.length / 2);
        }
        return ret;
    }

    public E removeFirst() {
        return remove(0);
    }

    public E removeLast() {
        return remove(size - 1);
    }

    public void removeElement(E e) {
        int index = find(e);
        if (index != -1) {
            remove(index);
        }
    }

    // 查找元素对应的索引
    public int find(E e) {
        for (int i = 0; i < size; i++) {
            if (data[i].equals(e)) {
                return i;
            }
        }
        return -1;
    }

    public void swap(int i, int j) {
        if (i < 0 || i >= size || j < 0 || j >= size) {
            throw new IllegalArgumentException("index is illegal");
        }
        E temp = data[i];
        data[i] = data[j];
        data[j] = temp;
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        str.append(String.format("Array: size = %d, capacity = %d\n", size, capacity));
        str.append('[');
        for (int i = 0; i < size; i++) {
            str.append(data[i]);
            if (i != size - 1) {
                str.append(", ");
            }
        }
        str.append(']');
        return str.toString();
    }
}
