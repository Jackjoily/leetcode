package leetcode_day;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * 给定 n 个整数，找出平均数最大且长度为 k 的连续子数组，并输出该最大平均数
 *
 *
 */
public class E_643 {
	public static void main(String[] args) {
       int a[]= {0,1,1,3,3};
       System.out.println(findMaxAverage(a,4));
	}
	public static double findMaxAverage(int[] nums, int k) {
		int n = nums.length;
		int i = 0;
		int sum = 0;
		int max = 0;
		for (i = 0; i < k; i++) {
			sum += nums[i];
		}
		max = sum;
		for (i = 1; i + k -1<n; i++) {
			sum = sum - nums[i-1] + nums[i+k-1];
			max = Math.max(max, sum);
		}
		return (double)max/k;
	}
}
