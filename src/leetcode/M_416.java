package leetcode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.concurrent.Callable;

import javafx.scene.control.Tab;
import javafx.scene.shape.Line;
import leetcode_list.ListNode;
import leetcode_tree.TreeNode;

/**
 * 
 * @author jackjoily
 *
 */
public class M_416 {
	public static void main(String[] args) {
		int a[] = { 1, 5, 11, 5 };
		System.out.println(canPartition(a));

	}

	public static boolean canPartition(int[] nums) {
		int n = nums.length;
		if (n <= 1)
			return false;
		int sum = 0;
		for (int num : nums) {
			sum += num;
		}
		if (sum % 2 != 0)
			return false;
		int target = sum / 2;
		// 前i个数的和能否为j
		boolean dp[][] = new boolean[n][target + 1];
		Arrays.sort(nums);
		int max = 0;
		for (int i = 0; i < n; i++) {
			max = Math.max(max, nums[i]);
			dp[i][0] = true;
		}
		if (max > target)
			return false;
		if (max == target)
			return true;
		for (int i = 1; i < n; i++) {
			for (int j = 1; j <= target; j++) {
				if (j >= nums[i]) {
					dp[i][j] = dp[i - 1][j - nums[i]] || dp[i - 1][j];
				} else {
					dp[i][j] = dp[i - 1][j];
				}

			}
		}
		return dp[n - 1][target];
	}
}
