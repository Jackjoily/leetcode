package leetcode_array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 
 * 给定一个未经排序的整数数组，找到最长且 连续递增的子序列，并返回该序列的长度。 连续递增的子序列 可以由两个下标 l 和 r（l <
 * r）确定，如果对于每个 l <= i < r，都有 nums[i] < nums[i + 1] ，那么子序列 [nums[l], nums[l + 1],
 * ..., nums[r - 1], nums[r]] 就是连续递增子序列。
 * 
 * @author jackjoily
 *
 */
public class E_674 {
	public static void main(String[] args) {
		int a[] = { 2,3,1,4,5,6,7,8 };
		System.out.println(findLengthOfLCIS(a));
	}

	public static int findLengthOfLCIS(int[] nums) {
		int n = nums.length;
		if (n == 0)
			return 0;
		int dp[] = new int[n];
		Arrays.fill(dp, 1);
		int max = 1;
		for (int i = 1; i < nums.length; i++) {
			if (nums[i] > nums[i - 1]) {
				dp[i] = dp[i - 1] + 1;
				max = Math.max(max, dp[i]);
			}
		}
		return max;
	}
}
