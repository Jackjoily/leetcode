package leetcode_dp;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import edu.princeton.cs.algs4.In;

/**
 * 给两个整数数组 A 和 B ，返回两个数组中公共的、长度最长的子数组的长度。
 * 
 * @author jackjoily
 *
 */
public class M_718 {
	public static void main(String[] args) {
		int a[] = { 0, 1, 1,1,1 };
		int b[] = { 1, 0, 1,0 ,1};
		System.out.println(findLength(a, b));
	}

	/**
	 * * 返回两个数组中公共的、长度最长的子数组的长度
	 * 
	 * @param A
	 * @param B
	 * @return
	 */
	public static int findLength(int[] A, int[] B) {
		int m = A.length;
		int n = B.length;
		int max = 0;
		int dp[][] = new int[m][n];
		if (A[0] == B[0]) {
			dp[0][0] = 1;
			max = Math.max(max, 1);
		}
		for (int i = 1; i < m; i++) {
			if (A[i] == B[0]) {
				dp[i][0] = 1;
			}
			max = Math.max(max, dp[i][0]);
		}
		for (int j = 1; j < n; j++) {
			if (A[0] == B[j]) {
				dp[0][j] = 1;
			}
			max = Math.max(max, dp[0][j]);
		}
		for (int i = 1; i < m; i++) {
			for (int j = 1; j < n; j++) {
				if (A[i] == B[j]) {
					dp[i][j] = dp[i - 1][j - 1] + 1;
				}
				max = Math.max(dp[i][j], max);
			}
		}
		return max;
	}
}
