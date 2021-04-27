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
public class M_213II {
	public static void main(String[] args) {
		int a[] = {1,2,1,1};
		System.out.println(		rob(a));
	}
	public static int rob(int[] nums) {
		int n = nums.length;
		if (n == 1)
			return nums[1];
		int hold[] = new int[n];
		int unhold[] = new int[n];
		hold[0] = nums[0];
		int max = hold[0];
		for (int i = 1; i < n - 1; i++) {
			hold[i] = Math.max(unhold[i - 1] + nums[i], hold[i - 1]);
			unhold[i] = Math.max(unhold[i - 1], hold[i - 1]);
			max = Math.max(unhold[i], Math.max(max, hold[i]));
		}
		hold = new int[n];
		unhold = new int[n];
		hold[1] = nums[1];
		max = Math.max(hold[1], max);
		for (int i = 2; i < n; i++) {
			hold[i] = Math.max(unhold[i - 1] + nums[i], hold[i - 1]);
			unhold[i] = Math.max(unhold[i - 1], hold[i - 1]);
			max = Math.max(unhold[i], Math.max(max, hold[i]));
		}
		return max;
	}
}
