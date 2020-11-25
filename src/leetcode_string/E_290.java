package leetcode_string;

import java.util.Arrays;
import java.util.stream.Stream;

/**
 * 
 * 编写一个函数来查找字符串数组中的最长公共前缀。
 * 
 * 如果不存在公共前缀，返回空字符串 ""
 * 
 * @author jackjoily
 *
 */
public class E_290 {
	public static void main(String[] args) {
		System.out.println(wordPattern("abba", "dog dog dog dog"));
	}

	public static boolean wordPattern(String pattern, String s) {
		String[] split = s.split("\\s+");
		if (split.length != pattern.length())
			return false;
		for (int i = 0; i < split.length; i++) {
			if (pattern.indexOf(pattern.charAt(i)) != indexOf(split, split[i])) {
				return false;
			}
		}
		return true;
	}

	public static int indexOf(String a[], String str) {
		for (int i = 0; i < a.length; i++) {
			if (a[i].equals(str))
				return i;
		}
		return -1;
	}
}
