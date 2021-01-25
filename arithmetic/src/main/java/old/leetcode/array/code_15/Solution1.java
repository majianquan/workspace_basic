package old.leetcode.array.code_15;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution1 {
    public static void main(String[] args) {
        int[] nums = {-1, 0, 1, 2, -1, -4};
        System.out.println(new Solution1().threeSum(nums));
    }

    private List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        for (int k = 0; k < nums.length - 2; k++) {
            if(nums[k] > 0) break;
            if(k > 0 && nums[k] == nums[k - 1]) continue;
            int i = k + 1, j = nums.length -1;
            while (i < j) {
                int sum = nums[k] + nums[i] + nums[j];
                if(sum < 0) {
                    while (i < j && nums[i] == nums[++i]);
                } else if(sum > 0) {
                    while (i < j && nums[j] == nums[--j]);
                } else {
                    res.add(Arrays.asList(nums[k],nums[i],nums[j]));
                    while(i < j && nums[i] == nums[++i]);
                    while(i < j && nums[j] == nums[--j]);
                }
            }
        }
        return res;
    }
}
