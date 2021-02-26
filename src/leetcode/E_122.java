package leetcode;

import java.util.Arrays;
import java.util.HashMap;

import com.sun.org.apache.xerces.internal.util.SynchronizedSymbolTable;

/**
 * 买卖股票的最佳时机 II
 * 
 * @author jackjoily
 *
 */
public class E_122 {
	public static void main(String[] args) {
		int a[] = { 1,2,3,4,5};
		System.out.println(maxProfit(a));
	}

	public static int maxProfit(int[] prices) {
		int n = prices.length;
		if (n <= 1)
			return 0;
		int hold[] = new int[n];
		hold[0] = -prices[0];
		int sell[] = new int[n];
		sell[0] = 0;
		int max = 0;
		for (int i = 1; i < n; i++) {
			hold[i] = Math.max(hold[i - 1], sell[i - 1] - prices[i]);
			sell[i] = Math.max(sell[i - 1], hold[i - 1] + prices[i]);
			max = Math.max(hold[i], sell[i]);
		}
		return max;
	}
}
