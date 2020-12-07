package leetcode_string;

import java.util.HashMap;
import java.util.Map;

import edu.princeton.cs.algs4.Stack;

/**
 * 
 * 在一个「平衡字符串」中，'L' 和 'R' 字符的数量是相同的。
 * 
 * 给出一个平衡字符串 s，请你将它分割成尽可能多的平衡字符串。
 * 
 * 返回可以通过分割得到的平衡字符串的最大数量。
 * 
 * @author jackjoily
 *
 */
public class E_1221 {
	public static void main(String[] args) {
		System.out.println(balancedStringSplit("LLLLRRRR"));
	}

	public static int balancedStringSplit(String s) {
		if (s.length() == 1)
			return 0;
		int i = 0;
		int r = 0, l = 0;
		int res = 0;
		for (; i < s.length(); i++) {
			if (s.charAt(i) == 'R') {
				if (l > 0) {
					l--;
				} else {
					r++;
				}
			} else {
				if (r > 0) {
					r--;
				} else {
					l++;
				}
			}
			if (r == 0 && l == 0) {
				res++;
			}
		}
		return res;
	}
}
