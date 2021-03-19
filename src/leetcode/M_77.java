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
import leetcode_tree.TreeUtils;

/**
 * 
 * @author jackjoily
 *
 */
public class M_77 {
	public static void main(String[] args) {

	}

	List<List<Integer>> list1 = new ArrayList<>();

	public List<List<Integer>> combine(int n, int k) {
		LinkedList<Integer> list = new LinkedList<>();
		f(1, k, n,list);
		return list1;
	}

	public void f(int begin, int k, int n, LinkedList<Integer> list) {
		if (list.size() == k) {
			list1.add(new ArrayList<>(list));
			return;
		}
		for (int i = begin; i <= n; i++) {
			list.add(i);
			f(i + 1, k, n, list);
			list.removeLast();
		}
	}
}
