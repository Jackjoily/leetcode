package leetcode_tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 给定一棵二叉树，想象自己站在它的右侧，按照从顶部到底部的顺序，返回从右侧所能看到的节点值。
 * 
 * @author jackjoily
 *
 */
public class M_199 {
	List<Integer> list = new ArrayList<>();

	public List<Integer> rightSideView(TreeNode root) {
		if (root == null) {
			return list;
		} else {
			levelOrder(root);
		}
		return list;
	}

	public void levelOrder(TreeNode root) {
		if (root == null) {
			return;
		}
		Queue<TreeNode> Q = new LinkedList<TreeNode>();
		Q.add(root);
		while (Q.size() > 0) {
			int size = Q.size();
			for (int i = 0; i < size; i++) {
				TreeNode node = Q.poll();
				if (i == size - 1) {
					list.add(node.val);
				}
				// 这里的节点都是一层中的节点
				if (node.left != null) {
					Q.add(node.left);
				}
				if (node.right != null) {
					Q.add(node.right);
				}
			}
		}
	}
}
