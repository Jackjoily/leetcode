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
		int max = 0;
		int min = prices[0];
		for (int i = 1; i < prices.length; i++) {
			if (min < prices[i]) {
				max = Math.max(max, prices[i] - min);
			} else {
				min = prices[i];
			}
		}
		return max;
	}
}
