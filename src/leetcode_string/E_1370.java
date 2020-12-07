package leetcode_string;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 
 * 给你一个字符串 s ，请你根据下面的算法重新构造字符串：
 * 
 * 从 s 中选出 最小 的字符，将它 接在 结果字符串的后面。 从 s 剩余字符中选出 最小 的字符，且该字符比上一个添加的字符大，将它
 * 接在 结果字符串后面。 重复步骤 2 ，直到你没法从 s 中选择字符。 从 s 中选出 最大 的字符，将它 接在 结果字符串的后面。 从
 * s 剩余字符中选出 最大 的字符，且该字符比上一个添加的字符小，将它 接在 结果字符串后面。 重复步骤 5 ，直到你没法从 s 中选择字符。 重复步骤 1
 * 到 6 ，直到 s 中所有字符都已经被选过。 在任何一步中，如果最小或者最大字符不止一个 ，你可以选择其中任意一个，并将其添加到结果字符串。
 * 
 * 请你返回将 s 中字符重新排序后的 结果字符串
 * 
 * 
 * @author jackjoily
 *
 */
public class E_1370 {
	public static void main(String[] args) {
		System.out.println(sortString1("rat"));
	}

	public static String sortString(String s) {
		if (s.length() == 1)
			return s;
		char[] charArray = s.toCharArray();
		boolean[] flag = new boolean[charArray.length];
		Arrays.sort(charArray);
		StringBuilder sb = new StringBuilder();
		int k = 0;
		while (k < charArray.length) {
			char c = ' ';
			char d = ' ';
			for (int i = 0; i < s.length(); i++) {
				if (!flag[i] && charArray[i] != c) {
					sb.append(charArray[i]);
					c = charArray[i];
					flag[i] = true;
					k++;
				}
			}
			for (int i = s.length() - 1; i >= 0; i--) {
				if (!flag[i] && charArray[i] != d) {
					sb.append(charArray[i]);
					d = charArray[i];
					flag[i] = true;
					k++;
				}
			}
		}
		return sb.toString();
	}

	/**
	 * 使用桶排序
	 * 
	 * @param s
	 * @return
	 */
	public static String sortString1(String s) {
		int a[] = new int[26];
		for (int i = 0; i < s.length(); i++) {
			a[s.charAt(i) - 'a']++;
		}
		StringBuilder sb = new StringBuilder();
		while (sb.length() < s.length()) {
			for (int i = 0; i < 26; i++) {
				if (a[i] > 0) {
					sb.append((char) (i + 'a'));
					a[i]--;
				}
			}
			for (int i = 25; i >= 0; i--) {
				if (a[i] > 0) {
					sb.append((char) (i + 'a'));
					a[i]--;
				}
			}
		}
		return sb.toString();
	}
}
