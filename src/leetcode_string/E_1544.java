package leetcode_string;

import java.util.HashMap;
import java.util.Map;

/**
 * 给你一个由大小写英文字母组成的字符串 s 。
 * 
 * 一个整理好的字符串中，两个相邻字符 s[i] 和 s[i+1]，其中 0<= i <= s.length-2 ，要满足如下条件:
 * 
 * 若 s[i] 是小写字符，则 s[i+1] 不可以是相同的大写字符。 若 s[i] 是大写字符，则 s[i+1] 不可以是相同的小写字符。
 * 请你将字符串整理好，每次你都可以从字符串中选出满足上述条件的 两个相邻 字符并删除，直到字符串整理好为止。
 * 
 * 请返回整理好的 字符串 。题目保证在给出的约束条件下，测试样例对应的答案是唯一的。
 * 
 * 注意：空字符串也属于整理好的字符串，尽管其中没有任何字符。
 * 
 * @author jackjoily
 *
 */
public class E_1544 {
	public static void main(String[] args) {
		System.out.println(makeGood("abBAcC"));
	}

	public static String makeGood(String s) {
		if (s.length() == 1)
			return s;
		StringBuilder sb = new StringBuilder();
		int i = 0;
		for (; i < s.length() - 1;) {
			if (s.charAt(i) != s.charAt(i + 1) + 32 && s.charAt(i) != s.charAt(i + 1) - 32) {
				if (sb.length() > 0) {
					if (s.charAt(i) != sb.charAt(sb.length() - 1) + 32
							&& s.charAt(i) != sb.charAt(sb.length() - 1) - 32) {
						sb.append(s.charAt(i));
					} else {
						sb.delete(sb.length() - 1, sb.length());
					}
				} else {
					sb.append(s.charAt(i));
				}
				i++;
			} else {
				i += 2;
			}
		}
		if (i == s.length()-1) {
			if (sb.length() > 0) {
				if (s.charAt(i) != sb.charAt(sb.length() - 1) + 32
						&& s.charAt(i) != sb.charAt(sb.length() - 1) - 32) {
					sb.append(s.charAt(i));
				} else {
					sb.delete(sb.length() - 1, sb.length());
				}
			} else {
				sb.append(s.charAt(i));
			}
		}
		return sb.toString();
	}
}
