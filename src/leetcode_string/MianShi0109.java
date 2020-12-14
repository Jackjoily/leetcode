package leetcode_string;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 
 * 字符串轮转。给定两个字符串s1和s2，请编写代码检查s2是否为s1旋转而成 （比如，waterbottle是erbottlewat旋转后的字符串）。
 * 
 * @author jackjoily
 *
 */
public class MianShi0109 {
	public static void main(String[] args) {
		System.out.println(isFlipedString("abcdeefafaefaesfeasfhtheraaz","htheraazabcdeefafaefaesfeasf"));
	}

	public static boolean isFlipedString(String s1, String s2) {
		if (s1.length() != s2.length())
			return false;
            	if(s1.equals(s2))return true;
		int n = s1.length();
		for (int i = 0; i < n; i++) {
			if (s1.substring(0, i + 1).equals(s2.substring(n - i-1, n))) {
				if (s1.subSequence(i + 1, n).equals(s2.substring(0, n - i-1))) {
					return true;
				}
			}
		}
		return false;
	}
}
