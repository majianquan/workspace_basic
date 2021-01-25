package old.common.a_sort.quickSort;

import common.a_sort.SortTestHelper;

import java.util.Arrays;

public class Main {
    public static final int N = 10000000;
    public static void main(String[] args) {
//        test();
//        test1();
        test2();
    }

    private static void test2() {
        // 测试3 测试存在包含大量相同元素的数组
        System.out.println("Test for random array, size = " + N + " , random range [0,10]");

        Integer[] arr1 = SortTestHelper.generateRandomArray(N, 0, 10);
        Integer[] arr2 = Arrays.copyOf(arr1, arr1.length);
        Integer[] arr3 = Arrays.copyOf(arr1, arr1.length);

        SortTestHelper.testSort("common.quickSort.QuickSort", arr1);
        SortTestHelper.testSort("common.quickSort.QuickSort2", arr2);
        SortTestHelper.testSort("common.quickSort.QuickSort3", arr3);

    }

    private static void test1() {
        // 测试2 测试近乎有序的数组
        int swapTimes = 100;
        assert swapTimes >= 0;

        System.out.println("Test for nearly ordered array, size = " + N + " , swap time = " + swapTimes);

        Integer[] arr1 = SortTestHelper.generateNearlyOrderedArray(N, swapTimes);
        Integer[] arr2 = Arrays.copyOf(arr1, arr1.length);
        Integer[] arr3 = Arrays.copyOf(arr1, arr1.length);

        SortTestHelper.testSort("common.quickSort.QuickSort", arr1);
        SortTestHelper.testSort("common.quickSort.QuickSort2", arr2);
        SortTestHelper.testSort("common.quickSort.QuickSort3", arr3);
    }

    private static void test() {
        // 测试1 一般性测试
        System.out.println("Test for random array, size = " + N + " , random range [0, " + N + "]");

        Integer[] arr1 = SortTestHelper.generateRandomArray(N, 0, N);
        Integer[] arr2 = Arrays.copyOf(arr1, arr1.length);
        Integer[] arr3 = Arrays.copyOf(arr1, arr1.length);

        SortTestHelper.testSort("common.quickSort.QuickSort", arr1);
        SortTestHelper.testSort("common.quickSort.QuickSort2", arr2);
        SortTestHelper.testSort("common.quickSort.QuickSort3", arr3);
    }
}
