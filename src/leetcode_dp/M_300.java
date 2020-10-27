package leetcode_dp;

import java.util.Arrays;

/**
 * 给定一个无序的整数数组，找到其中最长上升子序列的长度。
 * 
 * @author jackjoily
 *
 */
public class M_300 {
	public static void main(String[] args) {
		int a[] = { 1, 3, 6, 7, 9, 4, 10, 5, 6 };
		System.out.println(lengthOfLIS(a));
	}

	public static int lengthOfLIS(int[] nums) {
		if (nums.length == 0 || nums == null) {
			return 0;
		}
		if (nums.length == 1) {
			return 1;
		}
		int dp[] = new int[nums.length];
		Arrays.fill(dp, 1);
		int max = 1;
		for (int i = 1; i < nums.length; i++) {
			int max1 = 1;
			boolean flag = false;
			for (int k = i - 1; k >= 0; k--) {
				// 找到比nums[i]小，且dp[k]最大
				if (nums[k] < nums[i]) {
					if (max1 < dp[k])
						max1 = dp[k];
					flag = true;
				}
			}
			if (flag) {
				dp[i] += max1;
			}
			max = Math.max(max, dp[i]);
		}

		return max;
	}
}
