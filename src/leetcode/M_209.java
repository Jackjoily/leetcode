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
		int a[] = {1 };
		System.out.println(minSubArrayLen1(1, a));
	}

	/**
	 * 使用滑动窗口解决问题
	 * 
	 * @param target
	 * @param nums
	 * @return
	 */
	public static int minSubArrayLen1(int target, int[] nums) {
		int left = 0, right = 0;
		int sum = 0;
		int max = Integer.MAX_VALUE;
		while (right < nums.length) {
			while (right < nums.length) {
				if (sum < target) {
					sum += nums[right];
					if (sum >= target) {
						break;
					}
					right++;
				} else {
					break;
				}
			}
			if (right == nums.length) {
				break;
			}
			while (sum >= target) {
				max = Math.min(max, right - left + 1);
				sum -= nums[left];
				left++;
			}
			right++;
		}
		return max == Integer.MAX_VALUE ? 0 : max;
	}

	// 使用前缀和的解法
	public static int minSubArrayLen(int target, int[] nums) {
		int n = nums.length;
		int a[] = new int[n + 1];
		a[0] = 0;
		for (int i = 1; i <= n; i++) {
			a[i] = a[i - 1] + nums[i - 1];
		}
		int min = Integer.MAX_VALUE;
		for (int i = 1; i <= n; i++) {
			int sum = a[i - 1] + target;
			int bound = left_bound(a, sum);
			if (bound < 0 || bound > n)
				continue;
			min = Math.min(min, bound - (i - 1));
		}
		return min == Integer.MAX_VALUE ? 0 : min;
	}

	static int left_bound(int[] nums, int target) {
		if (nums.length == 0)
			return -1;
		int left = 0;
		int right = nums.length;
		// 注意
		while (left < right) {
			int mid = (left + right) / 2;
			if (nums[mid] == target) {
				right = mid;
			} else if (nums[mid] < target) {
				left = mid + 1;
			} else if (nums[mid] > target) {
				right = mid;
			}
		}
		return left;
	}
}
