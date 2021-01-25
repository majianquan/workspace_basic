package old.leetcode.divider.code_78;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 78. 子集
 * https://leetcode-cn.com/problems/subsets/
 */
public class Solution {
    public static void main(String[] args) {
        int[] nums = {1,2,3};
        System.out.println(new Solution().subsets2(nums));
    }
    // 分治
    public List<List<Integer>> subsets(int[] nums) {
        return null;
    }
    // 递归解法
    public List<List<Integer>> subsets2(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        if(nums == null) {
            return ans;
        }
        dfs(ans,nums, new ArrayList<Integer>(),0);
        return ans;
    }

    private void dfs(List<List<Integer>> ans, int[] nums, ArrayList<Integer> list, int index) {
        if(index == nums.length) {
            ans.add(new ArrayList<Integer>(list));
            return;
        }
        dfs(ans ,nums,list,index + 1);
        list.add(nums[index]);
        dfs(ans,nums,list,index+1);

        list.remove(list.size() - 1);
    }
}
