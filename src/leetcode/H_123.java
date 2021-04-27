package leetcode;

import java.util.Arrays;
import java.util.HashMap;

/**
 * twosum
 * 
 * @author jackjoily
 *
 */
public class H_123 {
	public static void main(String[] args) {
		int a[] = { 3,3,5,0,0,3,1,4};
		System.out.println(maxProfit(a));
	}

	public static int maxProfit(int[] prices) {
		int n = prices.length;
		if (n <= 1)
			return 0;
		int max = 0;
		int MIN_VALUE =  Integer.MIN_VALUE / 2;
		// 天数 是否持有 成交数量
		int dp[][][] = new int[n][2][3];
		dp[0][1][0] = -prices[0];
		dp[0][0][1] = dp[0][1][1] = MIN_VALUE;// 不可能
		dp[0][0][2] = dp[0][1][2] = MIN_VALUE;// 不可能
		for (int i = 1; i < n; i++) {
			dp[i][0][0] = 0;
			dp[i][0][1] = Math.max(dp[i - 1][0][1], dp[i - 1][1][0] + prices[i]);
			dp[i][0][2] = Math.max(dp[i - 1][0][2], dp[i - 1][1][1] + prices[i]);
			dp[i][1][0] = Math.max(dp[i - 1][1][0], dp[i - 1][0][0] - prices[i]);
			dp[i][1][1] = Math.max(dp[i - 1][0][1] - prices[i], dp[i - 1][1][1]);
			dp[i][1][2] = MIN_VALUE;
		}
		  return Math.max(0, Math.max(dp[prices.length - 1][0][1], dp[prices.length - 1][0][2]));
	}

}
