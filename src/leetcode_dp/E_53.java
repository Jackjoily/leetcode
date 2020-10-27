package leetcode_dp;

/**
 * 给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 * 
 * @author jackjoily
 *
 */
public class E_53 {
	public static void main(String[] args) {
		int a[] = { -2, 1, -3, 4, -1, 2, 1, -5, 4 };
		int maxSubArray = maxSubArray(a);
		System.out.println(maxSubArray);
	}

	public static int maxSubArray(int[] nums) {
		if (nums.length == 0)
			return 0;
		int dp[] = new int[nums.length];
		dp[0] = nums[0];
		int max = nums[0];
		for (int i = 1; i < nums.length; i++) {
			if (dp[i] < 0)
				dp[i] = dp[i - 1];
			else
				dp[i] = dp[i - 1] + nums[i];
			max = Math.max(dp[i], max);
		}
		return max;
	}
}
