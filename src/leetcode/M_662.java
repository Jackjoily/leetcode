package leetcode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Queue;

import javafx.scene.shape.Line;
import leetcode_list.ListNode;
import leetcode_tree.TreeNode;

/**
 * 
 * @author jackjoily
 *
 */
public class M_662 {
	public static void main(String[] args) {
		TreeNode n1 = new TreeNode(1);
		TreeNode n3 = new TreeNode(3);
		TreeNode n5 = new TreeNode(5);
		TreeNode n33 = new TreeNode(3);
		n1.left = n3;
		n3.left = n5;
		n3.right = n33;
	}

	public int widthOfBinaryTree(TreeNode root) {
		Queue<MyNode1> q = new ArrayDeque<>();
		if (root == null) {
			return 0;
		}
		MyNode1 m = null;
		q.add(new MyNode1(root, 1));
		int max = 0;
		int i = 0;
		while (!q.isEmpty()) {
			int left = 0;
			int right = 0;
			int n = q.size();
			for (i = n; i > 0; i--) {
				if (i == n) {
					left = m.inx;
				}
				if (i == 1) {
					right = m.inx;
				}
				m = q.poll();
				if (m.node.left != null) {
					q.add(new MyNode1(m.node.left, m.inx * 2));
				}
				if (m.node.right != null) {
					q.add(new MyNode1(m.node.right, m.inx * 2 + 1));
				}
			}
			max = Math.max(max, right - left);
		}
		return max;
	}
}

class MyNode1 {
	TreeNode node;
	int inx;

	public MyNode1(TreeNode node, int inx) {
		super();
		this.node = node;
		this.inx = inx;
	}

}
