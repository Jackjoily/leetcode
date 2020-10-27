package JianZhiOffer;


/**
 * 输入一个整型数组，数组中的一个或连续多个整数组成一个子数组。
 *  求所有子数组的和的最大值。 要求时间复杂度为O(n)。
 * 
 * @author jackjoily
 *
 */
public class JianZhiOffer42 {
	public static void main(String[] args) {
		int nums[] = { 1 };
		
		System.out.println(maxSubArray(nums));
	}

	public static int maxSubArray(int[] nums) {
		if (nums.length == 0)
			return 0;
		int a[] = new int[nums.length];
		int res = Integer.MIN_VALUE;
		a[0] = nums[0];
		for (int i = 1; i < nums.length; i++) {
			if (a[i - 1] < 0) {
				a[i] = nums[i];
			} else {
				a[i] = nums[i] + a[i - 1];
			}
			res = Math.max(a[i], res);
		}
		return res;
	}
}
