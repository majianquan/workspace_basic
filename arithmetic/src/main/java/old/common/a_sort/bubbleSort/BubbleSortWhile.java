package old.common.a_sort.bubbleSort;

import common.a_sort.SortTestHelper;

public class BubbleSortWhile {
    private static void sort(Comparable[] arr) {
        int n = arr.length;
        boolean swapped = false;
        do {
            swapped = false;
            for (int i = 1; i < n; i++) {
                if(arr[i-1].compareTo(arr[i]) > 0) {
                    swap(arr,i-1, i);
                    swapped = true;
                }
            }
            n--;
        }while (swapped);
    }
    private static void swap(Object[] arr, int i, int j) {
        Object t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }

    public static void main(String[] args) {
        Integer[] arr = {10,9,8,7,6,5,4,3,2,1};
        BubbleSortWhile.sort(arr);
        SortTestHelper.printArray(arr);
    }
}
