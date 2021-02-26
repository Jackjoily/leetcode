package newcoder;

import leetcode_tree.TreeNode;
import leetcode_tree.TreeUtils;

public class NC16 {
	public static void main(String[] args) {
		TreeNode createTree = TreeUtils.createTree(3);
		TreeNode n1 = new TreeNode(1);
		TreeNode n2 = new TreeNode(2);
		TreeNode n3 = new TreeNode(2);
		n1.left=n2;
		n1.right=n3;
		System.out.println(isSymmetric(n1));
	}

	public static boolean isSymmetric(TreeNode root) {
		if (root == null)
			return true;
		if (root.left == null && root.right == null)
			return true;
		return f(root.left, root.right);
	}

	public static boolean f(TreeNode left, TreeNode right) {
		if (left == null && right == null)
			return true;
		else if (left != null && right != null) {
			if (left.val != right.val)
				return false;
			return f(left.left, right.right) && f(left.right, right.left);
		}
		else {
			return false;
		}
	}

}
