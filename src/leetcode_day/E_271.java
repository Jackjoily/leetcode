package leetcode_day;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 给定一个整数数组，判断是否存在重复元素。 如果任意一值在数组中出现至少两次，函数返回 true 。 如果数组中每个元素都不相同，则返回 false 。
 *
 *
 *
 */
public class E_271 {
	public boolean containsDuplicate(int[] nums) {
		if (nums.length <= 1)
			return false;
		Set<Integer> set = new HashSet<>();
		for (int i = 0; i < nums.length; i++) {
			if (set.contains(nums[i]))
				return true;
			else
				set.add(nums[i]);
		}
		return false;
	}
}
