package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import javax.swing.plaf.basic.BasicBorders.MarginBorder;

import com.sun.org.apache.xerces.internal.util.SynchronizedSymbolTable;

/**
 * twosum
 * 
 * @author jackjoily
 *
 */
public class JianZhiOffer63 {
	public int maxProfit(int[] prices) {
		int n = prices.length;
		if (n <= 1)
			return 0;
		int min = prices[0];
		int max = 0;
		for (int i = 1; i < n; i++) {
			if (prices[i] > min) {
				max = Math.max(max, prices[i] - min);
			} else {
				min = prices[i];
			}
		}
		return max;
	}
}
