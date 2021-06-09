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
public class M_200 {
	public static void main(String[] args) {
		M_200 m = new M_200();
		char a[][] = { { '1', '1', '0', '0', '0' }, 
				{ '1', '1', '0', '0', '0' },
				{ '0', '0', '1', '0', '0' },
				{ '0', '0', '0', '1', '1' } }

		;
		System.out.println(m.numIslands(a));
	}

	boolean used[][];
	int directions[][] = { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };

	public int numIslands(char[][] grid) {
		int m = grid.length;
		int n = grid[0].length;
		int count = 0;
		used = new boolean[m][n];
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (!used[i][j] && grid[i][j] == '1') {
					f(grid, i, j, used, m, n);
					count++;
				}
		
			}
		}
		return count;
	}

	public void f(char[][] c, int i, int j, boolean used[][], int m, int n) {
		if (!used[i][j] && c[i][j] == '1') {
			used[i][j] = true;
			for (int a[] : directions) {
				int newi = a[0] + i;
				int newj = a[1] + j;
				if (newi >= 0 && newi < m && newj >= 0 && newj < n) {
					f(c, newi, newj, used, m, n);
				}
			}
		}
	}
}
