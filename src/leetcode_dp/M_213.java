package leetcode_dp;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import edu.princeton.cs.algs4.In;

public class M_213 {
	public static void main(String[] args) {
		int a[] = { 1, 3, 1, 3, 100 };
		M_213 m = new M_213();
		System.out.println(m.rob(a));
	}

	public int rob(int[] nums) {
		int n = nums.length;
		if (n == 1)
			return nums[0];
		return Math.max(robRange(nums, 0, n - 2), robRange(nums, 1, n - 1));
	}

	int robRange(int[] nums, int start, int end) {
		int cur = 0, m = 0, n = 0;
		for (int i = start; i <= end; i++) {
			cur = Math.max(m, n + nums[i]);
			n = m;
			m = cur;
		}
		return cur;
	}
}
