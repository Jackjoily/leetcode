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

import javafx.scene.shape.Line;
import leetcode_list.ListNode;
import leetcode_tree.TreeNode;

/**
 * 
 * @author jackjoily
 *
 */
public class M_46 {
	public static void main(String[] args) {
		int a[] = { 1, 2, 3 };
		LinkedList<Integer> list = new LinkedList<>();
		boolean flag[] = new boolean[a.length];
	}

	List<List<Integer>> list1 = new ArrayList<>();

	public List<List<Integer>> permute(int[] nums) {
		boolean flag[] = new boolean[nums.length];
		LinkedList<Integer> list = new LinkedList<>();
		f(nums, list, flag);
		return list1;
	}

	public void f(int[] a, LinkedList<Integer> list, boolean flag[]) {
		if (a.length == list.size()) {
			list1.add(new ArrayList<>(list));
			return;
		}
		for (int i = 0; i < a.length; i++) {
			if (!flag[i]) {
				list.add(a[i]);
				flag[i] = true;
				f(a, list, flag);
				flag[i] = false;
				list.removeLast();
			}
		}
	}
}
