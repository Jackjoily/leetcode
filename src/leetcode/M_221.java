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
public class M_221 {
	public static void main(String[] args) {
		char a[][] = { 
				{ '1', '0', '1', '0', '0' }, 
				{ '1', '0', '1', '1', '1' }, 
				{ '1', '1', '1', '1', '1' },
				{ '1', '0', '0', '1', '0' } };
		System.out.println(maximalSquare(a));
	}

	public static int maximalSquare(char[][] matrix) {
		int m = matrix.length;
		int n = matrix[0].length;
		int dp[][] = new int[m][n];
		int max = 0;
		for (int i = 0; i < m; i++) {
			if (matrix[i][0] == '1') {
				dp[i][0] = 1;
			}
		}
		for (int j = 0; j < n; j++) {
			if (matrix[0][j] == '1') {
				dp[0][j] = 1;
			}
		}
		for (int i = 1; i < m; i++) {
			for (int j = 1; j < n; j++) {
				if (matrix[i][j] == '1') {
					dp[i][j] = Math.min(Math.min(dp[i - 1][j], dp[i][j - 1]), dp[i - 1][j - 1]) + 1;
					max = Math.max(dp[i][j], max);
				}
			}
		}
		return max * max;
	}
}
