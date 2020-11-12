package JianZhiOffer;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

import leetcode_tree.TreeNode;
import leetcode_tree.TreeUtils;

/**
 * 求 1+2+...+n ，要求不能使用乘除法、for、while、if、else、switch、case等关键字及条件判断语句 （A?B:C）。
 */
public class JianZhiOffer68II {
	public static void main(String[] args) {
		JianZhiOffer68II j = new JianZhiOffer68II();
		TreeNode createTree = TreeUtils.createTree(7);
		System.out.println(j.lowestCommonAncestor(createTree, createTree.left.left, createTree.right.left));
		// porder(createTree, 0);
	}

	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
		if (root == null)
			return root;
		Stack<TreeNode> ps = porder(root, p.val);
		Stack<TreeNode> qs = porder(root, q.val);
		if (ps.size() == qs.size()) {
			for (int i = qs.size() - 1; i >= 0; i--) {
				for (int j = ps.size() - 1; j >= 0; j--) {
					if (qs.get(i).val == ps.get(j).val)
						return qs.get(i);
				}
			}
		} else if (ps.size() < qs.size()) {
			for (int i = qs.size() - 1; i >= 0; i--) {
				if (qs.get(i).val == p.val)
					return p;
				for (int j = ps.size() - 1; j >= 0; j--) {
					if (qs.get(i).val == ps.get(j).val)
						return qs.get(i);
				}
			}
		} else {
			for (int i = ps.size() - 1; i >= 0; i--) {
				if (ps.get(i).val == q.val)
					return q;
				for (int j = qs.size() - 1; j >= 0; j--) {
					if (ps.get(i).val == qs.get(j).val)
						return ps.get(i);
				}
			}
		}
		return root;
	}

	public Stack<TreeNode> porder(TreeNode root, int val) {
		TreeNode r = null;
		Stack<TreeNode> s = new Stack<TreeNode>();
		while (!s.isEmpty() || root != null) {
			if (root != null) {
				s.add(root);
				root = root.left;
			} else {
				root = s.peek();
				if (root.right != null && root.right != r) {
					root = root.right;
					s.add(root);
					root = root.left;
				} else {
					root = s.pop();
					if (root.val == val) {
						return s;
					}
					r = root;
					root = null;
				}
			}
		}
		return s;
	}
}
