package old.leetcode.array.code_75;

import java.util.Arrays;

public class Solution1 {
    public static void main(String[] args) {
        int[] nums = {2,0,2,1,1,0};
//        new Solution1().sortColors1(nums);
//        new Solution1().sortColors2(nums);
//        new Solution1().sortColors3(nums);
        new Solution1().sortColors4(nums);
        System.out.println(Arrays.toString(nums));
    }

    private void sortColors1(int[] nums) {
        Arrays.sort(nums);
    }

    private void sortColors2(int[] nums) {
        int[] count = new int[3];
        for (int num : nums) {
            count[num] += 1;
        }
        int temp = 0;
        for (int i = 0; i < count.length; i++) {
            for (int j = 0; j < count[i]; j++) {
                nums[temp] = i;
                temp++;
            }
        }
    }
    // 单指针
    private void sortColors3(int[] nums) {
        int ptr = 0;
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            if(nums[i] == 0) {
                swap(nums,i,ptr);
                ptr++;
            }
        }
        for (int i = ptr; i < n; i++) {
            if(nums[i] == 1) {
                swap(nums,i,ptr);
                ptr++;
            }
        }
    }
    // 双指针1
    private void sortColors4(int[] nums) {
        int n = nums.length;
        int p0 = 0, p1 = 0;
        for (int i = 0; i < n; i++) {
            if(nums[i] == 1) {
                swap(nums,i,p1);
                ++p1;
            } else if(nums[i] == 0) {
                swap(nums,i,p0);
                if(p0 < p1) {
                    swap(nums,i,p1);
                }
                ++p0;
                ++p1;
            }
        }
    }
    // 双指针2
    private void sortColors5(int[] nums) {
        int n = nums.length;
        int p0 = 0, p2 = n -1;
        for (int i = 0; i < n; i++) {
            while (i < p2 && nums[i] == 2) {
                swap(nums,i,p2);
                --p2;
            }
            if(nums[i] == 0) {
                swap(nums,i,p0);
            }
        }

    }
    public void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
