package leetcode_array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 
 * 给定一个包含 n + 1 个整数的数组 nums ，其数字都在 1 到 n 之间（包括 1 和 n），可知至少存在一个重复的整数。 假设 nums 只有
 * 一个重复的整数 ，找出 这个重复的数
 * 
 * @author jackjoily
 *
 */
public class M_287 {
	public int findDuplicate(int[] nums) {
		int m = nums.length;
		if (m == 2)
			return 1;
		Set<Integer> set = new HashSet<>();
		for (int i = 0; i < m; i++) {
			if (set.contains(nums[i])) {
				return nums[i];
			} else {
				set.add(nums[i]);
			}
		}
		return -1;
	}
}
