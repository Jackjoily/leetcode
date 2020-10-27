package leetcode_tree;

import java.util.Stack;

public class E_617 {
	public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
		if (t1 == null && t2 == null) {
			return null;
		} else if (t1 == null || t2 == null) {
			return t1 == null ? t2 : t1;
		} else {
			t1.val += t2.val;
			t1.left = mergeTrees(t1.left, t2.left);
			t1.right = mergeTrees(t1.right, t2.right);
			return t1;
		}
	}

	/**
	 * 方法二，在栈中可以存放一个数组，达到一次存放两个节点的目的
	 */
	public TreeNode mergeTrees1(TreeNode t1, TreeNode t2) {
		if (t1 == null) {
			return t2;
		}
		Stack<TreeNode[]> s = new Stack<>();
		s.push(new TreeNode[] { t1, t2 });
		while (s.size() > 0) {
			TreeNode t[] = s.pop();
			if (t[0] == null || t[1] == null) {
				continue;
			}
			t[0].val = t[0].val + t[1].val;
			if (t[0].left == null) {
				t[0].left = t1.left;
			} else {
				s.push(new TreeNode[] { t[0].left, t[1].left });
			}
			if (t[0].right == null) {
				t[0].right = t[1].right;
			} else {
				s.push(new TreeNode[] { t[0].right, t[1].right });
			}
		}
		return t1;
	}

}
