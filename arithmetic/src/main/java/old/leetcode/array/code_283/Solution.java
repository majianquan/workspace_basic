package old.leetcode.array.code_283;

import java.util.Arrays;

/**
 * 移动零
 * https://leetcode-cn.com/problems/move-zeroes/
 * 输入: [0,1,0,3,12]
 * 输出: [1,3,12,0,0]
 */
public class Solution {
    public void swap(int[] arr,int src,int des) {
        int temp =  arr[src];
        arr[src] = arr[des];
        arr[des] =  temp;
    }
    public void moveZeroes(int[] nums) {
        int[] temp_arr = new int[nums.length];
        int dir = 0;
        for (int num : nums) {
            if (num != 0) {
                temp_arr[dir] = num;
                dir++;
            }
        }
        System.arraycopy(temp_arr, 0, nums, 0, temp_arr.length);
    }
    public void moveZeroes2(int[] nums) {
        for (int i = 1,tag =0; i < nums.length; i++) {
            if(nums[tag] == 0) {
                if(nums[i] !=0) {
                    int temp = nums[i];
                    nums[i] = nums[tag];
                    nums[tag] = temp;
                    tag++;
                }
            } else {
                tag++;
            }
        }
    }
    public void moveZeroes3(int[] nums) {
        int k =0; // nums中[0..k)的元素都均为非0 元素
        // 遍历到第i个元素后,保证[0...i]中所有非0元素都按照顺序排列在[0...k)中
        // 同时, [k..i]为0
        for (int i = 0; i < nums.length ; i++) {
            if(nums[i] != 0) {
                if(k!=i) {
                    nums[k] = nums[i];
                }
                k++;
            }
        }
        for (int i = k; i < nums.length ; i++) {
            nums[i] = 0;
        }
    }
    public void moveZeroes4(int[] nums) {
        int k = 0;
        for (int i = 0; i < nums.length; i++) {
            if(nums[i] != 0) {
                if(k != i) {
                    swap(nums,k,i);
                }
                k++;
            }
        }
    }
    public static void main(String[] args) {
//        int[] arr = {0,1,0,3,12};
//        int[] arr = {1,0,1};
        int[] arr = {1,0,3,4,5};
        new Solution().moveZeroes4(arr);
        System.out.println(Arrays.toString(arr));
    }
}
