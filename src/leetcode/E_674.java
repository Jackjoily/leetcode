package leetcode;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * twosum 你可以迭代或递归地反转链表。你能否用两种方法解决这道题？
 * 
 * @author jackjoily
 *
 */
public class E_674 {
	public static void main(String[] args) {
		int a[] = { 1, 3, 5, 4, 7 };
		System.out.println(findLengthOfLCIS(a));
	}

	public static int findLengthOfLCIS(int[] nums) {
		int n = nums.length;
		if (n <= 1)
			return n;
		int max = 1;
		int dp[] = new int[n];
		Arrays.fill(dp, 1);
		for (int i = 1; i < n; i++) {
			if (nums[i] > nums[i - 1]) {
				dp[i] += dp[i - 1];
				max = Math.max(max, dp[i]);
			}
		}
		return max;
	}
}
