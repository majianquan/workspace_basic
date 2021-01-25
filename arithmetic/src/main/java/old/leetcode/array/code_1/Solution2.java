package old.leetcode.array.code_1;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 两数之和
 */
public class Solution2 {
    public static void main(String[] args) {
        // 给定 nums = [2, 7, 11, 15], target = 9
        // 因为 nums[0] + nums[1] = 2 + 7 = 9
        // 所以返回 [0, 1]
//        int[] nums = {2, 7, 11, 15};
//        int target = 9;
        int[] nums = {2, 5, 5, 11};
        int target = 10;
//        int[] result = new Solution2().twoSum(nums, target);
//        int[] result = new Solution2().twoSum1(nums, target);
        int[] result = new Solution2().twoSum2(nums,target);
        System.out.println(Arrays.toString(result));
    }

    // hash解法
    private int[] twoSum2(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if(map.containsKey(target - nums[i])) {
                return new int[]{map.get(target - nums[i]) ,i};
            }
            map.put(nums[i],i);
        }
        return new int[2];
    }

    // 排序 + 双指针
    private int[] twoSum1(int[] nums, int target) {
        int m = 0, n = 0, k;
        int[] temp1 = new int[nums.length];
        int[] res = new int[2];
        System.arraycopy(nums, 0, temp1, 0, nums.length);
        Arrays.sort(nums);
        for (int l = 0, r = nums.length - 1; l < r; ) {
            if (nums[l] + nums[r] > target) {
                r--;
            } else if (nums[l] + nums[r] < target) {
                l++;
            } else {
                m = l;
                n = r;
                break;
            }
        }
        for (k = 0; k < temp1.length; k++) {
            if (temp1[k] == nums[m]) {
                res[0] = k;
                break;
            }
        }
        for (int i = 0; i < temp1.length; i++) {
            if (temp1[i] == nums[n] && i != k) {
                res[1] = i;
                break;
            }
        }
        return res;
    }

    // 暴力解法
    private int[] twoSum(int[] nums, int target) {
        int[] res = new int[2];
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums.length; j++) {
                if (i != j && nums[i] + nums[j] == target) {
                    res[0] = i;
                    res[1] = j;
                    return res;
                }
            }
        }
        return res;
    }
}
