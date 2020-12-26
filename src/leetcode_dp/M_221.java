package leetcode_dp;

import java.util.LinkedList;
import java.util.List;

import edu.princeton.cs.algs4.In;

/**
 * 
 * 在一个由 '0' 和 '1' 组成的二维矩阵内，找到只包含 '1' 的最大正方形，并返回其面积。
 * 
 * @author jackjoily
 *
 */
public class M_221 {
	public static void main(String[] args) {
		char a[][] = { { '1', '0', '1', '0', '0' }, { '1', '0', '1', '1', '1' }, { '1', '1', '1', '1', '1' },
				{ '1', '0', '0', '1', '0' } };
		System.out.println(maximalSquare(a));
	}

	public static int maximalSquare(char[][] matrix) {
		int m = matrix.length;
		int n = matrix[0].length;
		if (m == 0 || n == 0)
			return 0;
		// matrix[i][j]为右下角 且全都是1最大边长
		int dp[][] = new int[m + 1][n + 1];
		for (int i = 0; i < m; i++) {
			dp[i][0] = 0;
		}
		for (int j = 0; j < n; j++) {
			dp[0][j] = 0;
		}
		int max = 0;
		for (int i = 1; i <= m; i++) {
			for (int j = 1; j <= n; j++) {
				if (matrix[i - 1][j - 1] == '0') {
					dp[i][j] = 0;
				} else {
					// 重点
					dp[i][j] = Math.min(Math.min(dp[i - 1][j], dp[i][j - 1]), dp[i - 1][j - 1]) + 1;
					max = Math.max(max, dp[i][j]);
				}
			}
		}
		return max * max;
	}
}
