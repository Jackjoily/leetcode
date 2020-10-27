package leetcode_tree;

import java.util.Stack;

/**
 * 二叉搜索树的最近公共祖先
 * 
 * @author jackjoily
 *
 */
public class JianZhi8_1 {
	public static void main(String[] args) {
		TreeNode n1 = new TreeNode(1);
		TreeNode n2 = new TreeNode(2);
		TreeNode n3 = new TreeNode(3);
		TreeNode n4 = new TreeNode(4);
		TreeNode n5 = new TreeNode(5);
		TreeNode n6 = new TreeNode(6);
		TreeNode n7 = new TreeNode(7);
		n2.left = n1;
//		n1.left = n2;
//		n1.right = n3;
//		n2.left = n4;
//		n2.right = n5;
//		n3.left = n6;
//		n3.right = n7;
		System.out.println(lowestCommonAncestor(n2, n2, n1));
	}

	public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
		Stack<TreeNode> s = postOrder(root, p.val);
		Stack<TreeNode> s1 = postOrder(root, q.val);
		if (s.size() > s1.size()) {
			for (int j = s.size() - 1; j >= 0; j--) {
				if (s.get(j).val == q.val) {
					return q;
				}
			}
			for (int i = s1.size() - 1; i >= 0; i--) {
				for (int j = s.size() - 1; j >= 0; j--) {
					if (s.get(j).val == s1.get(i).val) {
						return s.get(j);
					}
				}
			}

		} else {
			for (int j = s1.size() - 1; j >= 0; j--) {
				if (s1.get(j).val == p.val) {
					return p;
				}
			}
			for (int i = s.size() - 1; i >= 0; i--) {
				for (int j = s1.size() - 1; j >= 0; j--) {
					if (s1.get(j).val == s.get(i).val) {
						return s1.get(j);
					}
				}
			}
		}
		return null;

	}

	public static Stack<TreeNode> postOrder(TreeNode root, int val) {
		Stack<TreeNode> stack = new Stack<TreeNode>();
		TreeNode pre = null;
		while (root != null || !stack.isEmpty()) {
			if (root != null) {
				stack.push(root);
				root = root.left;
			} else {
				root = stack.peek();
				if (root.right != null && root.right != pre) {
					root = root.right;
					stack.push(root);
					root = root.left;
				} else {
					root = stack.pop();
					if (root.val == val) {
						return stack;
					}
					pre = root;
					root = null;
				}

			}

		}
		return stack;
	}
}
