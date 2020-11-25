package leetcode_string;

import java.util.Arrays;
import java.util.Comparator;

import edu.princeton.cs.algs4.CC;

/**
 * 
 * 编写一个函数，以字符串作为输入，反转该字符串中的元音字母。
 * 
 * @author jackjoily
 *
 */
public class E_345 {
	public static void main(String[] args) {
		System.out.println(	reverseVowels("AaeEIiOoUu"));
	}

	public static String reverseVowels(String s) {
		if (s.length() == 1)
			return s;
		char[] c = s.toCharArray();
		int i = 0, j = c.length - 1;
		while (i < j) {
			while (i < j && (c[i] != 'a' && c[i] != 'e' && c[i] != 'i' && c[i] != 'o' && c[i] != 'u'&&c[i] != 'A' && c[i] != 'E' && c[i] != 'I' && c[i] != 'O' && c[i] != 'U')) {
				i++;
			}
			while (i < j && (c[j] != 'a' && c[j] != 'e' && c[j] != 'i' && c[j] != 'o' && c[j] != 'u'&&c[j] != 'A' && c[j] != 'E' && c[j] != 'I' && c[j] != 'O' && c[j] != 'U')) {
				j--;
			}
			char temp = c[i];
			c[i] = c[j];
			c[j] = temp;
			i++;
			j--;
		}
		String l = new String(c);
		return l;
	}
}
