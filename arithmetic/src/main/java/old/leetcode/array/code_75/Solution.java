package old.leetcode.array.code_75;

import java.util.Arrays;

/**
 *
 * 75. 颜色分类
 * https://leetcode-cn.com/problems/sort-colors/
 * 给定一个包含红色、白色和蓝色，一共 n 个元素的数组，原地对它们进行排序，使得相同颜色的元素相邻，并按照红色、白色、蓝色顺序排列。
 *
 * 此题中，我们使用整数 0、 1 和 2 分别表示红色、白色和蓝色。
 *
 *
 * 输入: [2,0,2,1,1,0]
 * 输出: [0,0,1,1,2,2]
 */
public class Solution {
    public static void main(String[] args) {
        int[] nums = {2,0,2,1,1,0};
//        new SortColorsTest().sortColors1(nums);
//        new SortColorsTest().sortColors2(nums);
        new Solution().sortColors3(nums);
        System.out.println(Arrays.toString(nums));
    }
    public void sortColors1(int[] nums) {
        Arrays.sort(nums);
    }
    public void sortColors2(int[] nums) {
        int[] count = {0,0,0};
        for (int num : nums) {
            count[num] += 1;
        }
        int temp = 0;
        for (int i = 0; i < count.length; i++) {
            for (int j = 0; j < count[i]; j++) {
                nums[temp]  = i;
                temp++;
            }
        }
    }
    public void sortColors3(int[] nums) {
        int zero = -1;
        int r = nums.length - 1;
        int two = r + 1;
        for (int i = 0; i < two; ) {
            if(nums[i] >  1) {
                swap(nums,two -1, i);
                two--;
                i++;
            } else if(nums  [i] < 1) {
                swap(nums,zero + 1, i);
                i++;
                zero++;
            } else {
                i++;
            }
        }

    }
    public void swap(int[] arr,int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
