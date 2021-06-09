package leetcode;

import java.util.Arrays;
import java.util.HashMap;

import com.sun.org.apache.xerces.internal.util.SynchronizedSymbolTable;

import leetcode_list.ListNode;

/**
 * 给你一个字符串 s，找到 s 中最长的回文子串。
 * 
 * @author jackjoily
 *
 */
public class M_5 {
	public static void main(String[] args) {
		System.out.println(longestPalindrome1("aaaa"));
	}

	public static String longestPalindrome1(String s) {
		int n = s.length();
		if (n == 1)
			return s;
		String str ="";
		int max = 0;
		for (int i = 0; i < n; i++) {
			int res = isOkay(s, i, i, n);
			int res1 = isOkay(s, i, i + 1, n);
			if (res > res1) {
				if (res > max) {
					max = res;
					int count = (res - 1) / 2;
					str = s.substring(i - count, i + count + 1);
				}
			} else {
				if (res1 > max) {
					max = res1;
					int count = (res1 - 2) / 2;
					str = s.substring(i - count, i + 1 + count + 1);
				}
			}
		}
		return str;
	}

	public static int isOkay(String str, int i, int j, int n) {
		int max = 0;
		if (i == j) {
			max = 1;
			int left = i - 1;
			int right = i + 1;
			while (left >= 0 && right < n && str.charAt(left) == str.charAt(right)) {
				max += 2;
				left--;
				right++;
			}
		} else {
			if (j >= n)
				return 0;
			if (str.charAt(i) == str.charAt(j)) {
				max = 2;
				int left = i - 1;
				int right = j + 1;
				while (left >= 0 && right < n && str.charAt(left) == str.charAt(right)) {
					max += 2;
					left--;
					right++;
				}
			}
		}
		return max;
	}

	/**
	 * 还可以使用中心扩展算法
	 * 
	 * @param s
	 * @return
	 */
	public static String longestPalindrome(String s) {
		char[] c = s.toCharArray();
		int n = s.length();
		if (n == 1)
			return s;
		int max = 1;
		int i;
		int j;
		int dp[][] = new int[n][n];
		int p = 0, q = 0;
		for (i = 0; i < n; i++) {
			dp[i][i] = 1;
		}
		for (i = n - 1; i >= 0; i--) {
			for (j = n - 1; j >= i; j--) {
				if (c[j] == c[i]) {
					if (i + 1 < n && j >= 1) {
						if (dp[i + 1][j - 1] == (j - 1 - i)) {
							dp[i][j] = j - i + 1;
							if (max < dp[i][j]) {
								max = dp[i][j];
								p = i;
								q = j;
							}
						}
					}
				}
			}
		}
		return s.substring(p, q + 1);
	}
}
