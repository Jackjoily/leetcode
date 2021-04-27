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
public class M_309 {

	public static void main(String[] args) {
		int a[] = { 1, 2, 3, 4, 2};
		System.out.println(maxProfit(a));
	}

	public static int maxProfit(int[] prices) {
		int n = prices.length;
		if (n <= 1)
			return 0;
		/**
		 * 0 不持有 1 持有 2 冷冻期
		 */
		int dp[][] = new int[n][3];
		dp[0][0] = 0;
		dp[0][1] = -prices[0];
		dp[0][2] = 0;
		int max = 0;
		for (int i = 1; i < n; i++) {
			// 不含有股票
			dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][2]);
			// 拥有股票
			dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] - prices[i]);
			dp[i][2] = dp[i - 1][1] + prices[i];
		}
		max = Math.max(Math.max(dp[n - 1][0], dp[n - 1][1]), dp[n - 1][2]);
		return max;
	}
}
