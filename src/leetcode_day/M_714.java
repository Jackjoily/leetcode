package leetcode_day;

import leetcode_list.ListNode;

public class M_714 {
	/**
	 * 给定一个整数数组 prices，其中第 i 个元素代表了第 i 天的股票价格 ；非负整数 fee 代表了交易股票的手续费用。
	 * 
	 * 你可以无限次地完成交易，但是你每笔交易都需要付手续费。如果你已经购买了一个股票，在卖出它之前你就不能再继续购买股票了。
	 * 
	 * 返回获得利润的最大值。
	 * 
	 * 注意：这里的一笔交易指买入持有并卖出股票的整个过程，每笔交易你只需要为支付一次手续费。
	 * 
	 * 
	 * 
	 */
	public static void main(String[] args) {
		int a[] = { 1, 3, 7, 5, 10, 3 };
		System.out.println(maxProfit1(a, 3));
	}

	/**
	 * 注意这一类型动态规划问题
	 * 
	 * @param prices
	 * @param fee
	 * @return
	 */
	public static int maxProfit(int[] prices, int fee) {
		int length = prices.length;
		if (length < 2)
			return 0;
		int dp[][] = new int[length][2];
		dp[0][0] = 0;
		dp[0][1] = -prices[0];
		for (int i = 1; i < length; i++) {
			dp[i][0] = Math.max(dp[i - 1][0], (dp[i - 1][1] - fee + prices[i]));
			dp[i][1] = Math.max(dp[i - 1][1], (dp[i - 1][0] - prices[i]));
		}
		return dp[length - 1][0];
	}

	public static int maxProfit1(int[] prices, int fee) {
		int length = prices.length;
		if (length < 2)
			return 0;
		int dp[] = new int[2];
		dp[0] = 0;
		dp[1] = -prices[0];
		for (int i = 1; i < length; i++) {
			dp[0] = Math.max(dp[0], (dp[1] - fee + prices[i]));
			dp[1] = Math.max(dp[1], (dp[0] - prices[i]));
		}
		return dp[0];
	}
}
