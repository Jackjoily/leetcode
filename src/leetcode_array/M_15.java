package leetcode_array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 求三数之和
 * 
 * @author jackjoily
 *
 */
public class M_15 {
	public List<List<Integer>> threeSum(int[] nums) {
		List<List<Integer>> list = new ArrayList<>();
		if (nums.length == 0)
			return list;
		Arrays.sort(nums);
		for (int i = 0; i < nums.length; i++) {
			if (i > 0 & nums[i] == nums[i - 1])
				continue;
			int target = -nums[i];
			int j = i + 1;
			int k = nums.length - 1;
			while (j < k) {
				if (nums[j] + nums[k] == target) {
					List<Integer> list1 = new ArrayList<>();
					list1.add(nums[i]);
					list1.add(nums[j]);
					list1.add(nums[k]);
					j++;
					k--;
					while (j < nums.length && nums[j] == nums[j - 1])
						j++;
					while (k > j && nums[k - 1] == nums[k])
						k--;
				} else if (nums[j] + nums[k] > target) {
					k--;
				} else {
					j++;
				}
			}

		}
		return list;
	}
}
