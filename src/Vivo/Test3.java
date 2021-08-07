package Vivo;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

/**
 * 
 * @author jackjoily
 *
 */
public class Test3 {

	private static int[][] posi = new int[][] { { 0, -1 }, { 0, 1 }, { 1, 0 }, { -1, 0 } };
	static int len;
	static int start_y;
	static int start_x;
	static int end_y;
	static int end_x;
	static int[][] dp;

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		len = in.nextInt();
		start_y = in.nextInt();
		start_x = in.nextInt();
		end_y = in.nextInt();
		end_x = in.nextInt();

		char[][] grid = new char[len][len];
		in.nextLine();
		dp = new int[len][len];
		for (int i = 0; i < len; i++) {
			grid[i] = in.nextLine().toCharArray();
			Arrays.fill(dp[i], Integer.MAX_VALUE);
		}
	
		calcWayDistance(grid, start_x, start_y, len, len, 0);
		if (dp[end_x][end_y] == Integer.MAX_VALUE) {
			System.out.println(-1);
		} else {
			System.out.println(dp[end_x][end_y]-1);
		}

	}

	private static void calcWayDistance(char[][] grid, int x, int y, int m, int n, int dis) {
		if (dis > dp[x][y]) {
			return;
		}
		dp[x][y] = dis + 1;
		for (int a[] : posi) {
			int newx = a[0] + x;
			int newy = a[1] + y;
			if (newx >= 0 && newx < m && newy >= 0 && newy < n && grid[newx][newy] != '@' && grid[newx][newy] != '#') {
				calcWayDistance(grid, newx, newy, m, n, dis + 1);
			}
		}
	}
}
