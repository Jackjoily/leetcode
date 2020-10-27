package JianZhiOffer;

/**
 * 假设把某股票的价格按照时间先后顺序存储在数组中，请问买卖该股票一次可能获得的最大利润是多少？
 * 
 * @author jackjoily
 *
 */
public class JianZhiOffer63 {
	public static void main(String[] args) {
		int nums[] = { 7,1,5,3,6,4 };
		System.out.println(JianZhiOffer63.maxProfit(nums));
	}

	/**
	 * 使用动态规划的方法
	 * 
	 * @param prices
	 * @return
	 */
	public static int maxProfit(int[] prices) {
		int res = 0;
		if (prices.length == 0 || prices.length == 1)
			return res;
		int a[] = new int[prices.length];
		int min = prices[0];
		for (int i = 1; i < prices.length; i++) {
			if (min > prices[i-1])
				min = prices[i-1];
			a[i] = Math.max(a[i - 1], prices[i] - min);
			res = Math.max(a[i], res);
		}
		return res;
	}

	/**
	 * 暴力搜索的方法
	 * 
	 * @param prices
	 * @return
	 */
	public static int maxProfit1(int[] prices) {
		if (prices.length == 0 || prices.length == 1)
			return 0;
		int max = 0;
		for (int i = 0; i < prices.length - 1; i++) {
			for (int j = i + 1; j < prices.length; j++) {
				if (prices[j] - prices[i] > max)
					max = prices[j] - prices[i];
			}
		}
		return max;
	}
}
