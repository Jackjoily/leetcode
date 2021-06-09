package leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

import leetcode_tree.TreeNode;
import leetcode_tree.TreeUtils;

/**
 * twosum
 * 
 * @author jackjoily
 *
 */
public class E_144 {
	public static void main(String[] args) {
		TreeNode createTree = TreeUtils.createTree(7);
		System.out.println(postOrder1(createTree));
		System.out.println(postOrder(createTree));
	}

	public static List<Integer> preorderTraversal(TreeNode root) {
		List<Integer> list = new ArrayList<>();
		Stack<TreeNode> s = new Stack<TreeNode>();
		s.add(root);
		while (!s.isEmpty()) {
			root = s.pop();
			if (root.right != null) {
				s.add(root.right);
			}
			list.add(root.val);
			if (root.left != null) {
				s.add(root.left);
			}

		}
		return list;
	}

	public static List<Integer> postOrder1(TreeNode root) {
		List<Integer> list = new ArrayList<>();
		Stack<TreeNode> s = new Stack<TreeNode>();
		s.add(root);
		while (!s.isEmpty() ) {
			root = s.pop();
			list.add(root.val);
			// 根右左
			if (root.left != null) {
				s.add(root.left);
			}
			if (root.right != null) {
				s.add(root.right);
			}
		}
		Collections.reverse(list);
		return list;
	}

	public static List<Integer> inOrder(TreeNode root) {
		List<Integer> list = new ArrayList<>();
		Stack<TreeNode> s = new Stack<TreeNode>();
		while (!s.isEmpty() || root != null) {
			if (root != null) {
				s.add(root);
				root = root.left;
			} else {
				root = s.pop();
				list.add(root.val);
				root = root.right;
			}
		}
		return list;
	}

	public static List<Integer> postOrder(TreeNode root) {
		List<Integer> list = new ArrayList<>();
		Stack<TreeNode> s = new Stack<TreeNode>();
		TreeNode r = null;
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
					list.add(root.val);
					r = root;
					root = null;
				}
			}
		}
		return list;
	}
}
