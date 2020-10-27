package leetcode_tree;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Stack;

/**
 * 
 * @author jackjoily 173. 二叉搜索树迭代器
 */
public class BSTIterator {
	List<Integer> list = new ArrayList<>();
	Iterator<Integer> it = null;

	public BSTIterator(TreeNode root) {
		Stack<TreeNode> s = new Stack<TreeNode>();
		while (root != null || !s.isEmpty()) {
			if (root != null) {
				s.push(root);
				root = root.left;
			} else {
				root = s.pop();
				list.add(root.val);
				root = root.right;
			}
		}

		it = list.iterator();
	}

	/** @return the next smallest number */
	public int next() {
		return it.next();
	}

	/** @return whether we have a next smallest number */
	public boolean hasNext() {
		return it.hasNext();
	}
}
