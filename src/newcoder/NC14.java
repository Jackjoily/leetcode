package newcoder;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Queue;


import leetcode_tree.TreeNode;

public class NC14 {
	public static void main(String[] args) {
	}

	public ArrayList<ArrayList<Integer>> zigzagLevelOrder(TreeNode root) {
		ArrayList<ArrayList<Integer>> list = new ArrayList<>();
		if (root == null)
			return list;
		Queue<TreeNode> q = new ArrayDeque<>();
		q.add(root);
		int j = 0;
		while (!q.isEmpty()) {
			ArrayList<Integer> list1 = new ArrayList<>();
			for (int i = q.size(); i > 0; i--) {
				root = q.poll();
				list1.add(root.val);
				if (root.left != null) {
					q.add(root.left);
				}
				if (root.right != null) {
					q.add(root.right);
				}
			}
			if (j % 2 != 0) {
			Collections.reverse(list1);
			}
			list.add(list1);
			j++;
		}
		return list;
	}
}
