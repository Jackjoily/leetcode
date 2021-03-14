package leetcode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

import javafx.scene.shape.Line;
import leetcode_list.ListNode;
import leetcode_tree.TreeNode;
import leetcode_tree.TreeUtils;

/**
 * 
 * @author jackjoily
 *
 */
public class M_209 {
	public static void main(String[] args) {
		int a[] = {2,3,1,2,4,3,234};
		System.out.println(minSubArrayLen(7, a));
	}

	public static int minSubArrayLen(int target, int[] nums) {
		int n = nums.length;
		int left, right;
		left = 0;
		right = 0;
		int sum = nums[left];
		int len = Integer.MAX_VALUE;
		while (right < n && left <= right) {
			while (left <= right && sum > target) {
				sum -= nums[left];
				left++;
			}
			if (left>0&&sum + nums[left - 1] > target) {
				len = Math.min(len, right - left + 2);
			}
			while (sum < target) {
				right++;
				if (right == n)
					break;
				sum += nums[right];
			}
			if (right == n) {
				break;
			}
			len = Math.min(len, right - left + 1);
			if (len == 1) {
				return 1;
			}
			sum -= nums[left];
			left++;
		}
		return len == Integer.MAX_VALUE ? 0 : len;
	}
}
