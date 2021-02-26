package leetcode_day;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

/**
 *
 *
 * 给定两个字符串 s 和 t，判断它们是否是同构的。 如果 s 中的字符可以被替换得到 t ，那么这两个字符串是同构的。
 * 所有出现的字符都必须用另一个字符替换，同时保留字符的顺序。两个字符不能映射到同一个字符上，但字符可以映射自己本身。
 *
 *
 *
 *
 *
 */
public class E_205 {

	public boolean isIsomorphic(String s, String t) {
		if (s.length() != t.length()) {
			return false;
		} else {
			for (int i = 0; i < s.length(); i++) {
				if (s.indexOf(s.charAt(i)) != t.indexOf(t.charAt(i))) {
					return false;
				}
			}
		}
		return true;
	}
}
