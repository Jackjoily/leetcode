package leetcode_dp;

import java.util.Arrays;

/**
 * 一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为“Start” ）。
 * 
 * 机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为“Finish”）。
 * 
 * 现在考虑网格中有障碍物。那么从左上角到右下角将会有多少条不同的路径？
 * 
 * @author jackjoily
 *
 */
public class M_63 {
	static int m = 9;
	static int n = 9;
	static int count = 0;

	public static void main(String[] args) {
		int a[][] = { { 0, 1, 0, 0, 0, 0, 0, 0, 0 }, { 0, 1, 0, 0, 0, 0, 0, 0, 0 }, { 0, 1, 0, 0, 0, 0, 0, 0, 0 },
				{ 0, 0, 1, 0, 0, 0, 0, 0, 0 }, { 0, 0, 1, 1, 1, 1, 1, 1, 0 }, { 0, 0, 1, 0, 0, 0, 1, 1, 0 },
				{ 0, 0, 1, 0, 1, 0, 1, 1, 0 }, { 0, 1, 1, 0, 1, 0, 1, 1, 0 }, { 0, 0, 0, 0, 1, 0, 0, 0, 0 }, };

		int uniquePathsWithObstacles = uniquePathsWithObstacles(a);
		System.out.println(uniquePathsWithObstacles);
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				System.out.print(a[i][j] + " ,");
			}
			System.out.println();
		}
		uniquePathsWithObstacles1(a, 0, 0);
		System.out.println(count);
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				System.out.print(a[i][j] + " ,");
			}
			System.out.println();
		}
	}

	/**
	 * 法一 使用动态规划的想法
	 * 
	 * @param obstacleGrid
	 * @return
	 */
	public static int uniquePathsWithObstacles(int[][] obstacleGrid) {
		int n = obstacleGrid.length;
		int m = obstacleGrid[0].length;
		if (n == 0 || m == 0)
			return 0;

		int dp[][] = new int[n][m];
		// n行数，m列数
		for (int i = 0; i < n; i++) {
			if (obstacleGrid[i][0] != 1) {
				dp[i][0] = 1;
			} else {
				break;
			}
		}
		for (int i = 0; i < m; i++) {
			if (obstacleGrid[0][i] != 1) {
				dp[0][i] = 1;
			} else {
				break;
			}
		}
		for (int i = 1; i < n; i++) {
			for (int j = 1; j < m; j++) {
				if (obstacleGrid[i][j] != 1) {
					dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
				}
			}
		}
		return dp[n - 1][m - 1];
	}

	/**
	 * 法二
	 * 
	 * @param obstacleGrid
	 * @return
	 */

	public static boolean uniquePathsWithObstacles1(int[][] obstacleGrid, int p, int q) {
		if (p == n - 1 && q == m - 1) {
			obstacleGrid[n - 1][m - 1] = 2;
			count++;
			return true;
		} else if (p >= m || q >= n) {
			return false;
		} else {
			if (obstacleGrid[p][q] != 1) {
				obstacleGrid[p][q] = 2;
				if (uniquePathsWithObstacles1(obstacleGrid, p, q + 1)) {
					return true;
				} else if (uniquePathsWithObstacles1(obstacleGrid, p + 1, q)) {
					return true;
				}
				return false;
			}
		}
		return false;
	}
}
