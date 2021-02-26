package leetcode_array;

import java.util.HashMap;
import java.util.Map;

/**
 * 给定一个大小为 n 的数组，找到其中的多数元素。多数元素是指在数组中出现次数 大于 ⌊ n/2 ⌋ 的元素。
 * 
 * 你可以假设数组是非空的，并且给定的数组总是存在多数元素。
 * 
 * @author jackjoily
 *
 */
public class E_169 {
	public static void main(String[] args) {
		int a[] = { 11, 112, 123123, 11, 11, 11, 11, 11, 11, 12, 43, 34, 554, 8 };
		System.out.println(majorityElement(a));
	}

	/**
	 * 使用摩尔投票法
	 * 
	 * @param nums
	 * @return
	 */
	public static int majorityElement(int[] nums) {
		int val = nums[0], count = 1;
		for (int i = 1; i < nums.length; i++) {
			if (val == nums[0]) {
				count++;
			} else if (--count == 0) {
				val = nums[i];
				count = 1;
			}
		}
		return val;
	}
}
