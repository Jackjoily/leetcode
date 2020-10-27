package leetcode_tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class M_144 {

	public static void main(String[] args) {
		TreeNode node = TreeUtils.createTree(7);
		preorderTraversal(node);
	}

	public static List<Integer> preorderTraversal(TreeNode root) {
		List<Integer> list = new ArrayList<>();
		if (root == null) {
			return list;
		} else {
			Stack<TreeNode> s = new Stack<TreeNode>();
			while (root != null || !s.isEmpty()) {
				if (root != null) {
					System.out.println(root.val);
					list.add(root.val);
					s.push(root);
					root = root.left;
				} else {
					root = s.pop();
					root = root.right;
				}
			}

		}
		return list;
	}
}
