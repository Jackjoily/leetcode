package JianZhiOffer;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import leetcode_tree.TreeNode;

/**
 * 从上到下打印出二叉树的每个节点， 同一层的节点按照从左到右的顺序打印。
 * 
 * @author jackjoily
 *
 */
public class JianZhiOffer32I {
	public int[] levelOrder(TreeNode root) {
		if (root == null)
			return new int[0];
		Queue<TreeNode> q = new LinkedList<>();
		q.add(root);
		List<Integer> list = new ArrayList<>();
		while (q.size() > 0) {
			for (int i = 0; i < q.size(); i++) {
				root = q.poll();
				list.add(root.val);
				if (root.left != null) {
					q.add(root.left);
				}
				if (root.right != null) {
					q.add(root.right);
				}
			}
		}
		int a[] = new int[list.size()];
		for (int k = 0; k < list.size(); k++) {
			a[k] = list.get(k);
		}
		return a;
	}
}
