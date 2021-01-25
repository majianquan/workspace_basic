package old.leetcode.array.code_1;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Solution3 {
    public static void main(String[] args) {
        // 给定 nums = [2, 7, 11, 15], target = 9
        // 因为 nums[0] + nums[1] = 2 + 7 = 9
        // 所以返回 [0, 1]
        int[] nums = {2, 7, 11, 15};
        int target = 9;
//        int[] result = new Solution().twoSum(nums, target);
//        int[] result = new Solution().twoSum1(nums,target);
        int[] result = new Solution().twoSum2(nums,target);
        System.out.println(Arrays.toString(result));
    }
    // 暴力解法
    public int[] twoSum(int[] nums, int target){
        int[] res = new int[2];
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums.length; j++) {
                if(nums[i] + nums[j] == target) {
                    res[0] = i;
                    res[1] = j;
                    return  res;
                }
            }
        }
        return res;
    }
    // 排序 + 双指针
    public int[] twoSum1(int[] nums, int target){
        int i = 0,j= nums.length - 1,k;
        int[] temp = new int[nums.length];
        int[] res = new int[2];
        System.arraycopy(nums,0,temp,0,nums.length);
        Arrays.sort(temp);
        while (i<j) {
            if(temp[i] + temp[j] > target) {
                j--;
            } else if(temp[i] + temp[j] < target) {
                i++;
            } else {
                break;
            }
        }
        for (k = 0; k < nums.length; k++) {
            if(nums[k] == temp[i]) {
                res[0] = k;
            }
        }
        for (int l = 0; l < nums.length; l++) {
            if(nums[l] == temp[j] &&  j != k) {
                res[1] = l;
            }
        }
        return res;
    }
    // hash
    public int[] twoSum2(int[] nums, int target){
        int[] res = new int[2];
        Map<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if(map.containsKey(target - nums[i])) {
                res[0] = i;
                res[1] = map.get(target-nums[i]);
                return res;
            }
            map.put(nums[i],i);
        }
        return res;
    }
}
