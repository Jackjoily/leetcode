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
public class M_153 {
	public static void main(String[] args) {
		int a[] = { 4, 5, 6, 7, 8, 9, 1, 2, 3 };
		System.out.println(findMin(a));
	}

	public static int findMin(int[] nums) {
		int low = 0;
		int high = nums.length - 1;
		int l = Integer.MAX_VALUE;
		while (low <= high) {
			int mid = (high + low) / 2;
			if (nums[mid] <= nums[high]) {
				l = Math.min(l, nums[mid]);
				high = mid - 1;
			} else {
				l = Math.min(l, nums[high]);
				low = mid + 1;
			}
		}
		return l;
	}
}
