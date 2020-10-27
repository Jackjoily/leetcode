package leetcode_tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 您需要在二叉树的每一行中找到最大的值。
 * 
 * @author jackjoily
 *
 */
public class M_515 {
	public List<Integer> largestValues(TreeNode root) {
		List<Integer> list = new ArrayList<>();
		if (root == null) {
			return list;
		} else {
			Queue<TreeNode> q = new LinkedList<TreeNode>();
			q.add(root);
			while (q.size() > 0) {
				int max = Integer.MIN_VALUE;
				for (int i = q.size(); i > 0; i--) {
					root = q.poll();
					if (max < root.val)
						max = root.val;
					if (root.left != null) {
						q.add(root.left);
					}
					if (root.right != null) {
						q.add(root.right);
					}
				}
				list.add(max);
			}
		}
		return list;
	}
}
