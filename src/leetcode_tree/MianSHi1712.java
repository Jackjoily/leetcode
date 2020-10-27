package leetcode_tree;

import java.util.Stack;

public class MianSHi1712 {
	public static void main(String[] args) {
		TreeNode t4 = new TreeNode(4);
		TreeNode t2 = new TreeNode(2);
		TreeNode t5 = new TreeNode(5);
		TreeNode t1 = new TreeNode(1);
		TreeNode t3 = new TreeNode(3);
		TreeNode t6 = new TreeNode(6);
		TreeNode t0 = new TreeNode(0);
		t4.left = t2;
		t4.right = t5;
		t2.left = t1;
		t2.right = t3;
		t5.right = t6;
		t1.left = t0;
		convertBiNode(t4);
	}

	public static TreeNode convertBiNode(TreeNode root) {
		TreeNode pre = null;
		TreeNode first = null;
		int i = 0;
		if (root == null) {
			return null;
		} else {
			Stack<TreeNode> stack = new Stack<TreeNode>();
			while (root != null || !stack.isEmpty()) {
				if (root != null) {
					stack.add(root);
					root = root.left;
				} else {
					root = stack.pop();
					root.left = null;
					if (i == 0) {
						pre = root;
						first = root;
					} else {
						pre.right = root;
						pre = root;
					}
					i++;
					root = root.right;
				}
			}
		}
		return first;
	}
}
