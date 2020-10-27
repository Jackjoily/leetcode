package leetcode_tree;

import java.util.Stack;

public class M_230 {
	public int kthSmallest(TreeNode root, int k) {
		if (root == null) {
			return 0;
		} else {
			int i = 0;
			Stack<TreeNode> S = new Stack<TreeNode>();
			while (root != null || !S.isEmpty()) {
				if (root != null) {
					S.push(root);
					root = root.left;
				} else {
					root = S.pop();
					i++;
					if (i == k) {
						return root.val;
					}
					root = root.right;
				}
			}
		}
		return 0;
	}
}
