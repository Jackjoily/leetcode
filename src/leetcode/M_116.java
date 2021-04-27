package leetcode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

import basic.Node;
import javafx.scene.shape.Line;
import leetcode_list.ListNode;
import leetcode_tree.TreeNode;

/**
 * 
 * @author jackjoily
 *
 */
public class M_116 {
	public Node connect(Node root) {
		if (root == null)
			return null;
		Node pre = null;
		Queue<Node> q = new LinkedList<Node>();
		Node p=root;
		q.add(root);
		while (!q.isEmpty()) {
			int j = 1;
			for (int i = q.size() - 1; i >= 0; i--) {
				root = q.poll();
				if (j != 1) {
					if (pre != null) {
						pre.next = root;
					}
				}
				if (root.left != null) {
					q.add(root.left);
				}
				if (root.right != null) {
					q.add(root.right);
				}
                		pre = root;
				j++;
			}
		}
		return p;
	}
}
