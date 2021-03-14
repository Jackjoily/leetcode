package leetcode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

import javafx.scene.shape.Line;
import leetcode_list.ListNode;
import leetcode_tree.TreeNode;

/**
 * 
 * @author jackjoily
 *
 */
public class M_994 {

	public int orangesRotting(int[][] grid) {
		int m = grid.length;
		int n = grid[0].length;
		Queue<String> queue = new ArrayDeque<>();
		int count = 0;
		int time = 0;
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (grid[i][j] == 2) {
					queue.add(i + "," + j);
				}
				if (grid[i][j] == 1) {
					count++;
				}
			}
		}
		boolean flag = true;
		int a[][] = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };
		while (flag && count > 0) {
			flag = false;
			for (int k = queue.size(); k >= 1; k--) {
				String str = queue.poll();
				int i = str.charAt(0) - '0';
				int j = str.charAt(2) - '0';
				for (int l = 0; l < a.length; l++) {
					int newi = i + a[l][0];
					int newj = j + a[l][1];
					if (newi >= 0 && newi <= m && newj >= 0 && newj <= n) {
						if (grid[newi][newj] == 1) {
							grid[newi][newj] = 2;
							count--;
							queue.add(newi + "," + newj);
							flag = true;
						}
					}
				}
			}
			time++;
		}
		if (count > 0) {
			return -1;
		} else {
			return time;
		}
	}
}
