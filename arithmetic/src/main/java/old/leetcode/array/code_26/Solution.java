package old.leetcode.array.code_26;

import java.util.Arrays;

/**
 * 26. 删除排序数组中的重复项
 * https://leetcode-cn.com/problems/remove-duplicates-from-sorted-array/
 */
public class Solution {
    public static void main(String[] args) {
        int[] arr = {0, 0, 1, 1, 2, 2, 3, 3, 4};
        int[] arr2 = {1,2,3,4,5};
        System.out.println(new Solution().removeDuplicates(arr2));
    }
    public int removeDuplicates(int[] nums) {
        if (nums.length == 0) return 0;
        int i = 0;
        for (int j = 1; j < nums.length; j++) {
            if(nums[i] != nums[j]) {
                i++;
                if(nums[i] != nums[j]) {
                    nums[i] = nums[j];
                }
            }
        }
        return i + 1;
    }
}
