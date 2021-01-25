package old.leetcode.dynamic_programming.code_343;

import java.util.Arrays;

/**
 *  343. 整数拆分
 *  https://leetcode-cn.com/problems/integer-break/
 */
public class Solution {
    public static void main(String[] args) {
        System.out.println(new Solution().integerBreak2(5));
    }
    // 记忆化搜索
    public int integerBreak(int n) {
        int[] memo = new int[n+1];
        Arrays.fill(memo,-1);
        return breakInteger(memo,n);
    }

    private int breakInteger( int[] memo,int n) {
        if(n == 1) {
            return 1;
        }
        if(memo[n] != -1) {
            return memo[n];
        }
        int res = -1;
        for (int i = 1; i <= n-1; i++) {
            // 分割成 i + (n-i)
            res = max3(res, i*(n-i),i * breakInteger(memo,n-i));
        }
        memo[n] = res;
        return res;
    }

    private int max3(int a, int b, int c) {
        return Math.max(a,Math.max(b,c));
    }
    // 动态规划
    public int integerBreak2(int n) {
        int[] memo = new int[n+1];
        Arrays.fill(memo,-1);
        // memo[i] 表示将数字i分割(至少分割成两部分)后得到最大的乘积
        memo[1] = 1;
        for (int i = 2; i <= n ; i++) {
            // 求解memo[i]
            for (int j = 1; j <= i-1; j++) {
                memo[i] = max3(memo[i],j*(i-j),j* memo[i-j]);
            }
        }
        return memo[n];
    }
}
