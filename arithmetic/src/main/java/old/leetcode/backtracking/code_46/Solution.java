package old.leetcode.backtracking.code_46;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 46. 全排列
 * https://leetcode-cn.com/problems/permutations/
 */
public class Solution {
    private final List<List<Integer>> res = new ArrayList<>();
    private  boolean[] used;

    public List<List<Integer>> permute(int[] nums) {
        if (nums.length == 0) {
            return res;
        }
        List<Integer> p = new ArrayList<>();
        used = new boolean[nums.length];
        Arrays.fill(used,false);
        generatePermutation(nums, 0, p);
        return res;
    }

    private void generatePermutation(int[] nums, int index, List<Integer> p) {
        if (index == nums.length) {
            res.add(p);
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if(!used[i]) {
                p.add(nums[i]);
                used[i] = true;
                generatePermutation(nums, index +1,p);
                p.remove(p.size() -1);
                used[i] = false;
            }
        }
    }
}
