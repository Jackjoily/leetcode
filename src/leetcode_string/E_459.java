package leetcode_string;

import java.util.HashMap;
import java.util.Map;

/**
 * 
 * 给定一个非空的字符串，判断它是否可以由它的一个子串重复多次构成。 给定的字符串只含有小写英文字母，并且长度不超过10000。
 * 
 * @author jackjoily
 *
 */
public class E_459 {
	public static void main(String[] args) {
		E_459 e = new E_459();
		System.out.println(e.repeatedSubstringPattern("aaaaad"));
	}

	public boolean repeatedSubstringPattern(String s) {
		int n = s.length();
		if (n == 1)
			return true;
		for (int i = 0; i < n / 2; i++) {
			if (n % (i + 1) == 0) {
				if (check(s, 0, i + 1)) {
					return true;
				}
			}
		}
		return false;
	}

	public boolean check(String s, int start, int end) {
		String str = s.substring(start, end);
		int k = end - start;
		for (int i = k; i < s.length(); i += k) {
			if (!str.equals(s.substring(i, i + k))) {
				return false;
			}
		}
		return true;
	}
}
