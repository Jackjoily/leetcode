package leetcode_tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class H_145 {
	public List<Integer> postorderTraversal(TreeNode root) {
		List<Integer> list = new ArrayList<>();
		if (root == null) {
			return list;
		}
		TreeNode pre = null;
		Stack<TreeNode> s = new Stack<>();
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
					list.add(root.val);
					pre = root;
					root = null;
				}

			}

		}
		return list;
	}
}
