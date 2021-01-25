package old.leetcode.map.code_219;

import java.util.HashSet;
import java.util.Set;

/**
 * 219. 存在重复元素 II
 * https://leetcode-cn.com/problems/contains-duplicate-ii/
 * 给定一个整数数组和一个整数k，判断数组中是否存在两个不同的索引i和j，使得nums [i] = nums [j]，并且 i 和 j的差的 绝对值 至多为 k。
 *

 */
public class Solution {
    public static void main(String[] args) {
        int[] nums = {1,2,3,4,1};
        int k = 3;
        boolean b = new Solution().containsNearbyDuplicate(nums, k);
        System.out.println(b);
    }
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (set.contains(nums[i])) return true;
            set.add(nums[i]);
            if(set.size() > k) {
                set.remove(nums[i-k]);
            }
        }
        return false;
    }
}
