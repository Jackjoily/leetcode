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
		int a[] = { 0, 0, 0 };
		System.out.println(threeSum(a));
	}

	public static List<List<Integer>> threeSum(int[] nums) {
		List<List<Integer>> list = new ArrayList<>();
		int n = nums.length;
		if (n <= 2)
			return list;
		Arrays.sort(nums);
		int a = 0, b = a + 1, c = n - 1;
		while (a < c) {
			b = a + 1;
			c = n - 1;
			while (b < c) {
				int i = nums[a] + nums[b] + nums[c];
				if (i == 0) {
					List<Integer> list1 = new ArrayList<>();
					list1.add(nums[a]);
					list1.add(nums[b]);
					list1.add(nums[c]);
					list.add(list1);
					c--;
					while (b < c && nums[c] == nums[c + 1]) {
						c--;
					}
				} else if (i < 0) {
					b++;
					while (b < c && nums[b] == nums[b - 1]) {
						b++;
					}
				} else if (i > 0) {
					c--;
					while (b < c && nums[c] == nums[c + 1]) {
						c--;
					}
				}
			}
			a++;
			while (a<c&&a > 0 && nums[a] == nums[a - 1]) {
				a++;
			}
		}
		return list;
	}
}
