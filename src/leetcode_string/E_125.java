package leetcode_string;

import java.util.HashMap;
import java.util.Map;

/**
 * 给定一个字符串，验证它是否是回文串， 只考虑字母和数字字符，可以忽略字母的大小写。
 * 
 * @author jackjoily
 *
 */
public class E_125 {
	public static void main(String[] args) {
		System.out.println(isPalindrome("0P"));
	}

	public static boolean isPalindrome(String s) {
		if (s.length() == 1)
			return true;
		int balance = 0;
		StringBuilder sb = new StringBuilder();
		for (int k = 0; k < s.length(); k++) {
			char charAt = s.charAt(k);
			if ((charAt >= 'a' && charAt <= 'z') || (charAt >= 'A' && charAt <= 'Z')||(charAt>='0'&&charAt<='9')) {
				sb.append(Character.toUpperCase(charAt));
			}
		}
		int n = sb.length();
		int i = sb.length() / 2;
		int j = 0;
		for (; j < i; j++) {
			if (sb.charAt(j) != sb.charAt(n - 1 - j)) {
				return false;
			}
		}
		return true;
	}
}
