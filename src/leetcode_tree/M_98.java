package leetcode_tree;

import java.util.Stack;

public class M_98 {
	public static void main(String[] args) {
		TreeNode n2 = new TreeNode(2);
		TreeNode n1 = new TreeNode(1);
		TreeNode n3 = new TreeNode(3);
		n2.left = n1;
		n2.right = n3;
		System.out.println(isValidBST(n2));
	}

	/**
	 * 使用中序遍历进行判断
	 * 
	 * @param root
	 * @return
	 */

	public static boolean isValidBST(TreeNode root) {
		int min = Integer.MIN_VALUE;
		TreeNode q = null;
		boolean flag = true;
		if (root == null) {
			return flag;
		} else {
			Stack<TreeNode> stack = new Stack<TreeNode>();
			while (root != null || !stack.isEmpty()) {
				if (root != null) {
					stack.add(root);
					root = root.left;
				} else {
					root = stack.pop();
					if (min >= root.val) {
						return false;
					}
					min = root.val;
					root = root.right;

				}
			}

		}

		return flag;
	}
}
