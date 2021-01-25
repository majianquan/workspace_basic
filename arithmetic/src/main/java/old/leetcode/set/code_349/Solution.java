package old.leetcode.set.code_349;

import java.util.HashSet;

/**
 * 349. 两个数组的交集
 * https://leetcode-cn.com/problems/intersection-of-two-arrays/
 */
public class Solution {

    public int[] intersection(int[] nums1, int[] nums2) {
        HashSet<Integer> set1 = new HashSet<>();
        for (Integer n : nums1) {
            set1.add(n);
        }
        HashSet<Integer> set2 = new HashSet<>();
        for (Integer n : nums2) {
            set2.add(n);
        }
        set1.retainAll(set2);
        int[] result = new int[set1.size()];
        int idx = 0;
        for (int s : set1) {
            result[idx++] = s;
        }
        return result;
    }
}
