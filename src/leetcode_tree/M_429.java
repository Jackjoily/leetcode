package leetcode_tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import basic.Node;

public class M_429 {
	public static void main(String[] args) {
		Node node = new Node(1);
		Node node3 = new Node(3);
		Node node2 = new Node(2);
		Node node4 = new Node(4);
		Node node5 = new Node(5);
		Node node6 = new Node(6);
		List<Node> childrenList = new ArrayList<>();
		childrenList.add(node3);
		childrenList.add(node2);
		childrenList.add(node4);
		node.children = childrenList;
		childrenList = new ArrayList<>();
		childrenList.add(node5);
		childrenList.add(node6);
		node3.children = childrenList;
		System.out.println(levelOrder1(node));
	}

	public static List<List<Integer>> levelOrder1(Node root) {
		List<List<Integer>> list = new ArrayList<>();
		if (root == null)
			return list;
		Queue<Node> q = new LinkedList<>();
		q.add(root);
		List<Integer> list1 = new ArrayList<Integer>();
		while (q.size() > 0) {
			for (int j = q.size() - 1; j >= 0; j--) {
				root = q.poll();
				list1.add(root.val);
				if (root.children != null) {
					for (int k = 0; k < root.children.size(); k++) {
						q.add(root.children.get(k));
					}
				}
			}
			list.add(list1);
			list1 = new ArrayList<Integer>();
		}
		return list;
	}

	public static List<List<Integer>> levelOrder(Node root) {
		List<List<Integer>> list = new ArrayList<>();
		if (root == null)
			return list;
		Queue<Node> queue = new LinkedList<>();
		int front = -1, rear = -1;
		int last = 0;
		queue.add(root);
		rear++;
		List<Integer> list1 = new ArrayList<>();
		while (front < rear) {
			Node p = queue.poll();
			++front;
			List<Node> childrenList = p.children;
			if (childrenList != null && childrenList.size() != 0) {
				for (Node node : childrenList) {
					if (node != null) {
						queue.add(node);
						rear++;
					}
				}
			}
			list1.add(p.val);
			if (front == last) {
				last = rear;
				list.add(list1);
				list1 = new ArrayList<>();
			}
		}
		return list;

	}
}
