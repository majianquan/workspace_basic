package old.common.kmp;

import java.util.Arrays;

public class KMPAlgorithm {
	public static void main(String[] args) {
		String str1 = "BBC ABCDAB ABCDABCDABDE";
		String str2 = "ABCDABD";
		int[] next = kmpNext(str2);
		System.out.println(kmpSearch(str1,str2,next));
	}
	// 获取到一个字符串(子串)的部分匹配值表
	public static int[] kmpNext(String dest) {
		// 创建一个next数组保存部分匹配值
		int[] next = new int[dest.length()];
		// 如果字符串是长度为1部分匹配值就是0
		next[0] = 0;
		for (int i = 1,j = 0; i < dest.length(); i++) {
			// 当dest.charAt(i) == dest.charAt(j)满足时部分匹配值就是+1
			if(dest.charAt(i) == dest.charAt(j)) {
				j++;
			} else {
				// 当dest.charAt(i) != dest.charAt(j)满足时 我们需要从next[j-1] 获取新的j,
				// 直到我们发现有dest.charAt(i) == dest.charAt(j)成立才退出
				// kmp算法的核心
				while (j >0 && dest.charAt(i) != dest.charAt(j)) {
					j = next[j-1];
				}
			}
			next[i] = j;
		}
		return next;
	}
	// kmp算法
	public static int kmpSearch(String str1, String str2, int[] next) {
		// 遍历str1
		for (int i = 0,j=0; i < str1.length(); i++) {
			if(str1.charAt(i) == str2.charAt(j)) {
				j++;
			}
			while (j > 0 && str1.charAt(i) != str2.charAt(j)) {
				j = next[j-1];
			}
			if(j == str2.length()) {
				return i - j + 1;
			}
		}
		return -1;
	}
}
