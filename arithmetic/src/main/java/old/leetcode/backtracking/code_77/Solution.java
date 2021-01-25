package old.leetcode.backtracking.code_77;

import java.util.ArrayList;
import java.util.List;

/**
 * 77. 组合
 * https://leetcode-cn.com/problems/combinations/
 */
public class Solution {
    public static void main(String[] args) {
        System.out.println(new Solution().combine(4,2));
    }
    private List<List<Integer>> res;
    public List<List<Integer>> combine(int n, int k) {
        if(n <= 0 || k <= 0 || k > n) {
            return res;
        }
        res = new ArrayList<>();
        List<Integer> c = new ArrayList<>();
        generateCombine(n,k,1,c);
        return res;
    }
    private void generateCombine(int n,int k,int start, List<Integer> c) {
        if(c.size() == k) {
            res.add(c);
             return;
        }
        for (int i = start; i <= n - (k- c.size()) +1
                ; i++) {
            c.add(i);
            generateCombine(n,k,i + 1,c);
            c.remove(c.size() -1);
        }
    }
}

