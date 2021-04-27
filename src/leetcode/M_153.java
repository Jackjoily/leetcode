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
		int a[] = { 3,1,2 };
		System.out.println(findMin(a));
	}

	public static int findMin(int[] nums) {
		int low = 0;
		int high = nums.length - 1;
		if (nums[high] >= nums[low]) {
			return nums[low];
		}
		while (low <= high) {
			int mid = (high + low) / 2;
			if (nums[mid] > nums[mid + 1]) {
				return nums[mid + 1];
			}
			if (nums[mid - 1] > nums[mid]) {
				return nums[mid ];
			}
			if (nums[mid] > nums[0]) {
				low = mid + 1;
			} else {
				high = mid - 1;
			}
		}
		return nums[low];
	}
}
