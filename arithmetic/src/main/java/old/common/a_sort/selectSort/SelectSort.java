package old.common.a_sort.selectSort;

public class SelectSort {
    public static void sort(Integer[] arr) {
        int length = arr.length;
        for (int i = 0; i < length; i++) {
            int minIndex = i;
            for (int j = i+1; j <length ; j++) {
                if(arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }
            swap(arr, i, minIndex);
        }
    }

    private static void swap(Integer[] arr, int i, int minIndex) {
        int t = arr[i];
        arr[i] = arr[minIndex];
        arr[minIndex] = t;
    }
}
