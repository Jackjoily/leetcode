package leetcode_tree;

import java.util.Deque;
import java.util.LinkedList;

public class M_662 {
	public int widthOfBinaryTree(TreeNode root) {
		if (root == null)
			return 0;
		int max = 0;
		Deque<TreeNode> q = new LinkedList<>();
		root.val = 1;
		q.add(root);
		while (q.size() > 0) {
			max = Math.max(max, q.getLast().val - q.getFirst().val);
			for (int i = q.size(); i > 0; i--) {
				root = q.poll();
				if (root.left != null) {
					root.left.val = 2 * root.val;
					q.add(root.left);
				}
				if (root.right != null) {
					root.right.val = 2 * root.val + 1;
					q.add(root.right);
				}
			}

		}
		return max;
	}
}
