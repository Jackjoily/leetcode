package leetcode;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

import leetcode_list.ListNode;
import leetcode_tree.TreeNode;
import leetcode_tree.TreeUtils;
import sun.nio.cs.ext.ISCII91;

/**
 * 
 * @author jackjoily
 *
 */
public class M_958 {
	public boolean isCompleteTree(TreeNode root) {
		LinkedList<TreeNode> q = new LinkedList<>();
		q.add(root);
		while (!q.isEmpty()) {
			root = q.poll();
			if (root != null) {
				q.add(root.left);
				q.add(root.right);
			} else {
				while (!q.isEmpty() && (root = q.poll()) == null)
					;
				if (root != null)
					return false;
			}
		}
		return true;
	}
}
