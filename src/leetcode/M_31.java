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
public class M_31 {
	public static void main(String[] args) {
		int a[] = { 3,2,1};
		nextPermutation(a);
		System.out.println(Arrays.toString(a));
	}

	public static void nextPermutation(int[] nums) {
		int len = nums.length;
		boolean flag = true;
		int i = len - 1;
		for (; i >= 1; i--) {
			if (nums[i] > nums[i - 1]) {
				flag = false;
				i--;
				break;
			}
		}
		if (flag) {
			Arrays.sort(nums);
			return;
		}
		for (int j = nums.length - 1; j >= i; j--) {
			if (nums[j] > nums[i]) {
				int temp = nums[j];
				nums[j] = nums[i];
				nums[i] = temp;
				break;
			}
		}
		Arrays.sort(nums,i+1,nums.length);
	}
}
