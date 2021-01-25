package old.common.a_sort.selectSort;

import common.a_sort.SortTestHelper;

public class Main {
    public static void main(String[] args) {
        test();
        test4();
    }
    public static void test() {
        // 测试排序算法辅助函数
        int N = 20000;
        Integer[] a = SortTestHelper.generateRandomArray(N, 0, 100000);
        SortTestHelper.testSort("common.selectSort.SelectSortComparable",a);
    }
    public static void test1() {
        // 测试Double
        Double[] b = {4.4, 3.3, 2.2, 1.1};
        SelectSortComparable.sort(b);
        SortTestHelper.printArray(b);

    }
    public static void test2() {
        // 测试String
        String[] c = {"D", "C", "B", "A"};
        SelectSortComparable.sort(c);
        SortTestHelper.printArray(c);
    }
    public static void test3() {
        // 测试自定义的类 Student
        Student[] d = new Student[4];
        d[0] = new Student("D",90);
        d[1] = new Student("C",100);
        d[2] = new Student("B",95);
        d[3] = new Student("A",95);
        SelectSortComparable.sort(d);
        SortTestHelper.printArray(d);
    }
    public static void test4() {
        // 测试排序算法辅助函数
        int N = 20000;
        Integer[] a = SortTestHelper.generateRandomArray(N, 0, 100000);
        SortTestHelper.testSort("common.selectSort.SelectSortOptimized",a);
    }
}
