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
import java.util.Set;

import javafx.scene.shape.Line;
import leetcode_list.ListNode;
import leetcode_tree.TreeNode;
import sun.security.krb5.KdcComm;

/**
 * 
 * @author jackjoily
 *
 */
public class M_128 {
	public int longestConsecutive(int[] nums) {
		Set<Integer> set = new HashSet<Integer>();
		for (int i = 0; i < nums.length; i++) {
			set.add(nums[i]);
		}
		int max = 1;
		for (int n : set) {
			if (!set.contains(n - 1)) {
				int curr = n;
				int len = 1;
				while (set.contains(curr + 1)) {
					curr++;
					len++;
				}
				max = Math.max(max, len);
			}
		}
		return max;
	}
}
