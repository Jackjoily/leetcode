package leetcode_dp;

import java.util.LinkedList;
import java.util.List;

public class M_494 {
	public static void main(String[] args) {
		int a[] = new int[] { 1, 1, 1, 1, 1 };
		f(a, 0, 0, 2);
	}

	public int findTargetSumWays(int[] nums, int S) {
		int[][] dp = new int[nums.length][2001];
		dp[0][nums[0] + 1000] = 1;
		// 首位都是0的情况所以这里要考虑两种情况
		dp[0][-nums[0] + 1000] = 1;
		for (int i = 1; i < nums.length; i++) {
			for (int sum = -1000; sum <= 1000; sum++) {
				if (dp[i - 1][sum + 1000] > 0) {
					dp[i][sum + nums[i] + 1000] += dp[i - 1][sum + 1000];
					dp[i][sum - nums[i] + 1000] += dp[i - 1][sum + 1000];
				}
			}
		}
		return S > 1000 ? 0 : dp[nums.length - 1][S + 1000];
	}

	public static void f(int[] nums, int i, int sum, int val) {
		if (i == nums.length && sum == val) {
			System.out.println(sum);
			return;
		}
		if (i >= nums.length)
			return;
		f(nums, i + 1, sum + nums[i], val);
		f(nums, i + 1, sum - nums[i], val);
	}
}