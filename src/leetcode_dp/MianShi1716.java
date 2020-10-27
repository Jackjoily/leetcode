package leetcode_dp;

/**
 * 一个有名的按摩师会收到源源不断的预约请求， 每个预约都可以选择接或不接。在每次预约服务之间要有休息时间，
 * 因此她不能接受相邻的预约。给定一个预约请求序列，替按摩师找到最优的预约集合（总预约时间最长），返回总的分钟数。
 * 
 * @author jackjoily
 *
 */
public class MianShi1716 {
	public static void main(String[] args) {
		int a[]= {1,3,1};
		MianShi1716 m=new MianShi1716();
		System.out.println(m.massage(a));
	}
	
	public int massage(int[] nums) {
		if (nums.length == 0)
			return 0;
		if (nums.length == 1)
			return nums[0];
		if (nums.length == 2)
			return nums[0] > nums[1] ? nums[0] : nums[1];
		int dp[] = new int[nums.length];
		dp[0] = nums[0];
		dp[1] = nums[1];
		int max1 = nums[0] > nums[1] ? nums[0] : nums[1];
		for (int i = 2; i < nums.length; i++) {
			dp[i]=nums[i];
			int max = Integer.MIN_VALUE;
			for (int j = i - 2; j >= 0; j--) {
				max = Math.max(max, dp[j]);
			}
			dp[i] += max ;
			max1 = Math.max(dp[i], max1);
		}
		return max1;
	}
}
