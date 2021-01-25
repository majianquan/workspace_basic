package old.common.a_sort.selectSort;

public class SelectSortComparable {
    public static void sort(Comparable[] arr) {
        int length = arr.length;
        for (int i = 0; i < length; i++) {
            int minIndex = i;
            for (int j = i+1; j <length ; j++) {
                if(arr[j].compareTo(arr[minIndex]) < 0) {
                    minIndex = j;
                }
            }
            swap(arr, i, minIndex);
        }
    }
    public static void swap(Object[] arr, int i, int minIndex) {
        Object t = arr[i];
        arr[i] = arr[minIndex];
        arr[minIndex] = t;
    }
}
