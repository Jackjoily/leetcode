package leetcode_tree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 给定一个二叉树，返回其节点值自底向上的层次遍历。 （即按从叶子节点所在层到根节点所在的层，逐层从左向右遍历）
 * 
 * @author jackjoily
 *
 */
public class E_107 {
	public static void main(String[] args) {

	}

	public List<List<Integer>> levelOrderBottom(TreeNode root) {
		List<List<Integer>> list = new ArrayList<>();
		if (root == null) {
			return list;
		} else {
			Queue<TreeNode> queue = new LinkedList<TreeNode>();
			List<Integer> list1 = new ArrayList<>();
			int front = -1, rear = -1, last = 0;
			queue.add(root);
			rear++;
			while (front < rear) {
				root = queue.poll();
				list1.add(root.val);
				front++;
				if (root.left != null) {
					queue.add(root.left);
					rear++;
				}
				if (root.right != null) {
					queue.add(root.right);
					rear++;
				}

				if (front == last) {
					last = rear;
					list.add(list1);
					list1 = new ArrayList<>();
				}

			}

		}
		 Collections.reverse(list);
		return list;
	}
}
