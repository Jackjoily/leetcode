package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Stack;

import com.sun.org.apache.xerces.internal.util.SynchronizedSymbolTable;

import basic.Node;

/**
 * twosum
 * 
 * @author jackjoily
 *
 */
public class JianZhiOffer36 {
	public static void main(String[] args) {
		JianZhiOffer36 j = new JianZhiOffer36();
		Node createTree = Node.createTree(5);
		Node treeToDoublyList = j.treeToDoublyList(createTree);
		Node.print(treeToDoublyList);
	}

	public Node treeToDoublyList(Node root) {
		if (root == null)
			return root;
		Node pre = new Node(-1);
		Node head = pre;
		Node tail = null;
		Stack<Node> s = new Stack<>();
		while (!s.isEmpty() || root != null) {
			if (root != null) {
				s.add(root);
				root = root.left;
			} else {
				root = s.pop();
				tail = root;
				pre.right = root;
				root.left = pre;
				pre=root;
				root = root.right;
			}
		}
		tail.right = head.right;
		head.right.left = tail;
		Node node = head.right;
		head.left = null;
		return node;
	}
}