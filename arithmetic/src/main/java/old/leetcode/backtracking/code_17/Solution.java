package old.leetcode.backtracking.code_17;

import java.util.ArrayList;
import java.util.List;

/**
 * 17. 电话号码的字母组合
 * https://leetcode-cn.com/problems/letter-combinations-of-a-phone-number/
 */
public class Solution {
    private final String[] letterMap = {" ","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
    private final List<String> res = new ArrayList<>();
    public List<String> letterCombinations(String digits) {
        if(digits.equals("")) {
            return res;
        }
        findCombination(digits,0,"");
        return res;
    }
    // s中保存了此时从digits[0,...index]翻译得到的一个字母字符串
    // 寻找和digits[index]匹配的字母,获得digits[0...index]翻译得到的解
    private void findCombination(String digits,int index, String s) {
        if(index == digits.length()) {
            res.add(s);
            return;
        }
        char c = digits.charAt(index);
        String letters = letterMap[c - '0'];
        for (int i = 0; i < letters.length(); i++) {
            findCombination(digits,index+1,s+ letters.charAt(i));
        }
    }

    public static void main(String[] args) {
        System.out.println(new Solution().letterCombinations("23"));
    }
}
