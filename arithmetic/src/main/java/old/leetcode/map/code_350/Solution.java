package old.leetcode.map.code_350;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 350. 两个数组的交集 II
 * https://leetcode-cn.com/problems/intersection-of-two-arrays-ii/
 */
public class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int k : nums1) {
            int count = map.getOrDefault(k, 0) + 1;
            map.put(k, count);
        }
        int[] result = new int[nums1.length];
        int index = 0;
        for (int j : nums2) {
            int count = map.getOrDefault(j, 0);
            if (count > 0) {
                result[index++] = j;
                count--;
                if (count > 0) {
                    map.put(j, count);
                } else {
                    map.remove(j);
                }
            }
        }
        return Arrays.copyOfRange(result, 0, index);
    }

    public int[] intersect2(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int length1 = nums1.length, length2 = nums2.length;
        int index1 = 0, index2 = 0, index = 0;
        int[] result = new int[Math.min(length1, length2)];
        while (index1 < length1 && index2 < length2) {
            if(nums1[index1] < nums2[index2]) {
                index1++;
            } else if(nums1[index1] > nums2[index2]) {
                index2++;
            } else {
                result[index] = nums1[index];
                index++;
                index1++;
                index2++;
            }
        }
        return Arrays.copyOfRange(result, 0, index);
    }
}
