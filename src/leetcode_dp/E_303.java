package leetcode_dp;

/**
 * 
 * 给定一个整数数组  nums，求出数组从索引 i 到 j（i ≤ j）范围内元素的总和，包含 i、j 两点。
 * 
 * 实现 NumArray 类：
 * 
 * NumArray(int[] nums) 使用数组 nums 初始化对象 int sumRange(int i, int j) 返回数组 nums
 * 从索引 i 到 j（i ≤ j）范围内元素的总和，包含 i、j 两点（也就是 sum(nums[i], nums[i + 1], ... ,
 * nums[j])）
 *
 * 
 */
public class E_303 {

}

class NumArray {
	private int[] sum;

	public NumArray(int[] nums) {
		// 记录0~k的和
		sum = new int[nums.length + 1];
		for (int i = 0; i < nums.length; i++) {
			sum[i + 1] = sum[i] + nums[i];
		}
	}

	public int sumRange(int i, int j) {
		return sum[j + 1] - sum[i];
	}
}
