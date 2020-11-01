package JianZhiOffer;

import java.util.ArrayList;
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
public class JianZhiOffer32II {
	List<List<Integer>> list = new ArrayList<>();

	public List<List<Integer>> levelOrder(TreeNode root) {
		if (root == null)
			return list;
		levelOrder1(root);
		return list;

	}

	public void levelOrder1(TreeNode root) {
		Queue<TreeNode> Q = new LinkedList<>();
		Q.add(root);
		while (Q.size() > 0) {
			List<Integer> list1 = new ArrayList<>();
			int n = Q.size();
			for (int i = 0; i < n; i++) {
				root = Q.poll();
				list1.add(root.val);
				if (root.left != null) {
					Q.add(root.left);
				}
				if (root.right != null) {
					Q.add(root.right);
				}
			}
			list.add(list1);
		}
	}
}
