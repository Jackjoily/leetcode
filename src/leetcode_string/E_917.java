package leetcode_string;

import java.util.HashMap;
import java.util.Map;

/**
 * 给定一个字符串 S，返回 “反转后的” 字符串，其中不是字母的字符都保留在原地， 而所有字母的位置发生反转。
 * 
 * @author jackjoily
 *
 */
public class E_917 {
	public static void main(String[] args) {
		E_917 e = new E_917();
		System.out.println(e.reverseOnlyLetters("Test1ng-Leet=code-Q!"));
	}

	public String reverseOnlyLetters(String s) {
		if (s.length() == 1)
			return s;
		int i = 0, k = s.length() - 1;
		char[] c = s.toCharArray();
		char ch = ' ';
		while (i < k) {
			if (isCharcter(c[i])) {
				if (isCharcter(c[k])) {
					ch = c[i];
					c[i] = c[k];
					c[k] = ch;
					i++;
					k--;
				} else {
					k--;
				}
			} else {
				i++;
			}
		}
		return new String(c);
	}

	public boolean isCharcter(char c) {
		if ((c >= 65 && c <= 90) || (c >= 97 && c <= 122)) {
			return true;
		}
		return false;
	}
}
