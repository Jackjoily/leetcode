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
public class M_560 {
	public static void main(String[] args) {
		int a[] = { 1, 1, 1 };
		System.out.println(subarraySum(a, 2));
	}

	public static int subarraySum(int[] nums, int k) {
		int n = nums.length;
		if (n == 1)
			return nums[0] == k ? 1 : 0;
		int res = 0;
		Map<Integer, Integer> map = new HashMap<>();
		map.put(0, 1);
		int cur = 0;
		for (int i = 0; i < nums.length; i++) {
			cur += nums[i];
			res += map.getOrDefault(cur - k, 0);
			map.put(cur, map.getOrDefault(cur, 0) + 1);
		}
		return res;
	}
}
