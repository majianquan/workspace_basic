package old.leetcode.backtracking.code_17;

import java.util.ArrayList;
import java.util.List;

public class Solution2 {
    private final String[] letterMap = {" ","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
    private final List<String> res = new ArrayList<>();
    public List<String> letterCombinations(String digits) {
        if(digits.equals("")) return res;
        findCombination(digits,0,"");
        return res;
    }

    private void findCombination(String digits, int index, String s) {
        if(index == digits.length()) {
            res.add(s);
            return;
        }
        char c = digits.charAt(index);
        String letters = letterMap[c - '0'];
        for (int i = 0; i < letters.length(); i++) {
            findCombination(digits,index + 1, s + letters.charAt(i));
        }
    }

    public static void main(String[] args) {
        System.out.println(new Solution2().letterCombinations("23"));
    }
}
