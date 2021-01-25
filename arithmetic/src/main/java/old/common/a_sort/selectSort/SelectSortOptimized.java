package old.common.a_sort.selectSort;

public class SelectSortOptimized {
    public static void sort(Comparable[] arr) {
        int left = 0;
        int right = arr.length - 1;
        while (left < right) {
            int minIndex = left;
            int maxIndex = right;
            if(arr[minIndex].compareTo(arr[maxIndex]) > 0) {
                swap(arr, left, right);
            }
            // 从中间找出最大的值,
            // 从中间找出最小的值
            for (int i = left + 1; i < right ; i++) {
                if(arr[i].compareTo(arr[minIndex]) < 0) {
                    minIndex = i;
                } else if(arr[i].compareTo(arr[maxIndex]) > 0) {
                    maxIndex = i;
                }
            }
            swap(arr,left, minIndex);
            swap(arr,right,maxIndex);
            // left跟最小值互换
            // right跟最大值互换
            left++;
            right--;
        }
    }

    private static void swap(Object[] arr, int i, int j) {
        Object t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }
}
