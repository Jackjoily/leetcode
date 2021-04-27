package leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import leetcode_tree.TreeNode;

/**
 * twosum
 * 
 * @author jackjoily
 *
 */
public class JianZhiOffer32III {
	public static void main(String[] args) {
	}

	public List<List<Integer>> levelOrder(TreeNode root) {
		Queue<TreeNode> q = new LinkedList<>();
		List<List<Integer>> list = new ArrayList<>();
		if (root == null)
			return list;
		q.add(root);
		int k = 0;
		while (!q.isEmpty()) {
			List<Integer> list1 = new ArrayList<>();
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
			if (k % 2 != 0) {
				Collections.reverse(list1);
			}
			list.add(list1);
			k++;
		}

		return list;
	}
}
