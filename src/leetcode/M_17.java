package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

import leetcode_list.ListNode;

/**
 * 
 * @author jackjoily
 *
 */
public class M_17 {
	public static void main(String[] args) {
		String str = "2";
		char[] charArray = str.toCharArray();
		StringBuilder sb = new StringBuilder();
		char ch[][] = { { 'a', 'b', 'c' }, { 'd', 'e', 'f' }, { 'g', 'h', 'i' }, { 'j', 'k', 'l' }, { 'm', 'n', 'o' },
				{ 'p', 'q', 'r', 's' }, { 't', 'u', 'v' }, { 'w', 'x', 'y', 'z' } };
		f(charArray, sb, 0, ch);
	}

	static List<String> list = new ArrayList<>();

	public List<String> letterCombinations(String digits) {
		if (digits.length() == 0)
			return list;
		StringBuilder sb = new StringBuilder();
		char ch[][] = { { 'a', 'b', 'c' }, { 'd', 'e', 'f' }, { 'g', 'h', 'i' }, { 'j', 'k', 'l' }, { 'm', 'n', 'o' },
				{ 'p', 'q', 'r', 's' }, { 't', 'u', 'v' }, { 'w', 'x', 'y', 'z' } };
		f(digits.toCharArray(), sb, 0, ch);
		return list;
	}

	public static void f(char[] c, StringBuilder sb, int start, char ch[][]) {
		if (sb.length() == c.length) {
			list.add(sb.toString());
			return;
		}
		for (int i = start; i < c.length; i++) {
			char a[] = ch[c[i] - '0' - 2];
			for (int j = 0; j < a.length; j++) {
				sb.append(a[j]);
				f(c, sb, i + 1, ch);
				sb.deleteCharAt(sb.length() - 1);
			}
		}

	}
}
