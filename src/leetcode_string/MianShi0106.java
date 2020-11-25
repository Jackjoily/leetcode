package leetcode_string;

import java.util.HashMap;
import java.util.Map;

/**
 * 字符串压缩。利用字符重复出现的次数，编写一种方法，实现基本的字符串压缩功能。
 * 比如，字符串aabcccccaaa会变为a2b1c5a3。若“压缩”后的字符串没有变短，
 * 则返回原先的字符串。你可以假设字符串中只包含大小写英文字母（a至z）。
 * 
 * @author jackjoily
 *
 */
public class MianShi0106 {
	public static void main(String[] args) {
		System.out.println(compressString("abcdefg"));
	}

	public static String compressString(String s) {
		if (s.length() <= 2)
			return s;
		int temp = 0;
		int i, j;
		StringBuilder sb = new StringBuilder();
		for (i = 0; i < s.length();) {
			char c = s.charAt(i);
			temp = 1;
			for (j = i + 1; j < s.length(); j++) {
				char d = s.charAt(j);
				if (c == d) {
					temp++;
				} else {
					break;
				}
			}
			i = j;
			sb.append(c).append(temp);
		}
		String string = sb.toString();
		return string.length() < s.length() ? string : s;
	}
}
