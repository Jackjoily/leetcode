package JianZhiOffer;

import java.util.HashMap;
import java.util.Map;

/**
 * 找出数组中重复的数字。
 * 
 * 
 * 在一个长度为 n 的数组 nums 里的所有数字都在 0～n-1 的范围内。数组中某些数字是重复的，但不知道有几个数字重复了
 * ，也不知道每个数字重复了几次。请找出数组中任意一个重复的数字。
 * 
 * 
 * @author jackjoily
 *
 */
public class JianZhiOffer03 {
	public int findRepeatNumber(int[] nums) {
		Map<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < nums.length; i++) {
			if (map.containsKey(nums[i])) {
				return nums[i];
			}
			map.put(nums[i], 1);
		}
		return 0;
	}
}
