package leetcode_dp;

import java.util.LinkedList;
import java.util.List;

import edu.princeton.cs.algs4.In;

/**
 * 给定一个整数数组，其中第 i 个元素代表了第 i 天的股票价格 。​
 * 
 * 设计一个算法计算出最大利润。在满足以下约束条件下，你可以尽可能地完成更多的交易（多次买卖一支股票）:
 * 
 * 你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。 卖出股票后，你无法在第二天买入股票 (即冷冻期为 1 天)。
 * 
 * @author jackjoily
 *
 */
public class M_309 {
	public static void main(String[] args) {
		int a[] = { 1, 2, 3, 0, 2 };
		System.out.println(maxProfit(a));
	}

	/**
	 * 定义三种状态
	 * 
	 * @param prices
	 * @return
	 */
	public static int maxProfit(int[] prices) {
		int length = prices.length;
		if (length <= 1)
			return 0;

		/**
		 * 三种状态 dp[i][0] 持有股票的时候最大收益，不是冷冻期
		 *  dp[i][1]   没有股票，且是冷冻期
		 *   dp[i][2] 没有股票，且不是冷冻期
		 * 
		 */
		int dp[][] = new int[length][3];
		dp[0][0] = -prices[0];
		dp[0][1] = 0;
		dp[0][2] = 0;
		for (int i = 1; i < length; i++) {
			dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][2] - prices[i]);
			dp[i][1] = dp[i - 1][0] + prices[i];
			dp[i][2] = Math.max(dp[i - 1][2], dp[i - 1][1]);
		}
		return Math.max(dp[length - 1][2], Math.max(dp[length - 1][0], dp[length - 1][1]));
	}
}
