package leetcode_day;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

import leetcode_list.ListNode;
import leetcode_tree.TreeNode;
import leetcode_tree.TreeUtils;

public class M_1631 {
	public static void main(String[] args) {
		int a[][]={{1,2,1,1,1},{1,2,1,2,1},{1,2,1,2,1},{1,2,1,2,1},{1,1,1,2,1}};
		System.out.println(minimumEffortPath(a));
	}

	public static int minimumEffortPath(int[][] heights) {
		// 取权重最小节点遍历
		Queue<int[]> queue = new ArrayDeque<>();
		int h = heights.length;
		int w = heights[0].length;
		int[][] dp = new int[h][w];
		for (int i = 0; i < h; i++) {
			for (int j = 0; j < w; j++) {
				dp[i][j] = Integer.MAX_VALUE;
			}
		}
		dp[0][0] = 0;
		queue.add(new int[] {0,0});
		int dx[] = { 0, 1, 0, -1 }, dy[] = { 1, 0, -1, 0 };
		while (!queue.isEmpty()) {
		       int v[]=queue.poll();
				int x = v[0];
				int y = v[1];
			if (x == h - 1 && y == w - 1) { // 此时尾节点为权重最小，直接返回，不需要再做多余遍历
				return dp[h - 1][w - 1];
			}
			for (int d = 0; d < 4; d++) {
				int a = x + dx[d], b = y + dy[d];
				if (a >= 0 && a < h && b >= 0 && b < w) {
					int max = Math.max(Math.abs(heights[x][y] - heights[a][b]), dp[x][y]);
					if (max >= dp[a][b]) {
						continue;
					}
					dp[a][b] = max;
					queue.add(new int[] { a, b });
				}
			}
		}
		return dp[h - 1][w - 1];
	}

}