package leetcode;

import java.net.Inet4Address;
import java.util.Arrays;
import java.util.HashMap;

/**
 * twosum
 * 
 * @author jackjoily
 *
 */
public class H_188 {
	public static void main(String[] args) {
		int a[]= {7,6,4,3,1};
		System.out.println(maxProfit(2, a));
	}
	public static int maxProfit(int k, int[] prices) {
		int length = prices.length;
		if (k == 0)
			return 0;
		if(length==0)return 0;
		// 天数 是否持有 完成k笔交易
		int minValue = Integer.MIN_VALUE / 2;
	
		int max=0;
		int dp[][][] = new int[length][2][k + 1];
		for(int i=1;i<=k;i++) {
			dp[0][0][i]=minValue;
			dp[0][1][i]=minValue;
		}
		dp[0][1][0] = -prices[0];
		dp[0][0][0] = 0;
		for (int i = 1; i < length; i++) {
			dp[i][0][0] = 0;
			dp[i][1][0]=Math.max(dp[i-1][1][0], dp[i-1][0][0]-prices[i]);
			for (int j = 1; j <= k; j++) {
				dp[i][0][j] = Math.max(dp[i - 1][0][j], dp[i - 1][1][j - 1] + prices[i]);
				dp[i][1][j] = Math.max(dp[i - 1][1][j], dp[i - 1][0][j] - prices[i]);
				max=Math.max(dp[i][0][j], max);
				max=Math.max(	dp[i][1][j], max);
			}
		}
		return max;
	}
}
