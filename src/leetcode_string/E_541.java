package leetcode_string;

import java.util.HashMap;
import java.util.Map;

/**
 * 给定一个字符串 s 和一个整数 k，你需要对从字符串开头算起的每隔 2k 个字符的前 k 个字符进行反转。 如果剩余字符少于 k
 * 个，则将剩余字符全部反转。 如果剩余字符小于 2k 但大于或等于 k 个，则反转前 k 个字符，其余字符保持原样。
 * 
 * @author jackjoily
 *
 */
public class E_541 {
	public static void main(String[] args) {
		System.out.println(reverseStr("abcdefgh", 2));
	}

	public static String reverseStr(String s, int k) {
		char[] c = s.toCharArray();
		int start = 0, step = k;
		int len = c.length;
		while (start < len) {
			// 最后不足k的
			if (start + k > len) {
				int l = len - 1;
				char ch = ' ';
				while (start < l) {
					ch = c[start];
					c[start] = c[l];
					c[l] = ch;
					start++;
					l--;
				}
				break;
			} else if (start + k == len) {
				int l = len - 1;
				char ch = ' ';
				while (start < l) {
					ch = c[start];
					c[start] = c[l];
					c[l] = ch;
					start++;
					l--;
				}
				break;
			} else if (start + k < len && start + 2 * k > len) {
				int l = start + k;
				char ch = ' ';
				while (start < l) {
					ch = c[start];
					c[start] = c[l - 1];
					c[l - 1] = ch;
					start++;
					l--;
				}
				break;
			} else if (start + 2 * k < len) {
				int l = start + k;
				char ch = ' ';
				int temp=l;
				while (start < l) {
					ch = c[start];
					c[start] = c[l - 1];
					c[l - 1] = ch;
					start++;
					l--;
				}
				start =temp+ k ;
			} else if (start + 2 * k == len) {
				int l = start + k;
				char ch = ' ';
				while (start < l) {
					ch = c[start];
					c[start] = c[l - 1];
					c[l - 1] = ch;
					start++;
					l--;
				}
				break;
			}
		}
		return new String(c);
	}

}
