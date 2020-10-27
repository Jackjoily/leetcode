package leetcode_tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 给定一个二叉树，在树的最后一行找到最左边的值。
 * 
 * @author jackjoily 2 / \ 1 3
 *
 *         1 / \ 2 3 / / \ 4 5 6 / 7
 *
 *
 *
 */
public class M_513 {
	public static void main(String[] args) {
		TreeNode createTree = TreeUtils.createTree(5);
		M_513 m = new M_513();
		System.out.println(m.findBottomLeftValue1(createTree));
	}

	public int findBottomLeftValue1(TreeNode root) {
		LinkedList<TreeNode> q = new LinkedList<TreeNode>();
		q.add(root);
		int res = 0;
		while (q.size() > 0) {
			for (int i = q.size() - 1; i >= 0; i--) {
				root = q.poll();
				if (root.right != null) {
					q.add(root.right);
				}
				if (root.left != null) {
					q.add(root.left);
				}
			}
		}
		return root.val;
	}

	public int findBottomLeftValue(TreeNode root) {
		LinkedList<TreeNode> q = new LinkedList<TreeNode>();
		q.add(root);
		int res = 0;
		while (q.size() > 0) {
			boolean flag = false;
			for (int i = q.size() - 1, k = q.size() - 1; i >= 0; i--) {
				if (i == k) {
					res = q.get(0).val;
				}
				root = q.poll();
				if (root.left != null) {
					q.add(root.left);
					flag = true;
				}
				if (root.right != null) {
					q.add(root.right);
					flag = true;
				}
			}
			if (!flag) {
				return res;
			}
		}
		return 0;
	}
}
