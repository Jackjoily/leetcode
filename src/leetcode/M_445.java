package leetcode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Stack;

import javafx.scene.shape.Line;
import leetcode_list.ListNode;
import leetcode_tree.TreeNode;

/**
 * 
 * @author jackjoily
 *
 */
public class M_445 {
	public static void main(String[] args) {
		ListNode create = ListNode.create(7);
		ListNode create1 = ListNode.create(3);
		M_445 m = new M_445();
		ListNode.print(		m.addTwoNumbers(create, create1));
	}

	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		Stack<Integer> s = new Stack<>();
		Stack<Integer> s1 = new Stack<>();
		while (l1 != null) {
			s.add(l1.val);
			l1 = l1.next;
		}
		while (l2 != null) {
			s1.add(l2.val);
			l2 = l2.next;
		}
		ListNode head = new ListNode();
		int sum = 0;
		int val = 0;
		while (!s.isEmpty() || !s1.isEmpty()) {
			int a = s.isEmpty() ? 0 : s.pop();
			int b = s1.isEmpty() ? 0 : s1.pop();
			sum = (a + b + val) % 10;
			val = (a + b + val) / 10;
			ListNode node = new ListNode(sum);
			node.next = head.next;
			head.next = node;
		}
	  if(val!=0) {
			ListNode node = new ListNode(val);
			node.next = head.next;
			head.next = node;
	  }
		return head.next;
	}
}
