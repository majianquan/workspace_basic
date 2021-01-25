package old.leetcode.array.code_283;

import java.util.Arrays;

public class Solution1 {
    public static void main(String[] args) {
        //        int[] arr = {0,1,0,3,12};
//        int[] arr = {1,0,1};
        int[] arr = {1,0,3,4,5};
        new Solution1().moveZeroes(arr);
        System.out.println(Arrays.toString(arr));
    }

    private void moveZeroes(int[] arr) {
        int k = 0;
        for (int i = 0; i < arr.length; i++) {
            if(arr[i] != 0) {
                if(k != i) {
                    int temp = arr[i];
                    arr[i] = arr[k];
                    arr[k] = temp;
                }
                k++;
            }
        }
    }
}
