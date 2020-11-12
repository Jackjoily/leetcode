package leetcode_day;

public class E_122II {
	public static void main(String[] args) {
		int a[] = { 7,1,5,3,6,4};
		System.out.println(maxProfit(a));
	}

	public static int maxProfit(int[] prices) {
		if (prices.length == 1)
			return 0;
		int i = 0;
		int total = 0;
		while (i < prices.length - 1) {
			while (i < prices.length - 1 && prices[i + 1] <= prices[i]) {
				i++;
			}
			int min = prices[i];
			while (i < prices.length - 1 && prices[i + 1] >= prices[i]) {
				i++;
			}
			int max = prices[i];
			total += max - min;
		}
		return total;
	}
}
