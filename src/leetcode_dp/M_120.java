package leetcode_dp;

import java.util.LinkedList;
import java.util.List;

import edu.princeton.cs.algs4.In;

public class M_120 {
	public static void main(String[] args) {
		List<List<Integer>> triangle = new LinkedList<List<Integer>>();
		List<Integer> list = new LinkedList<>();
		list.add(2);
		List<Integer> list1 = new LinkedList<>();
		list1.add(3);
		list1.add(4);
		List<Integer> list2 = new LinkedList<>();
		list2.add(6);
		list2.add(5);
		list2.add(7);
		List<Integer> list3 = new LinkedList<>();
		list3.add(4);
		list3.add(1);
		list3.add(8);
		list3.add(3);
		triangle.add(list);
		triangle.add(list1);
		triangle.add(list2);
		triangle.add(list3);
		System.out.println(minimumTotal(triangle));
	}

	public static int minimumTotal(List<List<Integer>> triangle) {
		int min = Integer.MAX_VALUE;
		int n = triangle.size();

		if (triangle == null || n == 0) {
			return 0;
		}
		if (n == 1) {
			return triangle.get(0).get(0);
		}
		int dp[][] = new int[n][n];
		for (int m = 0; m < n; m++) {
			for (int l = 0; l < n; l++) {
				dp[m][l] = Integer.MAX_VALUE;
			}
		}
		for (int k = 0; k < n; k++) {
			if (k == 0) {
				dp[k][0] = triangle.get(k).get(0);
			} else {
				dp[k][0] = dp[k - 1][0] + triangle.get(k).get(0);
			}
		}
		for (int i = 1; i < n; i++) {
			List<Integer> list = triangle.get(i);
			for (int j = 1; j < list.size(); j++) {
				dp[i][j] = Math.min(dp[i - 1][j - 1], dp[i - 1][j]) + list.get(j);
			}
		}
		for (int p = 0; p < n; p++) {
              min=Math.min(dp[n-1][p],min);
		}
		return min;
	}
}
