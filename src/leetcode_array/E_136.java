package leetcode_array;

import java.util.HashMap;
import java.util.Map;

/**
 * 给定一个非空整数数组，除了某个元素只出现一次以外， 其余每个元素均出现两次。找出那个只出现了一次的元素
 * 
 * @author jackjoily
 *
 */
public class E_136 {
	public int singleNumber(int[] nums) {
		int a = 0;
		for (int i = 0; i < nums.length; i++) {
			a ^= nums[i];
		}
		return a;
	}
}
