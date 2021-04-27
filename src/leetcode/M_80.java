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
public class M_80 {
	public static void main(String[] args) {
		int a[] = { 1,1,1,2,2,3 };
		System.out.println(removeDuplicates(a));
	}

	public static int removeDuplicates(int[] nums) {
		int n = nums.length;
		if (n <= 2)
			return n;
		int i = 1, j = 1;
		int count = 1;
		for (; i < n; i++) {
			if (nums[i - 1] == nums[i]) {
				count++;
			} else {
				count = 1;
			}
			if (count <= 2) {
				nums[j++] = nums[i];
			}
		}
		return j;
	}
}
