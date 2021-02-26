package leetcode_dp;

import java.util.LinkedList;
import java.util.List;

import edu.princeton.cs.algs4.In;

/**
 * 给定两个字符串 text1 和 text2，返回这两个字符串的最长公共子序列的长度。
 * 一个字符串的 子序列 是指这样一个新的字符串：它是由原字符串在不改变字符的相对顺序的情况下删除某些字符（也可以不删除任何字符）后组成的新字符串。
 * 例如，"ace" 是 "abcde" 的子序列，但 "aec" 不是 "abcde"
 * 的子序列。两个字符串的「公共子序列」是这两个字符串所共同拥有的子序列。 若这两个字符串没有公共子序列，则返回 0。
 * 
 * @author jackjoily
 *
 */
public class M_1143 {
	public static void main(String[] args) {
		System.out.println(longestCommonSubsequence1("12321", "32147"));
	}

	/**
	 * 求的是最长公共子序列，可以不是连续的序列
	 * 
	 * @param text1
	 * @param text2
	 * @return
	 */
	public static int longestCommonSubsequence(String text1, String text2) {
		int m = text1.length();
		int n = text2.length();
		if (m == 0 || n == 0)
			return 0;
		int dp[][] = new int[m][n];
		int max = 0;
		if (text1.charAt(0) == text2.charAt(0)) {
			dp[0][0] = 1;
		}
		for (int i = 1; i < m; i++) {
			if (text1.charAt(i) == text2.charAt(0)) {
				dp[i][0] = 1;
			} else {
				dp[i][0] = Math.max(dp[i - 1][0], 0);
			}
			max = Math.max(max, dp[i][0]);
		}
		for (int j = 1; j < n; j++) {
			if (text1.charAt(0) == text2.charAt(j)) {
				dp[0][j] = 1;
			} else {
				dp[0][j] = Math.max(dp[0][j - 1], 0);
			}
			max = Math.max(max, dp[0][j]);
		}
		for (int i = 1; i < m; i++) {
			for (int j = 1; j < n; j++) {
				if (text1.charAt(i) == text2.charAt(j)) {
					dp[i][j] = dp[i - 1][j - 1] + 1;
					max = Math.max(dp[i][j], max);
				} else {
					dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
					max = Math.max(dp[i][j], max);
				}
			}
		}
		return max;
	}

	/**
	 * 
	 * 求的是最长公共子串，必须是连续的序列
	 * 
	 * @param text1
	 * @param text2
	 * @return
	 */
	public static int longestCommonSubsequence1(String text1, String text2) {
		int m = text1.length();
		int n = text2.length();
		int dp[][] = new int[m][n];
		int max = 0;
		if (text1.charAt(0) == text2.charAt(0)) {
			dp[0][0] = 1;
		}
		for (int i = 1; i < m; i++) {
			if (text1.charAt(i) == text2.charAt(0)) {
				dp[i][0] = 1;
			}
		}
		for (int j = 1; j < n; j++) {
			if (text1.charAt(0) == text2.charAt(j)) {
				dp[0][j] = 1;
			}
		}
		for (int i = 1; i < m; i++) {
			for (int j = 1; j < n; j++) {
				if (text1.charAt(i) == text2.charAt(j)) {
					dp[i][j] = dp[i - 1][j - 1] + 1;
				}
				max = Math.max(dp[i][j], max);
			}
		}
		return max;
	}
}
