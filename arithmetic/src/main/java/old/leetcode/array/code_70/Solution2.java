package old.leetcode.array.code_70;

public class Solution2 {
    public static void main(String[] args) {
        System.out.println(new Solution2().climbStairs3(10));
    }
    // 普通递归
    private int climbStairs(int n) {
        if (n == 1) {
            return 1;
        }
        if(n == 2) {
            return  2;
        }
        return climbStairs(n-1) + climbStairs(n-2);
    }
    // 记忆化搜索
    private int climbStairs1(int n) {
        int[] memo = new int[n +1];
        return climbStairs1Memo(n,memo);
    }
    private int climbStairs1Memo(int n, int[] memo) {
        if(memo[n] > 0) {
            return memo[n];
        }
        if(n == 1) {
            memo[n] = 1;
        } else if(n == 2) {
            memo[n] = 2;
        } else {
            memo[n] = climbStairs1Memo(n - 1, memo) + climbStairs1Memo(n - 2, memo);
        }
        return memo[n];
    }
    // 动态规划
    private int climbStairs2(int n) {
        int[] dp = new int[n + 1];
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i - 2] + dp[i - 1];
        }
        return dp[n];
    }
    // 滚动数组
    private int climbStairs3(int n) {
        if(n == 1) {
            return 1;
        }
        int first = 1;
        int second = 2;
        for (int i = 3; i <= n; i++) {
            int third = first + second;
            first = second;
            second = third;
        }
        return second;
    }
}
