package leetcode_wx;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

import leetcode_list.ListNode;
import leetcode_tree.TreeNode;
import leetcode_tree.TreeUtils;

public class M_114 {
	public void flatten(TreeNode root) {
		if (root == null || root.left == null && root.right == null)
			return;
		Stack<TreeNode> s = new Stack<TreeNode>();
		s.add(root);
		TreeNode head = root;
		TreeNode pre = null;
		while (!s.isEmpty()) {
			root = s.pop();
			if (pre != null) {
				pre.right = root;
			}
			pre = root;
			if (root.right != null) {
				s.add(root.right);
			}
			if (root.left != null) {
				s.add(root.left);
			}
			root.left = null;
		}
	}

}