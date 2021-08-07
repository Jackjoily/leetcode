package leetcode;

import java.util.Arrays;
import java.util.HashMap;

import sun.java2d.pipe.SpanClipRenderer;

/**
 * twosum
 * 
 * @author jackjoily
 *
 */
public class H_410 {
	public static void main(String[] args) {
		H_410 h = new H_410();
		int a[] = { 7, 2, 5, 10, 8 };
		System.out.println(h.splitArray1(a, 2));
	}

	public int splitArray(int[] nums, int m) {
		int n = nums.length;
		int dp[][] = new int[n + 1][m + 1];
		int sum[] = new int[n + 1];
		for (int i = 0; i < n; i++) {
			sum[i + 1] = sum[i] + nums[i];
		}
		for (int i = 0; i < n + 1; i++) {
			Arrays.fill(dp[i], Integer.MAX_VALUE);
		}
		dp[0][0] = 0;
		for (int i = 1; i < n + 1; i++) {
			for (int j = 1; j <= Math.min(i, m); j++) {
				for (int k = 0; k < i; k++) {
					dp[i][j] = Math.min(dp[i][j], Math.max(dp[k][j - 1], sum[i] - sum[k]));
				}
			}
		}
		return dp[n][m];
	}

	public int splitArray1(int[] nums, int m) {
		int n = nums.length;
		int left = 0, right = 0;
		for (int num : nums) {
			left = Math.max(num, left);
			right += num;
		}
		while (left < right) {
			int mid = (right - left) / 2 + left;
			int s = spilts(nums, mid);
			if (s == m) {
				right = mid;
			} else if (s > m) {
				left = mid + 1;
			} else {
				right = mid;
			}
		}
		return left;
	}

	public int spilts(int nums[], int max) {
		int spilt = 1;
		int val = 0;
		for (int num : nums) {
			if (val + num > max) {
				spilt++;
				val = 0;
			}
			val += num;
		}
		return spilt;
	}

}
