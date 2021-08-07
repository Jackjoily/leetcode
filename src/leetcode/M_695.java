package leetcode;

import java.util.Arrays;
import java.util.HashMap;

import com.sun.org.apache.xerces.internal.util.SynchronizedSymbolTable;

import leetcode_list.ListNode;

/**
 * 
 * @author jackjoily
 *
 */
public class M_695 {

	public static void main(String[] args) {
		int a[][] = { { 0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0 },
				{ 0, 1, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0 }, { 0, 1, 0, 0, 1, 1, 0, 0, 1, 0, 1, 0, 0 },
				{ 0, 1, 0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 0 }, { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0 },
				{ 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0 }, { 0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0 } };
		System.out.println(maxAreaOfIsland(a));
	}

	public static int max = 0;
	static int directions[][] = { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };
	public static int max1 = 0;

	public static int maxAreaOfIsland(int[][] grid) {
		int m = grid.length;
		int n = grid[0].length;
		boolean used[][] = new boolean[m][n];
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (grid[i][j] != 0 && !used[i][j]) {
					max = 0;
					f(grid, used, i, j, m, n);
					max1 = Math.max(max, max1);
				}
			}
		}
		return max1;
	}

	public static void f(int a[][], boolean used[][], int i, int j, int m, int n) {
		used[i][j] = true;
		max++;
		for (int b[] : directions) {
			int newi = i + b[0];
			int newj = j + b[1];
			if (newi >= 0 && newi < m && newj >= 0 && newj < n && !used[newi][newj] && a[newi][newj] == 1) {
				f(a, used, newi, newj, m, n);
			}
		}

	}
}
