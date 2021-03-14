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

/**
 * 
 * @author jackjoily
 *
 */
public class M_40II {
	public static void main(String[] args) {
		LinkedList<Integer> list = new LinkedList<>();
		int a[] = { 2, 5, 2, 1, 2 };
		Arrays.sort(a);
		f(a, 5, 0, list);
	}

	List<List<Integer>> list = new LinkedList<>();
	static Set<LinkedList<Integer>> set = new HashSet<>();

	public List<List<Integer>> combinationSum2(int[] candidates, int target) {
		if (candidates.length == 0)
			return list;
		list.addAll(set);
		return list;
	}

	public static void f(int a[], int target, int begin, LinkedList<Integer> list) {
		if (target == 0) {
			set.add(new LinkedList<>(list));
			return;
		}
		for (int i = begin; i < a.length; i++) {
			if (target - a[i] < 0)
				return;
			list.add(a[i]);
			f(a, target - a[i], i + 1, list);
			list.removeLast();
		}
	}
}
