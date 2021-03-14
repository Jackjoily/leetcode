package leetcode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Stack;

import leetcode_tree.TreeNode;
import leetcode_tree.TreeUtils;

/**
 * 
 * @author jackjoily
 *
 */
public class M_236 {
	public static void main(String[] args) {
		Integer a[] = { 3, 5, 1, 6, 2, 0, 8, null, null, 7, 4 };
		TreeNode t = TreeUtils.createBinaryTreeByArray(a);
		System.out.println(lowestCommonAncestor(t, t.right.left, t.right.right));
	}

	public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
		Stack<TreeNode> s = new Stack<>();
		List<TreeNode> l1 = new ArrayList<>();
		List<TreeNode> l2 = new ArrayList<>();
		TreeNode r = null;
		TreeNode head = root;
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
					if (root.val == p.val) {
						l1.add(root);
						for (int i = s.size() - 1; i >= 0; i--) {
							l1.add(s.get(i));
						}
						break;
					}
					r = root;
					root = null;
				}
			}
		}
		s.clear();
		root = head;
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
					if (root.val == q.val) {
						l2.add(root);
						for (int i = s.size() - 1; i >= 0; i--) {
							l2.add(s.get(i));
						}
						break;
					}
					r = root;
					root = null;
				}
			}
		}
		int m1 = l1.size();
		int m2 = l2.size();
		if (m1 == m2) {
			for (int i = 0; i <= m1 - 1; i++) {
				for (int j = 0; j <= m2 - 1; j++) {
					if (l1.get(i) == l2.get(j)) {
						return l1.get(i);
					}
				}
			}
		} else if (m1 < m2) {
			for (int i = 0; i <= m1 - 1; i++) {
				for (int j = 0; j <= m2 - 1; j++) {
					if (l1.get(i) == l2.get(j)) {
						return l1.get(i);
					}
				}
			}
		} else {
			for (int i = 0; i <= m2 - 1; i++) {
				for (int j = 0; j <= m1 - 1; j++) {
					if (l2.get(i) == l1.get(j)) {
						return l2.get(i);
					}
				}
			}
		}
		return head;
	}
}
