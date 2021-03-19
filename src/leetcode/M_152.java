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
public class M_152 {
	public static void main(String[] args) {
		int a[] = {-2,4,-1 };
		System.out.println(maxProduct(a));
	}

	public static int maxProduct(int[] nums) {
		int n = nums.length;
		if (n == 0)
			return 0;
		if (n == 1)
			return nums[0];
		int min[] = new int[n];
		int max[] = new int[n];
		min[0] = nums[0];
		max[0] = nums[0];
		int max2 = 0;
		for (int i = 1; i < nums.length; i++) {
			max[i] = Math.max(max[i - 1] * nums[i], Math.max(nums[i], min[i - 1] * nums[i]));
			min[i] = Math.min(max[i - 1] * nums[i], Math.min(nums[i], min[i - 1] * nums[i]));
			max2 = Math.max(max2, max[i]);
		}
		System.out.println(Arrays.toString(max));
		System.out.println(Arrays.toString(min));
		return max2;
	}
}
