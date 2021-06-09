package leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

/**
 * twosum
 * 
 * @author jackjoily
 *
 */
public class H_329 {
	public static void main(String[] args) {
		H_329 h = new H_329();
		int a[][] = { { 9, 9, 4 }, { 6, 6, 8 }, { 2, 1, 1 } };
		System.out.println(h.longestIncreasingPath1(a));
	}

	int directions[][] = { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };

	public int[][] dirs = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };
	public int rows, columns;

	// 把最长的路径作为广度优先的层数来考虑
	public int longestIncreasingPath1(int[][] matrix) {
		if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
			return 0;
		}
		rows = matrix.length;
		columns = matrix[0].length;
		int[][] outdegrees = new int[rows][columns];
		for (int i = 0; i < rows; ++i) {
			for (int j = 0; j < columns; ++j) {
				for (int[] dir : dirs) {
					int newRow = i + dir[0], newColumn = j + dir[1];
					if (newRow >= 0 && newRow < rows && newColumn >= 0 && newColumn < columns
							&& matrix[newRow][newColumn] > matrix[i][j]) {
						++outdegrees[i][j];
					}
				}
			}
		}
		Queue<int[]> queue = new LinkedList<int[]>();
		for (int i = 0; i < rows; ++i) {
			for (int j = 0; j < columns; ++j) {
				if (outdegrees[i][j] == 0) {
					queue.offer(new int[] { i, j });
				}
			}
		}
		int ans = 0;
		while (!queue.isEmpty()) {
			++ans;
			int size = queue.size();
			for (int i = 0; i < size; ++i) {
				int[] cell = queue.poll();
				int row = cell[0], column = cell[1];
				for (int[] dir : dirs) {
					int newRow = row + dir[0], newColumn = column + dir[1];
					if (newRow >= 0 && newRow < rows && newColumn >= 0 && newColumn < columns
							&& matrix[newRow][newColumn] < matrix[row][column]) {
						--outdegrees[newRow][newColumn];
						if (outdegrees[newRow][newColumn] == 0) {
							queue.offer(new int[] { newRow, newColumn });
						}
					}
				}
			}
		}
		return ans;
	}

	public int longestIncreasingPath(int[][] matrix) {
		int m = matrix.length;
		int n = matrix[0].length;
		if (matrix == null || m == 0 || n == 0) {
			return 0;
		}

		int dp[][] = new int[m][n];
		int res = 0;
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				res = Math.max(res, dfs(dp, matrix, i, j, m, n));
			}
		}
		return res;
	}

	private int dfs(int[][] dp, int[][] matrix, int i, int j, int m, int n) {
		if (dp[i][j] != 0)
			return dp[i][j];
		dp[i][j]++;
		for (int l = 0; l < 4; l++) {
			int newi = directions[l][0] + i;
			int newj = directions[l][1] + j;
			if (newi >= 0 && newj >= 0 && newi < m && newj < n && matrix[i][j] < matrix[newi][newj]) {
				dp[i][j] = Math.max(dp[i][j], dfs(dp, matrix, newi, newj, m, n) + 1);
			}
		}
		return dp[i][j];
	}
}
