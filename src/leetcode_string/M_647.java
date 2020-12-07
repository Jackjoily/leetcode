package leetcode_string;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 
 * 给定一个字符串，你的任务是计算这个字符串中有多少个回文子串。
 * 
 * 具有不同开始位置或结束位置的子串，即使是由相同的字符组成，也会被视作不同的子串。
 * 
 * @author jackjoily
 *
 */
public class M_647 {
	public static void main(String[] args) {
		System.out.println(countSubstrings("aaa"));
	}

	public static int countSubstrings(String s) {
		int len = s.length();
		int temp = 0;
		boolean dp[][] = new boolean[len][len];
		for (int i = 0; i < len; i++) {
			dp[i][i] = true;
			temp++;
		}
		for (int i = len - 1; i >= 0; i--) {
			for (int j = len - 1; j > i; j--) {
				if (j - i == 1) {
					if (s.charAt(i) == s.charAt(j)) {
						dp[i][j] = true;
						temp++;
					}
				} else {
					if (s.charAt(i) == s.charAt(j) && dp[i + 1][j - 1]) {
						dp[i][j] = true;
						temp++;
					}
				}
			}
		}
		return temp;
	}

	/**
	 * 中心扩散的方法
	 */
	public static int countSubstrings1(String s) {
		if (s.length() == 0)
			return 0;
		int n = s.length(), ans = 0;
		/**
		 * 这里可以分两种情况来做，一种是技术的情况，一种是偶数的情况
		 * 
		 * 我们不妨写一组出来观察观察，假设 n = 4n=4，
		 * 我们可以把可能的回文中心列出来：
		 * 
		 * 0	0   0
           1	0	1
           2	1	1
           3	1	2
           4	2	2
           5	2	3
           6 	3	3
		 * 
		 */
		for (int i = 0; i < 2 * n - 1; ++i) {
			int l = i / 2, r = i / 2 + i % 2;
			while (l >= 0 && r < n && s.charAt(l) == s.charAt(r)) {
				--l;
				++r;
				++ans;
			}
		}
		return ans;
	}
}
