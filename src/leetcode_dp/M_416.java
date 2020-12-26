package leetcode_dp;

import java.util.LinkedList;
import java.util.List;

import edu.princeton.cs.algs4.In;

public class M_416 {
	public boolean canPartition(int[] nums) {
		int length = nums.length;
		if (length <= 1)
			return false;
		int val = 0;
		int max = 0;
		for (int x : nums) {
			max = Math.max(x, max);
			val += x;
		}
		if (val % 2 != 0)
			return false;
		int target = val / 2;
		if (max > target)
			return false;
		boolean dp[][] = new boolean[length][target + 1];
		for (int i = 0; i < length; i++) {
			dp[i][0] = true;
		}
		dp[0][nums[0]] = true;
		for (int i = 1; i < length; i++) {
			int num = nums[i];
			for (int j = 1; j <= target; j++) {
				if (j >= num) {
					dp[i][j] = dp[i - 1][j] | dp[i - 1][j - num];
				} else {
					dp[i][j] = dp[i - 1][j];
				}
			}
		}
		return dp[length - 1][target];
	}
}
