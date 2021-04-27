package leetcode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Queue;

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
		int a[] = {1,5,2,4};
		System.out.println(canPartition(a));
	}

	public static boolean canPartition(int[] nums) {
		int n = nums.length;
		int sum = 0;
		if (n < 2)
			return false;
		for (int i = 0; i < n; i++) {
			sum += nums[i];
		}
		if (sum % 2 != 0)
			return false;
		Arrays.sort(nums);
		int target = sum / 2;
		boolean dp[][] = new boolean[n][target + 1];
		for (int i = 0; i < n; i++) {
			dp[i][0] = true;
		}
		dp[0][nums[0]] = true;
		for (int i = 1; i < n; i++) {
			for (int j = 1; j <= target; j++) {
				if (j >= nums[i]) {
					dp[i][j] = dp[i - 1][j] | dp[i - 1][j - nums[i]];
				} else {
					dp[i][j] = dp[i - 1][j];
				}
			}
		}
		return dp[n-1][target];
	}
}
