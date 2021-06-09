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
public class M_300 {
	public static void main(String[] args) {
		int a[] = { 10, 9, 2, 5, 3, 7, 101, 18 };
		System.out.println(lengthOfLIS(a));
	}

	public static int lengthOfLIS(int[] nums) {
		int n = nums.length;
		if (n == 1)
			return 1;
		int dp[] = new int[n];
		Arrays.fill(dp, 1);
		int max = 1;
		for (int i = 1; i < n; i++) {
			int max1 = 0;
			for (int j = i - 1; j >= 0; j--) {
				if (nums[i] > nums[j]) {
					max1 = Math.max(max1, dp[j]);
				}
			}
			dp[i] += max1;
			max = Math.max(max, dp[i]);
		}
		
		return max;
	}
}
