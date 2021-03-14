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
import leetcode_tree.TreeUtils;

/**
 * 
 * @author jackjoily
 *
 */
public class M_129 {

	public static void main(String[] args) {
		TreeNode createTree = TreeUtils.createTree(7);
		f(createTree, 0);
		TreeNode.LevelOrder(createTree);
		System.out.println(sum);
	}

	public int sumNumbers(TreeNode root) {
		if (root == null)
			return 0;
		f(root, 0);
		return sum;
	}

	static int sum = 0;

	public static void f(TreeNode root, int val) {
		if (root != null) {
			if (root.left == null && root.right == null) {
				sum += val * 10 + root.val;
				return;
			} else {
				f(root.left, val * 10 + root.val);
				f(root.right, val * 10 + root.val);
			}
		}
	}
}
