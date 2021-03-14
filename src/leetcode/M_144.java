package leetcode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Stack;

import javafx.scene.shape.Line;
import leetcode_list.ListNode;
import leetcode_tree.TreeNode;

/**
 * 
 * @author jackjoily
 *
 */
public class M_144 {
	List<Integer> list = new ArrayList<>();

	public List<Integer> preorderTraversal(TreeNode root) {
		preOrder(root);
		return list;
	}

	public void preOrder(TreeNode root) {
		Stack<TreeNode> s = new Stack<>();
		if (root == null)
			return;
		s.add(root);
		while (s.isEmpty() || root != null) {
			root = s.pop();
			list.add(root.val);
			if (root.right != null) {
				s.add(root.right);
			}
			if (root.left != null) {
				s.add(root.left);
			}
		}
	}

	public void preOrder1(TreeNode root) {
		Stack<TreeNode> s = new Stack<>();
		while (s.isEmpty() || root != null) {
			if (root != null) {
				list.add(root.val);
				s.add(root);
				root = root.left;
			} else {
				root = s.pop();
				root = root.right;
			}
		}
	}

}
