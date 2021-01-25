package old.leetcode.array.code_283;

import java.util.Arrays;

public class Solution2 {
    public static void main(String[] args) {
        int[] arr = {1, 0, 3, 4, 5};
        new Solution2().moveZeroes4(arr);
        System.out.println(Arrays.toString(arr));
    }

    private void swap(int[] arr, int src, int res) {
        int temp = arr[res];
        arr[res] = arr[src];
        arr[src] = temp;
    }

    private void moveZeroes4(int[] arr) {
        int k = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != 0) {
                if(k != i) {
                    swap(arr,k,i);
                }
                k++;
            }
        }
    }
}
