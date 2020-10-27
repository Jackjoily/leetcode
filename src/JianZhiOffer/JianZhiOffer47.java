package JianZhiOffer;

/**
 * 在一个 m*n 的棋盘的每一格都放有一个礼物，每个礼物都有一定的价值（价值大于 0）。
 * 你可以从棋盘的左上角开始拿格子里的礼物，并每次向右或者向下移动一格、直到到达棋盘的右下角。
 * 给定一个棋盘及其上面的礼物的价值，请计算你最多能拿到多少价值的礼物？
 * 
 * 
 * @author jackjoily
 *
 */
public class JianZhiOffer47 {
	public static void main(String[] args) {
		JianZhiOffer47 j = new JianZhiOffer47();
		int a[][] = { { 1, 2, 5}, { 3, 2, 1 } };
		System.out.println(		maxValue(a));
		// int maxValue1 = maxValue1(a, 2, 2);
		// System.out.println(maxValue1);
	}

	/**
	 * 
	 * [ [1,3,1], [1,5,1], [4,2,1] ]
	 * 
	 * @param grid
	 * @return
	 */
	public static int maxValue(int[][] grid) {
		int m = grid.length;
		int n = grid[0].length;
		if (m == 0 || n == 0)
			return 0;
		int dp[][] = new int[m][n];
		int j, i;
		dp[0][0] = grid[0][0];
		for (i = 1; i < m; i++) {
			dp[i][0] = dp[i - 1][0] + grid[i][0];
		}
		for (i = 1; i < n; i++) {
			dp[0][i] = dp[0][i - 1] + grid[0][i];
		}
		for (i = 1; i < m; i++) {
			for (j = 1; j < n; j++) {
				dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]) + grid[i][j];
			}
		}
		return dp[m-1][n-1];
	}

	/**
	 * 递归算法
	 * 
	 * @param grid
	 * @param m
	 * @param n
	 * @return
	 */
	public int maxValue1(int[][] grid, int m, int n) {
		if (m == 0 && n == 0) {
			return grid[0][0];
		} else if (m < 0 || n < 0) {
			return 0;

		} else {
			int res = 0;
			res = grid[m][n] + Math.max(maxValue1(grid, m - 1, n), maxValue1(grid, m, n - 1));
			return res;
		}
	}
}
