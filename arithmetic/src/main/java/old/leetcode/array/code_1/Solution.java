package old.leetcode.array.code_1;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 1. 两数之和
 * https://leetcode-cn.com/problems/two-sum/
 */
public class Solution {
    // 排序 + 双指针
    public int[] twoSum(int[] nums, int target) {
        int m =0 ,n =0, k = 0;
        int[] res = new int[2];
        int[] temp1 = new int[nums.length];
        System.arraycopy(nums,0,temp1,0,nums.length);
        Arrays.sort(nums);
        for (int i = 0,j=nums.length-1; i <j;) {
            if(nums[i] + nums[j] <target) {
                i++;
            } else if(nums[i] + nums[j] > target) {
                j--;
            } else if(nums[i] + nums[j] == target) {
                m = i;
                n = j;
                break;
            }
        }
        for (k = 0; k < nums.length; k++) {
            if(temp1[k] == nums[m]) {
                res[0] = k;
                break;
            }
        }
        for (int i = 0; i < nums.length; i++) {
            if(temp1[i] == nums[n] && i != k) {
                res[1] = i;
                break;
            }
        }
        return res;
    }
    // 暴力解法
    public int[] twoSum1(int[] nums, int target) {
        int[] result = new int[2];
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    result[0] = i;
                    result[1] = j;
                    return result;
                }
            }
        }
        return result;
    }
    // hash
    public int[] twoSum2(int[] nums, int target) {
        Map<Integer,Integer> map= new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if(map.containsKey(target - nums[i])) {
                return new int[]{map.get(target-nums[i]),i};
            }
            map.put(nums[i],i);
        }
        return  new int[]{-1,-1};
    }

    public static void main(String[] args) {
        // 给定 nums = [2, 7, 11, 15], target = 9
        // 因为 nums[0] + nums[1] = 2 + 7 = 9
        // 所以返回 [0, 1]
        int[] nums = {2, 7, 11, 15};
        int target = 9;
        int[] result = new Solution().twoSum(nums, target);
//        int[] result = new Solution().twoSum1(nums,target);
        System.out.println(Arrays.toString(result));
    }
}
