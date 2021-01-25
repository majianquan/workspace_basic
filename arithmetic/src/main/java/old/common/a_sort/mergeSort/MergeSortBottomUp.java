package old.common.a_sort.mergeSort;


import common.a_sort.insertSort.InsertSortAdvance;

public class MergeSortBottomUp {
    public static void sort(Comparable[] arr) {
        int n = arr.length;
        // 无优化版本
//        for (int sz = 1; sz < n; sz *= 2) {
//            for (int i = 0; i < n-sz; i += sz + sz) {
//                merge(arr,i,i+ sz -1, Math.min(i+ sz + sz -1, n-1));
//            }
//        }
        for (int i = 0; i < n; i+= 16) {
            InsertSortAdvance.sort(arr,i,Math.min(i+15,n-1));
        }
        for (int sz = 16; sz <n; sz+=sz) {
            for (int i = 0; i < n - sz; i+=sz+sz) {
                // 对于arr[mid] <= arr[mid+1]的情况,不进行merge
                if( arr[i+sz-1].compareTo(arr[i+sz]) > 0 )
                    merge(arr, i, i+sz-1, Math.min(i+sz+sz-1,n-1) );
            }
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
