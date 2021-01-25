package old.common.sort.bubble;

import common.utils.SortTestHelper;

public class BubbleSortOpt1 {
    public void sort(Integer[] arr) {
        int length = arr.length;
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < j - i - 1; j++) {
                if(arr[j] > arr[j+1]) {
                    SortTestHelper.swap(arr, j, j + 1);
                }
            }
        }
    }
}
