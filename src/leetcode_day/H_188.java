package leetcode_day;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

import leetcode_list.ListNode;
import leetcode_tree.TreeNode;
import leetcode_tree.TreeUtils;

/**
 * 给定一个整数数组 prices ，它的第 i 个元素 prices[i] 是一支给定的股票在第 i 天的价格。
 * 
 * 设计一个算法来计算你所能获取的最大利润。你最多可以完成 k 笔交易。
 * 
 * @author jackjoily
 *
 */
public class H_188 {
	public static void main(String[] args) {
		int a[] = { 7, 6, 4, 3, 1 };
		System.out.println(maxProfit(a));
	}

	/**
	 * 限制只能有k交易次机会
	 * 
	 * @param k
	 * @param prices
	 * @return
	 */
	public int maxProfit1(int k, int[] prices) {
		int len = prices.length;
		if (len == 0)
			return 0;
		// buy[i][j] {0~i}，恰好进行了j笔交易的时候，拥有最高收入，持有一只股票
		int buy[][] = new int[len][k + 1];
		// buy[i][j] {0~i}，恰好进行了j笔交易的时候，拥有最高收入，没有股票的时候
		int sell[][] = new int[len][k + 1];
		buy[0][0] = -prices[0];
		sell[0][0] = 0;
		for (int i = 1; i <= k; i++) {
			buy[0][i] = sell[0][i] = Integer.MIN_VALUE / 2;
		}
		for (int i = 1; i < len; i++) {
			buy[i][0] = Math.max(buy[i - 1][0], sell[i - 1][0] - prices[i]);
			for (int j = 1; j <= k; j++) {
				buy[i][j] = Math.max(buy[i - 1][j], sell[i - 1][j] - prices[i]);
				sell[i][j] = Math.max(sell[i - 1][j], buy[i - 1][j - 1] + prices[i]);
			}
		}
	  return Arrays.stream(sell[len - 1]).max().getAsInt();
	}

	
	/**
	 * 限制只能有2交易次机会
	 * 
	 * @param 2
	 * @param prices
	 * @return
	 */
	public int maxProfit2(int k, int[] prices) {
		int len = prices.length;
		if (len == 0)
			return 0;
		// buy[i][j] {0~i}，恰好进行了j笔交易的时候，拥有最高收入，持有一只股票
		int buy[][] = new int[len][3];
		// buy[i][j] {0~i}，恰好进行了j笔交易的时候，拥有最高收入，没有股票的时候
		int sell[][] = new int[len][3];
		buy[0][0] = -prices[0];
		sell[0][0] = 0;
		for (int i = 1; i <= 2; i++) {
			buy[0][i] = sell[0][i] = Integer.MIN_VALUE / 2;
		}
		for (int i = 1; i < len; i++) {
			buy[i][0] = Math.max(buy[i - 1][0], sell[i - 1][0] - prices[i]);
			for (int j = 1; j <= k; j++) {
				buy[i][j] = Math.max(buy[i - 1][j], sell[i - 1][j] - prices[i]);
				sell[i][j] = Math.max(sell[i - 1][j], buy[i - 1][j - 1] + prices[i]);
			}
		}
	  return Arrays.stream(sell[len - 1]).max().getAsInt();
	}

	
	
	
	/**
	 * 无限制条件版本
	 * 
	 * @param prices
	 * @return
	 */

	public static int maxProfit(int[] prices) {
		int n = prices.length;
		int dp[] = new int[n];
		int up[] = new int[n];
		dp[0] = -prices[0];
		up[0] = 0;
		for (int i = 1; i < n; i++) {
			dp[i] = Math.max(dp[i - 1], up[i - 1] - prices[i]);
			up[i] = Math.max(up[i - 1], dp[i - 1] + prices[i]);
		}
		return Math.max(dp[n - 1], up[n - 1]);
	}
}
