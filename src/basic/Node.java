package basic;

import java.util.List;

import leetcode_tree.TreeNode;

public class Node {
	public int val;
	public List<Node> children;
	public Node left;
	public Node right;
	public Node next;

	public Node() {
	}

	public Node(int _val) {
		val = _val;
	}

	public Node(int _val, List<Node> _children) {
		val = _val;
		children = _children;
	}

	public static void print(Node node) {
		 while(node!=null) {
 System.out.println(node.val);
			 node=node.left;
		 }
	}

	public static Node createTree(int n) {
		Node[] t = new Node[n];
		for (int i = 0; i < n; i++) {
			t[i] = new Node(i + 1);
		}
		for (int i = n / 2 - 1; i >= 0; i--) {
			t[i].left = t[2 * i + 1];
			if (i == (n / 2) - 1 && (2 * (i + 1) + 1) != n) {
				t[i].right = null;
			} else {
				t[i].right = t[2 * i + 2];
			}

		}
		return t[0];
	}
}