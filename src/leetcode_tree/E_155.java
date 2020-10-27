package leetcode_tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class E_155 {
	public List<Double> averageOfLevels(TreeNode root) {
		List<Double> list = new ArrayList<>();
		if (root == null) {
			return list;
		} else {
			Queue<TreeNode> q = new LinkedList<>();
			q.add(root);
			TreeNode p = null;
			int i = 0;
			double j = 0, res = 0;
			while (q.size() > 0) {
				j = q.size();
				res = 0;
				for (i = q.size(); i > 0; i--) {
					p = q.poll();
					res += p.val;
					if (p.left != null) {
						q.add(p.left);
					}
					if (p.right != null) {
						q.add(p.right);
					}
				}
				list.add((double) (res / j));
			}

		}
		return list;
	}
}
