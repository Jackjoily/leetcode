package leetcode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Stack;

import javafx.scene.shape.Line;
import leetcode_list.ListNode;
import leetcode_tree.TreeNode;

/**
 * 
 * @author jackjoily
 *
 */
public class M_114 {
	public void flatten(TreeNode root) {
		if (root == null)
			return;
		TreeNode head=root;
		Stack<TreeNode> q = new Stack<TreeNode>();
		TreeNode pre = null;
		q.add(head);
		while (!q.isEmpty()) {
			head = q.pop();
			if (pre != null) {
				pre.left = null;
				pre.right = root;
			}
			if (head.left != null) {
				q.add(head.left);
			}
			if (root.right != null) {
				q.add(head.right);
			}
			pre = head;
		}
	}
}
