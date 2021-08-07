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
public class M_198 {
	public int rob(int[] nums) {
		int n = nums.length;
		if (n == 1)
			return nums[0];
		int hold[] = new int[n];
		int uhold[] = new int[n];
		hold[0] = nums[0];
		for (int i = 1; i < n; i++) {
			hold[i] = Math.max(hold[i - 1], uhold[i - 1] + nums[i]);
			uhold[i] = Math.max(uhold[i - 1], hold[i - 1]);
		}
		return hold[n - 1] > uhold[n - 1] ? hold[n - 1] : uhold[n - 1];
	}
}
