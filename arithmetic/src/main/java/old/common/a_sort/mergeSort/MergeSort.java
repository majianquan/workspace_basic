package old.common.a_sort.mergeSort;

import common.a_sort.SortTestHelper;
import common.a_sort.insertSort.InsertSortAdvance;

public class MergeSort {
    public static void sort(Comparable[] arr) {
        int n = arr.length;
        sort(arr,0,n-1);
    }

    private static void sort(Comparable[] arr, int l, int r) {
        // 优化2: 对于小规模数组, 使用插入排序
        if( r - l <= 15 ){
            InsertSortAdvance.sort(arr, l, r);
            return;
        }
        int mid = l + (r - l) / 2;
        sort(arr,l,mid);
        sort(arr,mid+1,r);


        // 优化1: 对于arr[mid] <= arr[mid+1]的情况,不进行merge
        // 对于近乎有序的数组非常有效,但是对于一般情况,有一定的性能损失
        if(arr[mid] .compareTo(arr[mid+1]) > 0) {
            merge(arr,l,mid,r);
        }
    }
    // 将arr[l...mid]和arr[mid+1...r]两部分进行归并
    private static void merge(Comparable[] arr, int l, int mid, int r) {
        Comparable[] aux = new Comparable[r - l + 1];
        for (int i = l; i <= r; i++) {
            aux[i-l] = arr[l];
        }
        // 初始化，i指向左半部分的起始索引位置l；j指向右半部分起始索引位置mid+1
        int i = l,j = mid + 1;
        for (int k = l; k <= r; k++) {

            if(i > mid) { // 如果左半部分元素已经全部处理完毕
                arr[k] = aux[j-l];
                j++;
            } else if( j > r) { // 如果右半部分元素已经全部处理完毕
                arr[k] = aux[i - l];
                i++;
            } else if( aux[i-l].compareTo(aux[j-l]) < 0) { // 左半部分所指元素 < 右半部分所指元素
                arr[k] = aux[i-l];
                i++;
            } else { // 左半部分所指元素 >= 右半部分所指元素
                arr[k] = aux[j-l];
                j++;
            }
        }
    }
}
