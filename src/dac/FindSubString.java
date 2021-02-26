package dac;

import java.util.Arrays;

/**
 * 打印给定字串的子序列
 * 
 * @author jackjoily
 *
 */
public class FindSubString {

	public static void main(String[] args) {
		String str = "abcd";
		boolean visted[] = new boolean[str.length()];
		StringBuilder sb = new StringBuilder();
		String str1 = "";
		// f1(str, 0, visted, str1);
		// f2(str, visted, sb);
		char c[] = new char[27];
		for (int i = 0; i < 26; i++) {
			c[i + 1] = (char) ('a' + i);
		}
		char[] charArray = str.toCharArray();
		f5("12024", 0, sb, c);
	}

	public static void f5(String str, int i, StringBuilder sb, char c[]) {
		if (i == str.length()) {
			System.out.println(sb.toString());
			return;
		}
		int val = 0;
		String j2 = str.charAt(i) + "";
		if (isOkay(j2)) {
			val=Integer.valueOf(j2);
			sb.append(c[val]);
			f5(str, i + 1, sb, c);
			sb.deleteCharAt(sb.length() - 1);
		}

		if (i + 1 >= str.length())
		{
			return;
		} else {
			j2 += str.charAt(i + 1);
			if (isOkay(j2)) {
				val=Integer.valueOf(j2);
				sb.append(c[val]);
				f5(str, i + 2, sb, c);
				sb.deleteCharAt(sb.length() - 1);
			}
		}
	}

	public static boolean isOkay(String str) {
		if (str.charAt(0) == '0')
			return false;
		if (str.length() > 3) {
			return false;
		}
		if (str.length() == 2) {
			if (str.charAt(0) > '2')
				return false;
			if (str.charAt(0) == '2') {
				if (str.charAt(1) > '6')
					return false;
			}
		}
		return true;
	}

	public static void f(String str, int index, boolean visted[], StringBuilder sb) {
		if (index == str.length()) {
			System.out.println(sb.toString());
			return;
		}
		if (index > str.length()) {
			return;
		}
		for (int i = index; i < str.length(); i++) {
			if (!visted[i]) {
				visted[i] = true;
				sb.append(str.charAt(i));
				f(str, i + 1, visted, sb);
				sb.deleteCharAt(sb.length() - 1);
				visted[i] = false;
			}
		}

	}

	/**
	 * 打印一个给定字符串的所有子序列
	 * 
	 * @param str
	 * @param index
	 * @param visted
	 * @param sb
	 */
	public static void f1(String str, int index, boolean visted[], String sb) {
		if (index == str.length()) {
			System.out.println(sb);
			return;
		}
		if (index > str.length()) {
			return;
		}
		f1(str, index + 1, visted, sb);
		f1(str, index + 1, visted, sb + str.charAt(index));
	}

	/**
	 * 打印给定字符串的全排列
	 * 
	 * @param str
	 * @param visted
	 * @param sb
	 */
	public static void f2(String str, boolean visted[], StringBuilder sb) {
		if (sb.length() == str.length()) {
			System.out.println(sb.toString());
			return;
		}
		if (sb.length() > str.length())
			return;
		for (int i = 0; i < str.length(); i++) {
			if (!visted[i]) {
				visted[i] = true;
				sb.append(str.charAt(i));
				f2(str, visted, sb);
				visted[i] = false;
				sb.deleteCharAt(sb.length() - 1);
			}
		}
	}

	/**
	 * 全排列算法
	 * 
	 * @param c
	 * @param i
	 * @param m
	 */
	public static void f3(char[] c, int i, int m) {
		if (i == m) {
			System.out.println(new String(c));
		}
		for (int j = i; j < m; j++) {
			swap(c, i, j);
			f3(c, i + 1, m);
			swap(c, i, j);
		}
	}

	/**
	 * 全排列算法
	 * 
	 * @param c
	 * @param i
	 * @param m
	 */
	public static void f4(char[] c, int i, int m) {
		if (i == m) {
			System.out.println(new String(c));
			return;
		}
		boolean visted[] = new boolean[26];
		for (int j = i; j < m; j++) {
			if (!visted[c[j] - 'a']) {
				visted[c[j] - 'a'] = true;
				swap(c, i, j);
				f4(c, i + 1, m);
				swap(c, i, j);
			}
		}
	}

	public static void swap(char[] c, int i, int j) {
		System.out.println(Arrays.toString(c));
		char temp = c[i];
		c[i] = c[j];
		c[j] = temp;
	}

}
