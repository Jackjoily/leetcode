package JianZhiOffer;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

import basic.Node;

/**
 * 找出数组中重复的数字。
 * 
 * 
 * 输入一棵二叉搜索树，将该二叉搜索树转换成一个排序的循环双向链表。 要求不能创建任何新的节点，只能调整树中节点指针的指向。
 * 
 * 
 * @author jackjoily
 *
 */
public class JianZhiOffer36 {
	public static void main(String[] args) {
		JianZhiOffer36 j = new JianZhiOffer36();
		Node n5 = new Node(5);
		Node n4 = new Node(4);
		Node n2 = new Node(2);
		Node n1 = new Node(1);
		Node n3 = new Node(3);
		n4.left = n2;
		n4.right = n5;
		n2.left = n1;
		n2.right = n3;
		j.treeToDoublyList(n4);
	}

	Node head, pre;

	public Node treeToDoublyList(Node root) {
		if (root == null)
			return root;
		inorder(root);
		head.left=pre;
		pre.right=head;
		return head;
	}

	public void inorder(Node root) {
		Stack<Node> stack = new Stack<>();
		while (stack.size() > 0 || root != null) {
			if (root != null) {
				stack.add(root);
				root = root.left;
			} else {
				root = stack.pop();
				System.out.println(root.val);
				if (pre != null) {
					pre.right = root;
					root.left = pre;
					pre = root;
				} else {
					head = root;
					pre = root;
				}
				if (root.right != null) {
					root = root.right;
				} else {
					root = null;
				}
			}
		}
	}
}
