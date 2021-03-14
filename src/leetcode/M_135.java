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
public class M_135 {

	public static void main(String[] args) {
		TreeNode createTree = TreeUtils.createTree(7);
		createTree.right.right.val = 4;
		LinkedList<Integer> list = new LinkedList<Integer>();
		f(createTree, 8, list);
	}

	static List<List<Integer>> list1 = new ArrayList<>();

	public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
		if (root == null)
			return list1;
		return list1;
	}

	public static void f(TreeNode root, int target, LinkedList<Integer> list) {
		if (root != null) {
			list.add(root.val);
			if (target - root.val == 0 && root.left == null && root.right == null) {
				list1.add(new LinkedList<>(list));
			}
			f(root.left, target - root.val, list);
			f(root.right, target - root.val, list);
			list.removeLast();
		}
	}
}
