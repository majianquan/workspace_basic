package old.common.a_sort.insertSort;

import common.a_sort.SortTestHelper;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
//        test1();
        test2();
    }

    private static void test2() {
        int N = 20000;
        System.out.println("Test for random array, size = " + N + " , random range [0, " + N + "]");
        Integer[] arr1 = SortTestHelper.generateRandomArray(N, 0, N);
        Integer[] arr2 = Arrays.copyOf(arr1, arr1.length);
        Integer[] arr3 = Arrays.copyOf(arr1, arr1.length);
        SortTestHelper.testSort("common.selectSort.SelectSortComparable",arr1);
        SortTestHelper.testSort("common.insertSort.InsertSort",arr2);
        SortTestHelper.testSort("common.insertSort.InsertSortAdvance",arr3);
    }

    public static void test1() {
        Integer[] arr = {10,9,8,7,6,5,4,3,2,1};
        InsertSort.sort(arr);
        SortTestHelper.printArray(arr);
    }
}
