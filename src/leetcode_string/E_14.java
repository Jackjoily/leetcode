package leetcode_string;

/**
 * 
 * 编写一个函数来查找字符串数组中的最长公共前缀。
 * 
 * 如果不存在公共前缀，返回空字符串 ""
 * 
 * @author jackjoily
 *
 */
public class E_14 {
	public static void main(String[] args) {
		String a[] = { "flower" };
		System.out.println(longestCommonPrefix(a));
	}

	public static String longestCommonPrefix(String[] strs) {
		if (strs.length == 0)
			return "";
		String str = strs[0];
		for (int i = 0; i < str.length(); i++) {
			for (int j = 1; j < strs.length; j++) {
				if (i < strs[j].length() && strs[j].charAt(i) != str.charAt(i)) {
					if (i > 0) {
						return str.substring(0, i);
					} else {
						return "";
					}
				}
				if (i >= strs[j].length()) {
					return str.substring(0, i);
				}
			}
		}
		return str;
	}
}
