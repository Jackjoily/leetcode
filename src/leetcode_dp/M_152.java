package leetcode_dp;

import edu.princeton.cs.algs4.In;

/**
 * 给你一个整数数组 nums ， 请你找出数组中乘积最大的连续子数组 （该子数组中至少包含一个数字）， 并返回该子数组所对应的乘积。
 * 
 * @author jackjoily
 *
 */
public class M_152 {
	public static void main(String[] args) {
		M_152 m = new M_152();
		int a[] = { -3, 1, -3 };
		System.out.println(m.maxProduct(a));
	}

	/**
	 * 这里需要分成正负情况进行讨论，例如（-3，1，-3）这种情况 所以这里需要维护正负两个数组
	 * 
	 * @param nums
	 * @return
	 */
	public int maxProduct(int[] nums) {
		if (nums.length == 0)
			return 0;
		if (nums.length == 1)
			return nums[0];
		int max[] = new int[nums.length];
		int min[] = new int[nums.length];
		System.arraycopy(nums, 0, max, 0, nums.length);
		System.arraycopy(nums, 0, min, 0, nums.length);
		for (int i = 1; i < nums.length; i++) {
			max[i] = Math.max(max[i - 1] * nums[i], Math.max(nums[i], nums[i] * min[i - 1]));
			min[i] = Math.min(max[i - 1] * nums[i], Math.min(nums[i], nums[i] * min[i - 1]));
		}
		int max1 = max[0];
		for (int k = 1; k < max.length; k++) {
			max1 = Math.max(max[k], max1);
		}
		return max1;
	}
}
