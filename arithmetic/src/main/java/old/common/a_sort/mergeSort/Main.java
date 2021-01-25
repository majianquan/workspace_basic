package old.common.a_sort.mergeSort;


import common.a_sort.SortTestHelper;

public class Main {
    public static void main(String[] args) {
        int N = 1000000;
        Integer[] arr = SortTestHelper.generateRandomArray(N, 0, 100000);
        SortTestHelper.testSort("common.mergeSort.MergeSort", arr);
        Integer[] arr2 = SortTestHelper.generateRandomArray(N, 0, 100000);
        SortTestHelper.testSort("common.shellSort.ShellSortTwo", arr2);
    }
}
