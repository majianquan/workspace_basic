package old.common.a_sort.quickSort;


import common.a_sort.insertSort.InsertSortAdvance;

public class QuickSort2 {
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
        int p = partition(arr,l,r);
        quickSort(arr,l,p-1);
        quickSort(arr,p+1,r);
    }
    // 对arr[l...r]部分进行partition操作
    // 返回p, 使得arr[l...p-1] < arr[p] ; arr[p+1...r] > arr[p]
    private static int partition(Comparable[] arr, int l, int r) {
        // 随机在arr[l...r]的范围中, 选择一个数值作为标定点pivot
        swap( arr, l , (int)(Math.random()*(r-l+1))+l );
        Comparable v = arr[l];

        // arr[l+1,...,i]<= v ,arr[j...r] >=v
        int i = l + 1,j = r;
        while (true) {
            while (i<=r && arr[i].compareTo(v) < 0){
                i++;
            }
            while (j >=l+1 && arr[j].compareTo(v) > 0) {
                j--;
            }
            if(i > j) {
                break;
            }
            swap(arr,i,j);
            i++;
            j--;
        }
        return j;
    }
    private static void swap(Object[] arr, int i, int j) {
        Object t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }

}
