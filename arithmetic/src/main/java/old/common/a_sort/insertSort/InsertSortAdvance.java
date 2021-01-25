package old.common.a_sort.insertSort;

public class InsertSortAdvance {
    public static void sort(Comparable[] arr) {
        int length = arr.length;
        for (int i = 0; i < length; i++) {
            Comparable e = arr[i];
            int j = i;
            for (; j > 0 && arr[j-1].compareTo(e) < 0; j--) {
                arr[j] = arr[j -1];
            }
            arr[j] = e;
        }
    }
    // 对arr[l...r]的区间使用InsertionSort排序
    public static void sort(Comparable[] arr, int l, int r){

        for( int i = l + 1 ; i <= r ; i ++ ){
            Comparable e = arr[i];
            int j = i;
            for( ; j > l && arr[j-1].compareTo(e) > 0 ; j--)
                arr[j] = arr[j-1];
            arr[j] = e;
        }
    }
    public static void swap(Object[] arr, int i, int j) {
        Object t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }
}
