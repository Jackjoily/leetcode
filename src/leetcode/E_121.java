package leetcode;

import java.util.Arrays;
import java.util.HashMap;

import com.sun.org.apache.xerces.internal.util.SynchronizedSymbolTable;

/**
 * twosum
 * 
 * @author jackjoily
 *
 */
public class E_121 {
	public int maxProfit(int[] prices) {
		int n = prices.length;
		if (n == 1)
			return 0;
		int max = 0;
		int min = prices[0];
		for (int i = 1; i < n; i++) {
			if (prices[i] > min) {
				max = Math.max(max, prices[i] - min);
			} else if (prices[i] < min) {
				min = prices[i];
			}
		}
		return max;
	}
}
