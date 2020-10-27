package leetcode_tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 给定一个完美二叉树，其所有叶子节点都在同一层，每个父节点都有两个子节点。二叉树定义如下：
 * 
 * @author jackjoily
 *
 */
public class M_116 {

	public static void main(String[] args) {

		Node n1 = new Node(1);
		Node n2 = new Node(2);
		Node n3 = new Node(3);
		Node n4 = new Node(4);
		Node n5 = new Node(5);
		Node n6 = new Node(6);
		Node n7 = new Node(7);
		n1.left = n2;
		n1.right = n3;
		n2.left = n4;
		n2.right = n5;
		n3.left = n6;
		n3.right = n7;
		connect(n1);

	}

	public static Node connect(Node root) {
		Node p = root;
		if (root == null) {
			return null;
		} else {
			List<Node> list = new ArrayList<>();
			int front = -1, rear = -1, last = 0;
			Queue<Node> q = new LinkedList<Node>();
			q.add(root);
			rear++;
			while (front < rear) {
				root = q.poll();
				list.add(root);
				front++;
				if (root.left != null) {
					q.add(root.left);
					rear++;
				}
				if (root.right != null) {
					q.add(root.right);
					rear++;
				}
				if (front == last) {
					last = rear;
					for (int i = 0; i + 1 < list.size(); i++) {
						list.get(i).next = list.get(i + 1);
					}
					list.get(list.size() - 1).next = null;
					list.clear();
				}

			}

		}
		return p;
	}

	public static Node connect1(Node root) {
		if (root == null) {
			return root;
		}
		Queue<Node> Q = new LinkedList<Node>();
		Q.add(root);
		while (Q.size() > 0) {
			int size = Q.size();
			for (int i = 0; i < size; i++) {
				Node node = Q.poll();
				// 这里的节点都是一层中的节点
				if (i < size - 1) {
					node.next = Q.peek();
				}
				if (node.left != null) {
					Q.add(node.left);
				}
				if (node.right != null) {
					Q.add(node.right);
				}
			}
		}
		return root;
	}
}
