package leetcode_day;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * 给定一个整型数组，在数组中找出由三个数组成的最大乘积， 并输出这个乘积。
 *
 *
 */
public class E_628 {
	public static void main(String[] args) {
		int a[] = { -10,-1, -3 ,-4};
		System.out.println(maximumProduct(a));
	}

	public static int maximumProduct(int[] nums) {
		if (nums.length < 3)
			return 0;
		if (nums.length == 3)
			return nums[0] * nums[1] * nums[2];
		Arrays.sort(nums);
		int n = nums.length - 1;
		if (nums[0] >= 0) {
			return nums[n] * nums[n - 1] * nums[n - 2];
		} else if (nums[n] <= 0) {
			return nums[n] * nums[n - 1] * nums[n - 2];
		} else if (nums[0] < 0 && nums[n] > 0) {
			int max = nums[0] * nums[1] * nums[n];
			int max1 = nums[n] * nums[n - 1] * nums[n - 2];
			return max > max1 ? max : max1;
		}
		return 0;
	}
}
