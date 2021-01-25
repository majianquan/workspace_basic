package old.common.kmp;

/**
 * 字符串暴力匹配
 */
public class ViolenceMatch {
	public static void main(String[] args) {
		String str1 = "AABB AABCDE ABCDEFGH";
		String str2 = "ABCDEF";
		System.out.println(violenceMatch(str1,str2));
	}
	public static int violenceMatch(String str1, String str2) {
		char[] s1 = str1.toCharArray();
		char[] s2= str2.toCharArray();
		int s1Len = s1.length;
		int s2len = s2.length;

		int i = 0;
		int j = 0;
		while (i < s1Len && j < s2len) {
			if(s1[i] == s2[j]) {
				// 匹配成功
				i++;
				j++;
			} else {
				// 没有匹配成功
				i = i - (j -1 );
				j = 0;
			}
		}
		if(j == s2len) {
			return i - j;
		} else {
			return -1;
		}
	}
}
