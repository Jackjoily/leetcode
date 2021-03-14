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
public class M_189 {
	public static void main(String[] args) {
		int a[] = {-1,-100,3,99};
		rotate(a, 2213);
		System.out.println(Arrays.toString(a));
	}

	public static  void rotate(int[] nums, int k) {
		k = k % nums.length;
		if (k == 0)
			return;
		reverse(nums, 0, nums.length - 1);
		reverse(nums, 0, k-1);
		reverse(nums, k, nums.length - 1);
	}

	public static void reverse(int a[], int i, int j) {
		while (i < j) {
			int temp = a[i];
			a[i] = a[j];
			a[j] = temp;
			i++;
			j--;
		}
	}
}
