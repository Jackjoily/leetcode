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
public class M_216 {
	public static void main(String[] args) {
		LinkedList<Integer> list = new LinkedList<Integer>();
		f(1, 9, list, 3);
	}

	static List<List<Integer>> list1 = new ArrayList<>();

	public List<List<Integer>> combinationSum3(int k, int n) {
		LinkedList<Integer> list = new LinkedList<Integer>();
		f(1, n, list, k);
		return list1;
	}

	public static void f(int begin, int n, LinkedList<Integer> list, int k) {
		if (n == 0 && list.size() == k) {
			list1.add(new ArrayList<>(list));
			return;
		}
		for (int i = begin; i <= 9; i++) {
			if (n - i < 0) {
				break;
			}
			if (list.size() < k) {
				list.add(i);
				f(i + 1, n - i, list, k);
				list.removeLast();
			} else {
				break;
			}
		}
	}

}
