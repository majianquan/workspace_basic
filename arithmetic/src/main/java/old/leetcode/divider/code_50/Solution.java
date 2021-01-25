package old.leetcode.divider.code_50;

/**
 * 50. Pow(x, n)
 * https://leetcode-cn.com/problems/powx-n/
 */
public class Solution {
    public static void main(String[] args) {
        System.out.println(new Solution().myPow2(2,2));
    }
    public double myPowHelp(double x , int n) {
        if(n == 1) {
            return x;
        }
        if(n%2 != 0) {
            double half = myPowHelp(x, n/2);
            return half * half * x;
        } else {
            double half = myPowHelp(x,n/2);
            return half * half ;
        }
    }
    // 分治算法
    // 想x^n -> 一分为2  x^n/2
    // logn
    public double myPow(double x, int n) {
        if(n == 0 || x ==1 ) {
            return 1;
        }
        if(n< 0) {
            return  1/ myPowHelp(x ,Math.abs(n));
        }
        return myPowHelp(x,n);
    }
    // 暴力解法 O(n)
    public double myPow2(double x, int n) {
        double N = n;
        if(N < 0) {
            x = 1 / x;
            N = -N;
        }
        double ans = 1;
        for (int i = 0; i < n; i++) {
            ans *= x;
        }
        return ans;
    }
    // 牛顿迭代法
}
