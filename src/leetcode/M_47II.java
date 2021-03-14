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
public class M_47II {
	public static void main(String[] args) {
		int a[] = { 1, 1, 2 };
		LinkedList<Integer> list = new LinkedList<>();
		boolean[] used= new boolean[a.length];
		f(a, 0, list, used);
	}

	public List<List<Integer>> permuteUnique(int[] nums) {
		return null;
	}

	public static void f(int a[], int begin, LinkedList<Integer> list, boolean used[]) {
		if (list.size() == a.length) {
			System.out.println(list);
			return;
		}
		for (int i = begin; i < a.length; i++) {
			if (i > 0 && a[i] == a[i - 1] && !used[i - 1] || used[i])
				continue;
				list.add(a[i]);
				used[i] = true;
				f(a, begin, list, used);
				used[i] = false;
				list.removeLast();
			}
	}
}
