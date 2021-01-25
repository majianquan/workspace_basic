package old.leetcode.array.code_70;

/**
 * 70. 爬楼梯
 * https://leetcode-cn.com/problems/climbing-stairs/
 */
public class Solution {
    public static void main(String[] args) {
        System.out.println(new Solution().climbStairs(10));
    }
    // 递归 O(2^n)
    public int climbStairs(int n) {
        if(n==1) {
            return 1;
        }
        if(n == 2) {
            return 2;
        }
        return climbStairs(n-1) + climbStairs(n-2);
    }

    //O(n)
    // 记忆化递归
    public int climbStairs1(int n) {
        int[] memo =  new int[n+1];
        return climbStairs1Memo(n,memo);
    }
    public int climbStairs1Memo(int n, int[] memo) {
        if(memo[n] > 0) {
            return memo[n];
        }
        if(n == 1){
            memo[n] =1;
        } else if(n==2) {
            memo[n] = 2;
        } else {
            memo[n] = climbStairs1Memo(n -1,memo) + climbStairs1Memo(n-2,memo);
        }
        return memo[n];
    }
    // 动态规划O(n)
    public int climbStairs2(int n) {
        if(n==1) {
            return 1;
        }
        int[] dp = new int[n+1];
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i < n; i++) {
            dp[i] = dp[i - 1] + dp[i -2];
        }
        return dp[n];
    }
    // 滚动数组O(n)
    public int climbStairs3(int n) {
        if(n == 1) {
            return 1;
        }
        int first = 1;
        int second = 2;
        for (int i = 3; i < n; i++) {
            int third = first + second;
            first = second;
            second = third;
        }
        return second;
    }
    // 数学通项公式
    public int climbStairs4(int n) {
        double sqrt5 = Math.sqrt(5);
        double fibn = Math.pow((1 + sqrt5) / 2, n + 1) - Math.pow((1 - sqrt5) / 2, n + 1);
        return (int)(fibn / sqrt5);
    }

}
