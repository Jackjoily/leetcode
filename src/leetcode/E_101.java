package leetcode;

import java.util.Arrays;
import java.util.HashMap;
import leetcode_tree.TreeNode;

/**
 * twosum
 * 
 * @author jackjoily
 *
 */
public class E_101 {
	public boolean isSymmetric(TreeNode root) {
		if (root == null)
			return true;
		return f(root.left, root.right);
	}

	public boolean f(TreeNode left, TreeNode right) {
		if (left == null && right == null)
			return true;
		if (left == null || right == null)
			return false;
		if (left.val != right.val)
			return false;
		return f(left.right, right.left) && f(left.left, right.right);
	}
}
