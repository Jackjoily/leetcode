package JianZhiOffer;

import java.util.HashMap;
import java.util.Map;

/**
 * 数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。 你可以假设数组是非空的，并且给定的数组总是存在多数元素。
 * 
 * @author jackjoily
 *
 */
public class JianZhiOffer39 {
	public static void main(String[] args) {

	}

	public int majorityElement(int[] nums) {
		if (nums.length == 1)
			return nums[0];
		Map<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < nums.length; i++) {
			if (!map.containsKey(nums[i])) {
				map.put(nums[i], 1);
			} else {
				int k = map.get(nums[i]);
				if ((k + 1) > nums.length / 2 + 1) {
					return nums[i];
				}
				map.put(nums[i], k + 1);
			}
		}
		return 0;
	}

	/**
	 * 使用投票法
	 * 
	 * @param nums
	 * @return
	 */
	public int majorityElement1(int[] nums) {
		int x = 0, votes = 0;
		for (int num : nums) {
			if (votes == 0)
				x = num;
			votes += num == x ? 1 : -1;
		}
		return x;
	}

}
