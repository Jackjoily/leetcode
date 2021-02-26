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
public class E_53 {
	public static void main(String[] args) {
	}

	public static int maxSubArray(int[] nums) {
		int dp[] = new int[nums.length];
		dp[0] = nums[0];
		int max = dp[0];
		for (int i = 1; i < nums.length; i++) {
			if (dp[i - 1] < 0)
				dp[i] = nums[i];
			else {
				dp[i] = nums[i] + dp[i - 1];
			}
			max = Math.max(max, dp[i]);
		}
		return max;
	}
}
