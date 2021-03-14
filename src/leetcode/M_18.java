package leetcode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Queue;

import javafx.scene.shape.Line;
import leetcode_list.ListNode;
import leetcode_tree.TreeNode;

/**
 * 
 * @author jackjoily
 *
 */
public class M_18 {
	public static void main(String[] args) {
		int a[] = { -2,-1,-1,1,1,2,2,0 };
		fourSum(a, 0);
	}

	public static List<List<Integer>> fourSum(int[] nums, int target) {
		List<List<Integer>> list = new ArrayList<>();
		int n = nums.length;
		if (n == 0)
			return list;
		Arrays.sort(nums);
		int a = 0, b = 0, c = 0, d = 0;
		for (int i = 0; i < n - 3;i++) {
			if (i > 0 && nums[i] == nums[i - 1]) {
				continue;
			}
			a = i;
			for (b = a + 1; b < n - 2; b++) {
				if (a + 1 < b && nums[b] == nums[b - 1]) {
					continue;
				}
				c = b + 1;
				d = n - 1;
				while (c < d) {
					int val = nums[a] + nums[b] + nums[c] + nums[d];
					if (val == target) {
						List<Integer> l = new ArrayList<>();
						l.add(nums[a]);
						l.add(nums[b]);
						l.add(nums[c]);
						l.add(nums[d]);
						list.add(l);
						c++;
						d--;
						while (c < d && nums[c - 1] == nums[c]) // 确保nums[c] 改变了
							c++;
						while (c < d && nums[d + 1] == nums[d]) // 确保nums[d] 改变了
							d--;
					} else if (val > target) {
						d--;
					} else {
						c++;
					}
				}
			}
		}
		return null;
	}
}
