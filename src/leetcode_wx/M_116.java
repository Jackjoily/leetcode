package leetcode_wx;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

import basic.Node;
import leetcode_list.ListNode;
import leetcode_tree.TreeNode;
import leetcode_tree.TreeUtils;

public class M_116 {
	public Node connect(Node root) {
		if (root == null)
			return root;
		Node head = root;
		Queue<Node> q = new ArrayDeque<>();
		q.add(root);
		while (!q.isEmpty()) {
			Node pre = null;
			for (int i = q.size(); i > 0; i--) {
				root = q.poll();
				if (pre != null) {
					pre.next = root;
				}
				if (root.left != null) {
					q.add(root.left);
				}
				if (root.right != null) {
					q.add(root.right);
				}
				pre = root;
			}
			if (pre != null) {
				pre.next = null;
			}
		}
		return head;
	}
}