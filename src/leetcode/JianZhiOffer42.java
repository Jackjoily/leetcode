package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import com.sun.org.apache.xerces.internal.util.SynchronizedSymbolTable;

/**
 * twosum
 * 
 * @author jackjoily
 *
 */
public class JianZhiOffer42 {
	public static void main(String[] args) {

		int a[] = { -1, -2 };
		System.out.println(maxSubArray(a));
	}

	public static int maxSubArray(int[] nums) {
		int len = nums.length;
		if (len == 1)
			return nums[0];
		int dp[] = new int[len];
		dp[0] = nums[0];
		int max = dp[0];
		for (int i = 1; i < nums.length; i++) {
			if (dp[i - 1] <= 0)
				dp[i] = nums[i];
			else {
				dp[i] = nums[i] + dp[i - 1];
			}
			max = Math.max(max, dp[i]);
		}
		return max;
	}
}
