package leetcode_tree;

import java.util.Stack;

public class M_236 {
	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
		Stack<TreeNode> s = getStack(root, p.val);
		Stack<TreeNode> s1 = getStack(root, q.val);
		if (s.size() > s1.size()) {
			for (int i = s.size() - 1; i >= 0; i--) {
				if (s.get(i).val == q.val) {
					return s.get(i);
				}
				for (int j = s1.size() - 1; j >= 0; j--) {
					if (s.get(i).val == s1.get(j).val) {
						return s.get(i);
					}
				}
			}
		} else {
			for (int i = s1.size() - 1; i >= 0; i--) {
				if (s1.get(i).val == p.val) {
					return s1.get(i);
				}
				for (int j = s.size() - 1; j >= 0; j--) {
					if (s1.get(i).val == s.get(j).val) {
						return s1.get(i);
					}
				}
			}

		}
		return null;
	}

	public Stack<TreeNode> getStack(TreeNode root, int val) {
		Stack<TreeNode> s = new Stack<>();
		TreeNode pre = null;
		while (root != null || !s.isEmpty()) {
			if (root != null) {
				s.push(root);
				root = root.left;
			} else {
				root = s.peek();
				if (root.right != null && root.right != pre) {
					root = root.right;
					s.push(root);
					root = root.left;
				} else {
					root = s.pop();
					if (root.val == val) {
						return s;
					}
					pre = root;
					root = null;
				}
			}
		}
		return s;
	}
}
