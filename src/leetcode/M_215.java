package leetcode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

import javafx.scene.shape.Line;
import leetcode_list.ListNode;
import leetcode_tree.TreeNode;

/**
 * 
 * @author jackjoily
 *
 */
public class M_215 {
	public int findKthLargest(int[] nums, int k) {
		PriorityQueue<Integer> pq = new PriorityQueue<>((x, y) -> y - x);
		for (int i = 0; i < nums.length; i++) {
			pq.add(nums[i]);
		}
		for (int i = 0; i < k - 1; i++) {
			pq.poll();
		}
		return pq.peek();
	}
}
