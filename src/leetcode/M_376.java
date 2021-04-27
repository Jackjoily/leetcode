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
public class M_376 {
	public static void main(String[] args) {
		int a[] = { 1,1, 1, 1, 1,1 };
		System.out.println(		wiggleMaxLength(a));
	}

	public static int wiggleMaxLength(int[] nums) {
		int n = nums.length;
		int max2 = 1;
		if (n <= 1) {
			return n;
		}
		if (n == 2)
			return nums[0] == nums[1] ? 1 : 2;
		int dp[] = new int[n];
		dp[0] = 1;
		int dp1[] = new int[n];
		dp1[0] = 1;
		for (int i = 1; i < n; i++) {
			int max = 0, max1 = 0;
			for (int j = i - 1; j >= 0; j--) {
				if (nums[i] > nums[j]) {
					max = Math.max(max, dp1[j]);
				}
			}
			for (int j = i - 1; j >= 0; j--) {
				if (nums[i] < nums[j]) {
					max1 = Math.max(max1, dp[j]);
				}
			}
			dp[i] = max + 1;
			dp1[i] = max1 + 1;
			max2 = Math.max(dp1[i], Math.max(max2, dp[i]));
		}
		return max2;
	}
}
