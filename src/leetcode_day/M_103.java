package leetcode_day;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import leetcode_list.ListNode;
import leetcode_tree.TreeNode;
import leetcode_tree.TreeUtils;

public class M_103 {
	/**
	 * 
	 * 给定一个二叉树，返回其节点值的锯齿形层序遍历。 （即先从左往右，再从右往左进行下一层遍历，以此类推， 层与层之间交替进行）。
	 * 
	 */
	public static void main(String[] args) {
		TreeNode createTree = TreeUtils.createTree(7);
		System.out.println(zigzagLevelOrder(createTree));
	}

	public static List<List<Integer>> zigzagLevelOrder(TreeNode root) {
		List<List<Integer>> list = new ArrayList<>();
		if (root == null)
			return list;
		Queue<TreeNode> q = new LinkedList<>();
		q.add(root);
		int l = 1;
		while (!q.isEmpty()) {
			List<Integer> list1 = new ArrayList<>();
			for (int i = q.size()-1; i>=0; i--) {
				TreeNode poll = q.poll();
				list1.add(poll.val);
				if (poll.left != null) {
					q.add(poll.left);
				}
				if (poll.right != null) {
					q.add(poll.right);
				}
			}
			if (l % 2 != 0) {
				list.add(list1);
			} else {
				Collections.reverse(list1);
				list.add(list1);
			}
			l++;
		}
		return list;
	}
}
