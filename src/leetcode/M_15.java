package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

import leetcode_list.ListNode;

/**
 * 
 * @author jackjoily
 *
 */
public class M_15 {
	public static void main(String[] args) {
		int a[] = { -1, -1, -1, 0, 1, 1, 1 };
		System.out.println(threeSum(a));
	}

	public static List<List<Integer>> threeSum(int[] nums) {
		List<List<Integer>> list = new ArrayList<>();
		if (nums.length < 3) {
			return list;
		}
		int n = nums.length - 1;
		Arrays.sort(nums);
		int a = 0;
		while (a < n) {
			if (a > 0 && nums[a] == nums[a - 1]) {
				a++;
				continue;
			}
			int b = a + 1;
			int c = n;
			while (b < c) {
				int sum = nums[a] + nums[b] + nums[c];
				if (sum == 0) {
					List<Integer> list1 = new ArrayList<>();
					list1.add(nums[a]);
					list1.add(nums[b]);
					list1.add(nums[c]);
					list.add(list1);
					c--;
					while (c > b && nums[c] == nums[c + 1])
						c--;
				} else if (sum > 0) {
					c--;
					while (c > b && nums[c] == nums[c + 1])
						c--;

				} else {
					b++;
					while (c > b && nums[b] == nums[b - 1])
						b++;
				}
			}
			a++;
		}
		return list;
	}
}
