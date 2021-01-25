package old.common.a_sort.quickSort;


import common.a_sort.insertSort.InsertSortAdvance;

public class QuickSort3 {
    public static void sort(Comparable[] arr) {
        int n = arr.length;
        quickSort(arr, 0 , n - 1);
    }

    private static void quickSort(Comparable[] arr, int l, int r) {
        // 对于小规模数组, 使用插入排序
        if( r - l <= 15 ){
            InsertSortAdvance.sort(arr, l, r);
            return;
        }
        // 随机在arr[l...r]的范围中, 选择一个数值作为标定点pivot
        swap( arr, l , (int)(Math.random()*(r-l+1))+l );
        Comparable v = arr[l];

        int lt = l;
        int gt = r+1;
        int i = l+1;
        while (i<gt) {
            if(arr[i].compareTo(v) < 0) {
                swap(arr,i,lt+1);
                i++;
                lt++;
            } else if(arr[i].compareTo(v) > 0) {
                swap(arr,i,gt-1);
                gt--;
            } else {
                i++;
            }
        }
        quickSort(arr,l,lt -1);
        quickSort(arr,gt,r);
    }

    private static void swap(Object[] arr, int i, int j) {
        Object t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }

}
