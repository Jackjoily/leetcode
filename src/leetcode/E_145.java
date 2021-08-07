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
public class E_145 {

	public List<Integer> postorderTraversal(TreeNode root) {
		List<Integer> list = new ArrayList<Integer>();
		Stack<Integer> s = new Stack<>();
		Stack<TreeNode> s1 = new Stack<>();
		s1.add(root);
		while (!s1.isEmpty()) {
			root = s1.pop();
			if (root.left != null) {
				s1.add(root.left);
			}
			if (root.right != null) {
				s1.add(root.right);
			}
		}
		while (!s.isEmpty())
			list.add(s.pop());
		return list;
	}

	public List<Integer> postorderTraversal1(TreeNode root) {
		List<Integer> list = new ArrayList<Integer>();
		Stack<TreeNode> s1 = new Stack<>();
		TreeNode r = null;
		while (!s1.isEmpty() || root != null) {
			if (root != null) {
				s1.add(root);
				root = root.left;
			} else {
				root = s1.peek();
				if (root.right != null && root.right != r) {
					root = root.right;
					s1.add(root);
					root = root.left;
				} else {
					root = s1.pop();
					list.add(root.val);
					r = root;
					root = null;
				}
			}
		}
		return list;
	}
}
