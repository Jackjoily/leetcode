package leetcode_string;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 你有两个字符串，即pattern和value。 pattern字符串由字母"a"和"b"组成，用于描述字符串中的模式。
 * 例如，字符串"catcatgocatgo"匹配模式"aabab"（其中"cat"是"a"，"go"是"b"），该字符串也匹配像"a"、"ab"和"b"这样的模式。但需注意"a"和"b"不能同时表示相同的字符串。编写一个方法判断value字符串是否匹配pattern字符串。
 * 
 * @author jackjoily
 *
 */
public class MianShi1618 {
	public static void main(String[] args) {
		System.out.println(patternMatching("bbbaa", "xxxxxxy"));
	}

	public static boolean patternMatching(String pattern, String value) {
		if (pattern.length() == 0)
			return false;
		int plen = pattern.length();
		int vlen = value.length();
		int c[] = new int[2];
		for (int i = 0; i < plen; i++) {
			c[pattern.charAt(i) - 'a']++;
		}
		// a分配最大个数
		int al = c[0] == 0 ? 0 : vlen / c[0];
		for (int i = 0; i <= al; i++) {
			if (c[1] != 0 && (vlen - c[0] * i) % c[1] != 0) {
				continue;
			}
			if (c[1] == 0 && c[0] * i < vlen) {
				continue;
			}
			int bl = c[1] == 0 ? 0 : (vlen - c[0] * i) / c[1];
			if (match(pattern, value, i, bl)) {
				return true;
			}
		}
		return false;
	}

	public static boolean match(String p, String v, int al, int bl) {
		String pl = null;
		String vl = null;
		int start = 0;
		for (int i = 0; i < p.length(); i++) {
			if (p.charAt(i) == 'a') {
				if (pl == null) {
					pl = v.substring(start, start + al);
				} else {
					if (!pl.equals(v.substring(start, start + al))) {
						return false;
					}
				}
				start += al;
			} else {
				if (vl == null) {
					vl = v.substring(start, start + bl);
				} else {
					if (!vl.equals(v.substring(start, start + bl))) {
						return false;
					}
				}
				start += bl;
			}
			if (start > v.length()) {
				return false;
			}
			if (pl != null && vl != null && pl.equals(vl))
				return false;
		}
		return true;
	}

	public static String getCompress(String pattern) {
		StringBuilder sb = new StringBuilder();
		char ch = pattern.charAt(0);
		int temp = 1;
		for (int i = 1; i < pattern.length(); i++) {
			if (pattern.charAt(i) != ch) {
				sb.append(temp + ".");
				ch = pattern.charAt(i);
				temp = 1;
			} else {
				temp++;
			}
		}
		sb.append(temp);
		return sb.toString();
	}

}
