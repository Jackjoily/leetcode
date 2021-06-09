package leetcode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Queue;

import javafx.scene.shape.Line;
import leetcode_list.ListNode;
import leetcode_tree.TreeNode;

/**
 * 
 * @author jackjoily
 *
 */
public class M_1143 {
	public static void main(String[] args) {
		System.out.println(longestCommonSubsequence("abcde", "ace"));

	}

	public static int longestCommonSubsequence(String text1, String text2) {
		int m = text1.length();
		int n = text2.length();
		if (m * n == 0)
			return m + n;
		char[] c = text1.toCharArray();
		char[] c1 = text2.toCharArray();
		int dp[][] = new int[m][n];
		int max = 0;
		if (c[0] == c1[0]) {
			dp[0][0] = 1;
		}
		for (int i = 1; i < m; i++) {
			if (c[i] == c1[0]) {
				dp[i][0] = 1;
			} else {
				dp[i][0] = dp[i - 1][0];
			}
		}
		for (int j = 1; j < n; j++) {
			if (c[0] == c1[1]) {
				dp[j][0] = 1;
			} else {
				dp[j][0] = dp[j - 1][0];
			}
		}
		for (int i = 1; i < m; i++) {
			for (int j = 1; j < n; j++) {
				if (c[i] == c1[j]) {
					dp[i][j] = dp[i - 1][j - 1] + 1;
				} else {
					dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j]);
				}
			}
		}
		return dp[m-1][n-1];
	}
}
