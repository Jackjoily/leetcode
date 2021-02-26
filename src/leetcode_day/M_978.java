package leetcode_day;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import leetcode_list.ListNode;
import leetcode_tree.TreeNode;
import leetcode_tree.TreeUtils;

public class M_978 {
	public static void main(String[] args) {
		int a[] = {4,8,12,16};
		System.out.println(maxTurbulenceSize(a));
	}

	public static int maxTurbulenceSize(int[] arr) {
		int n = arr.length;
		if (n == 1)
			return 1;
		int dp[] = new int[n];
		Arrays.fill(dp, 1);
		int dp1[] = new int[n];
		Arrays.fill(dp1, 1);
		int max = 1;
		for (int i = 1; i < n; i++) {
			if (i % 2 == 0) {
				if (arr[i] > arr[i - 1]) {
					dp1[i] += dp1[i - 1];
				}
				if (arr[i] < arr[i - 1]) {
					dp[i] += dp[i - 1];
				}
			} else {
				if (arr[i] > arr[i - 1]) {
					dp[i] += dp[i - 1];
				}
				if (arr[i] < arr[i - 1]) {
					dp1[i] += dp1[i - 1];
				}
			}
			max = Math.max(Math.max(dp[i], dp1[i]), max);
		}
		return max;
	}
}
