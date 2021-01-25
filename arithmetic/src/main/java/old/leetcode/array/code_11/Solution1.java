package old.leetcode.array.code_11;

public class Solution1 {
    public static void main(String[] args) {
        int[] heights = {1, 8, 6, 2, 5, 4, 8, 3, 7};
        System.out.println(new Solution1().maxArea(heights));
    }

    private int maxArea(int[] heights) {
        int l = 0, r = heights.length - 1;
        int ans = 0;
        while (l < r) {
            int area = Math.min(heights[l], heights[r]) * (r - l);
            ans = Math.max(ans, area);
            if (heights[l] <= heights[r]) {
                l++;
            } else {
                r--;
            }
        }
        return ans;
    }
}
