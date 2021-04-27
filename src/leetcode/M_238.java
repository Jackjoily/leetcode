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
public class M_238 {
	public static void main(String[] args) {
		int a[] = { 1, 2, 3, 4 };
		System.out.println(Arrays.toString(	productExceptSelf(a)));
	}

	public static int[] productExceptSelf(int[] nums) {
		int[] res = new int[nums.length];
		int k = 1;
		for (int i = 0; i < nums.length; i++) {
			res[i] = k;
			k *= nums[i];
		}
		k = 1;
		for (int i = nums.length - 1; i >= 0; i--) {
			res[i] *= k;
			k *= nums[i];
		}
		return res;
	}
}
