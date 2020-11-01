package JianZhiOffer;

import java.util.HashMap;
import java.util.Map;

/**
 * 
 * 
 * 一个长度为n-1的递增排序数组中的所有数字都是唯一的， 并且每个数字都在范围0～n-1之内。在范围0～n-1内的n个数字中有且只有一个数字不在该数组中，
 * 请找出这个数字。
 * 
 * @author jackjoily
 *
 */
public class JianZhiOffer53II {
	public int missingNumber(int[] nums) {
		if (nums.length == 1) {
			if (nums[0] == 1)
				return 0;
			else
				return 1;
		}
		int i = 0;
		for (i = 0; i < nums.length - 1; i++) {
			if ((nums[i + 1] - nums[i]) == 2)
				return nums[i] + 1;
		}
		if (nums[0] == 1) {
			return 0;
		}
		return nums[i] + 1;
	}
}
