package leetcode_tree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

public class M_1305 {
	public List<Integer> getAllElements(TreeNode p, TreeNode q) {
		Stack<TreeNode> s = new Stack<TreeNode>();
		List<Integer> list = new ArrayList<Integer>();
		while (p != null || !s.isEmpty()) {
			if (p != null) {
				s.push(p);
                p=p.left;
			} else {
				p = s.pop();
				list.add(p.val);
				p = p.right;
			}
		}
		while (q != null || !s.isEmpty()) {
			if (q != null) {
				s.push(q);
                q=q.left;
			} else {
				q = s.pop();
				list.add(q.val);
				q = q.right;
			}
		}
		Collections.sort(list);
		return list;
	}
}
