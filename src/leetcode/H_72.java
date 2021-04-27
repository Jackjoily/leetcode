package leetcode;

import java.util.Arrays;
import java.util.HashMap;

/**
 * twosum
 * 
 * @author jackjoily
 *
 */
public class H_72 {
	public static void main(String[] args) {
		System.out.println(minDistance("horse", "ros"));
	}

	/**
	 * 
	 * 
	 * 
	 * 
	 * dp[i][j]的含义，word1中的前i个字符到word2中的前j个字符的最短编辑距离
	 * 
	 * @param word1
	 * @param word2
	 * @return
	 */
	public static int minDistance(String word1, String word2) {
		int m = word1.length();
		int n = word2.length();
		if (m == 0 || n == 0) {
			return m + n;
		}
		int dp[][] = new int[m + 1][n + 1];
		for (int i = 0; i < m + 1; i++) {
			dp[i][0] = i;
		}
		for (int j = 0; j < n + 1; j++) {
			dp[0][j] = j;
		}
		for (int i = 1; i < m + 1; i++) {
			for (int j = 1; j < n + 1; j++) {
				//这中情况对应的是word1中前i个到word2中前j个字符的最短编辑距离就是，
			   // 就是word1中前的i-1个到word2前j个字符的最短编辑距离，然后在末尾插上一个字符
				int left = dp[i - 1][j] + 1;
				//
				int right = dp[i][j - 1] + 1;
				//
				int left_right = dp[i - 1][j - 1];
				if (word1.charAt(i - 1) != word2.charAt(j - 1)) {
					left_right += 1;
				}
				dp[i][j] = Math.min(left, Math.min(left_right, right));
			}
		}
		return dp[m][n];
	}
}
