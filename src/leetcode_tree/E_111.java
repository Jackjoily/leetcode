package leetcode_tree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

public class E_111 {
	public int minDepth(TreeNode root) {
		if (root == null) {
			return 0;
		}
		Stack<TreeNode> s = new Stack<TreeNode>();
		TreeNode p = root;
		TreeNode pre = null;
		List<Integer> list = new ArrayList<>();
		while (p != null || !s.isEmpty()) {
			if (p != null) {
				s.push(p);
				p = p.left;
			} else {
				p = s.peek();
				if (p.right != null && p.right != pre) {
					p = p.right;
					s.push(p);
					p = p.left;
				} else {
					p = s.pop();
					if (p.right == null && p.left == null) {
						list.add(s.size() + 1);
					}
					pre = p;
					p = null;
				}
			}
		}
		Collections.sort(list);
		return list.get(0);
	}
}
