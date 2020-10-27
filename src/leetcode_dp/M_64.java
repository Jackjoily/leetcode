package leetcode_dp;

/**
 * 给定一个包含非负整数的 m x n 网格， 请找出一条从左上角到右下角的路径， 使得路径上的数字总和为最小。
 * 
 * 说明：每次只能向下或者向右移动一步。
 * 
 * @author jackjoily
 *
 */
public class M_64 {
	public int minPathSum(int[][] grid) {
		int n = grid.length;
		int m = grid[0].length;
		if (n == 0 || m == 0)
			return 0;
		int dp[][] = new int[n][m];
		dp[0][0] = 0;
		for (int i = 1; i < n; i++) {
			dp[i][0] = dp[i - 1][0] + grid[i][0];
		}
		for (int i = 1; i < m; i++) {
			dp[0][i] = dp[0][i - 1] + grid[0][i];
		}
		for (int i = 1; i < n; i++) {
			for (int j = 1; j < m; j++) {
				dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]) + grid[i][j];
			}
		}
		return dp[n-1][m-1];
	}
}
