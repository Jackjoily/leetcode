package leetcode_tree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class M_103 {
	public static void main(String[] args) {
		TreeNode t3 = new TreeNode(3);
		TreeNode t9 = new TreeNode(9);
		TreeNode t20 = new TreeNode(20);
		TreeNode t15 = new TreeNode(15);
		TreeNode t7 = new TreeNode(7);
		t3.left = t9;
		t3.right = t20;
		t20.left = t15;
		t20.right = t7;
		List<List<Integer>> list = zigzagLevelOrder(t3);
		System.out.println(list);
	}

	public static List<List<Integer>> zigzagLevelOrder(TreeNode root) {
		List<List<Integer>> list = new ArrayList<>();
		Queue<TreeNode> queue = new LinkedList<>();
		int front = -1;
		int rear = -1;
		int last = 0;
		int flag=0;
		if (root != null) {
			queue.add(root);
			rear++;
			List<Integer> list1 = new ArrayList<>();
			while (front < rear) {
				root = queue.poll();
				list1.add(root.val);
				front++;
				if (root.left != null) {
					queue.add(root.left);
					rear++;
				}
				if (root.right != null) {
					queue.add(root.right);
					rear++;
				}
				if (front == last) {
					if (flag % 2 == 0) {
						list.add(list1);
					} else {
						Collections.reverse(list1);
						list.add(list1);
					}
					last = rear;
					list1 = new ArrayList<>();
					flag++;
				}
			}
		}

		return list;
	}
}
