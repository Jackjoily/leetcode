package leetcode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Queue;

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
		int sum = 0;
		Arrays.sort(nums);
		int max = 0;
		int len = nums.length;
		for (int i = 0; i < len; i++) {
			sum += nums[i];
			max = Math.max(max, nums[i]);
		}
		if (sum % 2 != 0)
			return false;
		int target = sum / 2;
		if (max > target)
			return false;
		boolean dp[][] = new boolean[len][target + 1];
		for (int i = 0; i < len; i++) {
			dp[i][0] = true;
		}
		dp[0][nums[0]] = true;
		for (int i = 1; i < len; i++) {
			for (int j = 1; j <= target; j++) {
				if (nums[i] <= j) {
					dp[i][j] = dp[i - 1][j] | dp[i - 1][j - nums[i]];
				} else {
					dp[i][j] = dp[i - 1][j];
				}
			}
		}
		for (int i = 1; i < nums.length; i++) {
			if (dp[i][target])
				return true;
		}
		return false;
	}
}
