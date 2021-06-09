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
public class M_113 {
	static char c[] = {};

	public static void main(String[] args) {
		M_113 m = new M_113();
		Integer a[] = { 1, -2, -3, 1, 3, -2, null, -1 };
		TreeNode tree = TreeUtils.createBinaryTreeByArray(a);
		LinkedList<Integer> list = new LinkedList<>();
		pathSum(tree, -1);
		System.out.println(list1);
	}

	static List<List<Integer>> list1 = new ArrayList<>();

	public static List<List<Integer>> pathSum(TreeNode root, int targetSum) {
		LinkedList<Integer> list2 = new LinkedList<>();
		f(root, list2, targetSum);
		return list1;
	}

	public static void f(TreeNode root, LinkedList<Integer> list, int sum) {
		if (root != null) {
			if (sum - root.val == 0) {
				if ((root.left == null) && (root.right == null)) {
					list.add(root.val);
					list1.add(new ArrayList<>(list));
					list.removeLast();
				} else {
					list.add(root.val);
					f(root.left, list, sum - root.val);
					f(root.right, list, sum - root.val);
					list.removeLast();
				}
			} else {
				list.add(root.val);
				f(root.left, list, sum - root.val);
				f(root.right, list, sum - root.val);
				list.removeLast();
			}
		}
	}
}
