package leetcode_tree;

import java.util.ArrayList;
import java.util.List;

public class E_572 {
	public static void main(String[] args) {
//		TreeNode n3 = new TreeNode(3);
//		TreeNode n4 = new TreeNode(4);
//		TreeNode n5 = new TreeNode(5);
//		TreeNode n1 = new TreeNode(1);
//		TreeNode n2 = new TreeNode(2);
//		n3.left = n4;
//		n3.right = n5;
//		n4.left = n1;
//		n4.right = n2;
//
//		TreeNode n41 = new TreeNode(4);
//		TreeNode n11 = new TreeNode(1);
//		TreeNode n21 = new TreeNode(2);
//		n41.left = n11;
//		n41.right = n21;
		TreeNode n1 = new TreeNode(1);
		TreeNode n11 = new TreeNode(1);
		TreeNode n111 = new TreeNode(1);
		n1.left = n11;
		E_572 e = new E_572();
		System.out.println(e.isSubtree(n1, n111));

	}

	TreeNode q = null;
	List<TreeNode> list = new ArrayList<>();

	public boolean isSubtree(TreeNode s, TreeNode t) {
		dfs(s, t);
		for (TreeNode treeNode : list) {
			if (dfs1(treeNode, t)) {
				return true;
			}
		}

		return false;
	}

	public boolean dfs1(TreeNode s, TreeNode t) {
		if (s == null && t == null) {
			return true;
		} else if (s == null || t == null) {
			return false;
		} else {
			if (s.val == t.val) {
				return dfs1(s.left, t.left) && dfs1(s.right, t.right);
			} else {
				return false;
			}
		}
	}

	public void dfs(TreeNode s, TreeNode t) {
		if (s != null) {
			if (s.val == t.val) {
				list.add(s);
			}
			dfs(s.left, t);
			dfs(s.right, t);
		}
	}
}
