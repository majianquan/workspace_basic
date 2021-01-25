package old.leetcode.dynamic_programming;

import java.util.Arrays;

/**
 * F(n) = F(n - 1) + F(n - 2)
 */
public class Fibonacci {
    public static void main(String[] args) {
        System.out.println(fibMemo(10));
        System.out.println(fib2(10));
    }
    // 记忆化搜索
    private static int fibMemo(int i) {
        int[] memo = new int[i + 1];
        Arrays.fill(memo,-1);
        return fib(memo,i);
    }
    private static int fib(int[] memo ,int i) {
        if(i == 0 ) {
            memo[0] = 0;
        }
        if(i == 1) {
            memo[1] = 1;
        }
        if(memo[i] == -1) {
            memo[i] = fib(memo,i - 1) + fib(memo,i - 2);
        }
        return memo[i];
    }
    // 动态规划
    public static int fib2(int i) {
        if(i == 0 ) {
           return 0;
        }
        if(i == 1) {
            return 1;
        }
        int[] dp = new int[i + 1];
        dp[0] = 0;
        dp[1] = 1;
        for (int j = 2; j <= i; j++) {
            dp[j] = dp[j-1] + dp[j -2];
        }
        return dp[i];
    }
}
