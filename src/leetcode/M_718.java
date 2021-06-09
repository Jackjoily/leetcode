package leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

import leetcode_list.ListNode;

/**
 * 
 * @author jackjoily
 *
 */
public class M_718 {
	public static void main(String[] args) {
		int b[] = { 0,1,1,1,1};
		int a[] = {1,0,1,0,1 };
		System.out.println(findLength(b, a));
	}

	public static int findLength(int[] nums1, int[] nums2) {
		int m = nums1.length;
		int n = nums2.length;
		if (m * n == 0)
			return 0;
		int max = 0;
		int dp[][] = new int[m + 1][n + 1];
		for (int i = 0; i < m; i++) {
			if (nums1[i] == nums2[0]) {
				dp[i][0] = 1;
				max = 1;
			}
		}

		for (int i = 0; i < n; i++) {
			if (nums1[0] == nums2[i]) {
				dp[0][i] = 1;
				max = 1;
			}
		}
		for (int i = 1; i < m; i++) {
			for (int j = 1; j < n; j++) {
				if (nums1[i] == nums2[j]) {
					dp[i][j] = dp[i - 1][j - 1] + 1;
				}
				max = Math.max(max, dp[i][j]);
			}
		}
		return max;
	}
}
