package old.common.a_sort.bubbleSort;

public class BubbleSortWhileOptimize {
    private static void sort(Comparable[] arr) {
        int n = arr.length;
        int newn;
        do {
            newn = 0;
            for (int i = 0; i < n; i++) {
                if(arr[i-1].compareTo(arr[i]) > 0) {
                    swap(arr,i-1, i);
                    newn = i;
                }
            }
            n = newn;
        }while (newn >0);
    }
    private static void swap(Object[] arr, int i, int j) {
        Object t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }
}
