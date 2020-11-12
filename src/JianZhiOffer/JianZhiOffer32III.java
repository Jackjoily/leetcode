package JianZhiOffer;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import leetcode_tree.TreeNode;

/**
 * 找出数组中重复的数字。
 * 
 * 
 * 从上到下按层打印二叉树，同一层的节点按从左到右的顺序打印， 每一层打印到一行。
 * 
 * 
 * @author jackjoily
 *
 */
public class JianZhiOffer32III {
	List<List<Integer>> list1 = new ArrayList<>();

	public List<List<Integer>> levelOrder(TreeNode root) {
		if (root == null)
			return list1;
		f(root);
		return list1;
	}

	public void f(TreeNode root) {
		Queue<TreeNode> q = new LinkedList<>();
		q.add(root);
		int k = 1;
		while (q.size() > 0) {
			int n = q.size();
			List<Integer> list = new ArrayList<>();
			if (k % 2 != 0) {
				for (int i = 0; i < n; i++) {
					root = q.poll();
					list.add(root.val);
					if (root.left != null) {
						q.add(root.left);
					}
					if (root.right != null) {
						q.add(root.right);
					}
				}
				list1.add(list);
			} else {
				for (int i = 0; i < n; i++) {
					root = q.poll();
					list.add(root.val);
					if (root.left != null) {
						q.add(root.left);
					}
					if (root.right != null) {
						q.add(root.right);
					}
				}
				Collections.reverse(list);
				list1.add(list);
			}
			k++;
		}
	}

}
