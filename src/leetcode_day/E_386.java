package leetcode_day;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

/**
 *
 *
 *
 * 给定两个字符串 s 和 t，它们只包含小写字母。
 * 
 * 字符串 t 由字符串 s 随机重排，然后在随机位置添加一个字母。
 * 
 * 请找出在 t 中被添加的字母。
 *
 *
 *
 */
public class E_386 {
	public static void main(String[] args) {
		System.out.println(findTheDifference("a","aa"));
	}

	public static char findTheDifference(String s, String t) {
		int a[] = new int[26];
		int i = 0;
		for (; i < s.length(); i++) {
			a[s.charAt(i) - 'a']++;
			a[t.charAt(i) - 'a']--;
		}
		a[t.charAt(i ) - 'a']--;
		for (i = 0; i < 26; i++) {
			if (a[i] != 0)
				return (char) (i + 'a');
		}
		return 0;
	}
}
