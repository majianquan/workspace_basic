package old.common.a_sort.bubbleSort;

public class BubbleSort {
    public static void sort(Comparable[] arr) {
        int n = arr.length;
        for (int j = 0; j < n; j++) {
            for (int i = 0; i < n -j - 1; i++) {
                if(arr[i].compareTo(arr[i+1]) > 0) {
                    swap(arr,i, i + 1);
                }
            }
        }
    }
    private static void swap(Object[] arr, int i, int j) {
        Object t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }
}
