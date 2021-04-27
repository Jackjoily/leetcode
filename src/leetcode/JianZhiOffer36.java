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
		Node createTree = Node.createTree(7);
		treeToDoublyList(createTree);
	}

	public static Node treeToDoublyList(Node root) {
		if (root == null)
			return null;
		Node head = null;
		Node pre = null;
		Stack<Node> s = new Stack<>();
		while (!s.isEmpty() || root != null) {
			if (root != null) {
				s.add(root);
				root = root.left;
			} else {
				root = s.pop();
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
		head.left = pre;
		pre.right = head;
		return head;
	}

}