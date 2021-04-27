package leetcode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Stack;

import javafx.scene.shape.Line;
import leetcode_list.ListNode;
import leetcode_tree.TreeNode;

/**
 * 
 * @author jackjoily
 *
 */
public class M_503II {
	public int[] nextGreaterElements(int[] nums) {
		int len = nums.length;
		int a[] = new int[len];
		Arrays.fill(a, -1);
		Stack<Integer> s = new Stack<>();
		//将一个循环数组进行拉直操作
		for (int i = 0; i < 2 * len - 1; i++) {
			if (s.isEmpty()) {
				s.add(i % len);
			} else {
				while (!s.isEmpty() && nums[i % len] > nums[s.peek()]) {
					a[s.pop()] = nums[i % len];
				}
				
				s.add(i % len);
			}
		}
		return a;
	}
}
