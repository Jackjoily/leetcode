package leetcode_array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class M_18 {
	public static void main(String[] args) {
		M_18 m1 = new M_18();
		int a[] = { 1, 0, -1, 0, -2, 2 };
		m1.fourSum1(a, 0);
	}

	List<List<Integer>> list = new ArrayList<>();

	public List<List<Integer>> fourSum(int[] nums, int target) {
		if (nums.length == 0)
			return list;
		Arrays.sort(nums);
		int a, b, c, d;
		for (int i = 0; i <= nums.length - 4; i++) {
			a = i;
			if (a > 0 && nums[a] == nums[a - 1])
				continue;
			for (b = a + 1; b <= nums.length - 3; b++) {
				if (b > a + 1 && nums[b] == nums[b - 1])
					continue;
				c = b + 1;
				d = nums.length - 1;
				while (c < d) {
					if (nums[a] + nums[b] + nums[c] + nums[d] == target) {
						List<Integer> list1 = new ArrayList<>();
						list1.add(nums[a]);
						list1.add(nums[b]);
						list1.add(nums[c]);
						list1.add(nums[d]);
						list.add(list1);
						c++;
						d--;
						while (c < d && nums[c - 1] == nums[c]) // 确保nums[c] 改变了
							c++;
						while (c < d && nums[d + 1] == nums[d]) // 确保nums[d] 改变了
							d--;
					} else if (nums[a] + nums[b] + nums[c] + nums[d] < target) {
						c++;
					} else {
						d--;
					}
				}
			}
		}
		return list;
	}

	public List<List<Integer>> fourSum1(int[] nums, int target) {
		if (nums.length == 0)
			return list;
		Arrays.sort(nums);
		int i = 0, a = 0, b = 0, c = 0, d = 0;
		for (; i <= nums.length - 4; i++) {
			a=i;
			if (i > 0) {
				if (nums[i - 1] == nums[i]) {
					continue;
				}
			}
			for (b = a + 1; b <= nums.length - 3; b++) {
				if (b > a + 1 && nums[b] == nums[b - 1])
					continue;
				c = b + 1;
				d = nums.length - 1;
				while (c < d) {
					if (nums[a] + nums[b] + nums[c] + nums[d] == target) {
						List<Integer> list1 = new ArrayList<>();
						list1.add(nums[a]);
						list1.add(nums[b]);
						list1.add(nums[c]);
						list1.add(nums[d]);
						list.add(list1);
						c++;
						d--;
						while (c < d && nums[c - 1] == nums[c]) // 确保nums[c] 改变了
							c++;
						while (c < d && nums[d + 1] == nums[d]) // 确保nums[d] 改变了
							d--;
					} else if (nums[a] + nums[b] + nums[c] + nums[d] < target) {
						c++;
					} else {
						d--;
					}
				}
			}
		}
		return list;
	}

}
