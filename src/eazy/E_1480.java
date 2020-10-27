package eazy;

/**
 * @ClassName E_1480
 * @Description
 * 给你一个数组 nums 。数组「动态和」的计算公式为：runningSum[i] = sum(nums[0]…nums[i])
 * 请返回 nums 的动态和。
 * @Author Jackjoily
 * @Date 2020年6月26日 下午4:36:22
 */
public class E_1480 {
	public int[] runningSum(int[] nums) {
		int result[] = new int[nums.length];
		result[0] = nums[0];
		for (int i = 1; i < nums.length; i++) {
			result[i]=result[i-1]+nums[i];
		}
		return result;
	}
}
