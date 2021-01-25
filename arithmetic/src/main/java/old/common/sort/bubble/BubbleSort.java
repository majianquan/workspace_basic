package old.common.sort.bubble;

import common.utils.SortTestHelper;

public class BubbleSort {
    public void sort(Integer[] arr) {
        int length = arr.length;
        for (int j = 0; j < length; j++) {
            for (int i = 0; i < length - 1 ; i++) {
                if(arr[i] > arr[i] + 1) {
                    System.out.println(i);
                    SortTestHelper.swap(arr, i, i + 1);
                }
            }
        }
    }
}
