package leetcode_dp;

public class E_122 {

	public int maxProfit(int[] prices) {
		int i = 0;
		int valley = prices[0];
		int peak = prices[0];
		int maxprofit = 0;
		while (i < prices.length - 1) {
			//先找出山谷
			while (i < prices.length - 1 && prices[i] >= prices[i + 1])
				i++;
			valley = prices[i];
			//再找出山顶
			while (i < prices.length - 1 && prices[i] <= prices[i + 1])
				i++;
			peak = prices[i];
			maxprofit += peak - valley;
		}
		return maxprofit;
	}
}
