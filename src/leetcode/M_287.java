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
public class M_287 {
	public int findDuplicate(int[] nums) {
		int slow = nums[0];
		int fast = nums[nums[slow]];
		while (slow != fast) {
			slow = nums[slow];
			fast = nums[nums[fast]];
		}
		int pre = 0;
		int pre1 = slow;
		while (pre != pre1) {
			pre = nums[pre];
			pre1 = nums[pre1];
		}
		return pre;
	}
}
