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
		if (m * n == 0) {
			return m + n;
		}
		int dp[][] = new int[m + 1][n + 1];
		for (int i = 0; i <=m; i++) {
			dp[i][0] = i;
		}
		for (int j = 0; j <=n; j++) {
			dp[0][j] = j;
		}
		for (int i = 1; i <= m; i++) {
			for (int j = 1; j <= n; j++) {
				int left = dp[i - 1][j]+1;
				int right = dp[i][j - 1]+1;
				int left_right = dp[i - 1][j - 1];
				if (word1.charAt(i - 1) != word2.charAt(j - 1)) {
					left_right += 1;
				}
				dp[i][j] = Math.min(Math.min(left, right), left_right);
			}
		}
		return dp[m][n];
	}
}
