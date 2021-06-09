package newcoder;

import java.util.Stack;

import leetcode_list.ListNode;

public class NC40 {
	public static void main(String[] args) {
	}

	public ListNode addInList(ListNode head1, ListNode head2) {
		if (head1 == null)
			return head2;
		if (head2 == null)
			return head1;
		Stack<Integer> s = new Stack<>();
		Stack<Integer> s1 = new Stack<>();
		ListNode p = head1;
		ListNode q = head2;
		while (p != null) {
			s.add(p.val);
			p = p.next;
		}
		while (q != null) {
			s1.add(q.val);
			q = q.next;
		}
		int val = 0;
		int sum = 0;
		ListNode node = new ListNode();
		while (!s.isEmpty() && !s1.isEmpty()) {
			int a = s.pop();
			int b = s1.pop();
			sum = (a + b + val) % 10;
			val = (a + b + val) / 10;
			ListNode next = new ListNode(sum);
			next.next = node.next;
			node.next = next;
		}
		while (!s.isEmpty()) {
			int a = s.pop();
			sum = (a + val) % 10;
			val = (a + val) / 10;
			ListNode next = new ListNode(sum);
			next.next = node.next;
			node.next = next;
		}
		while (!s1.isEmpty()) {
			int a = s1.pop();
			sum = (a + val) % 10;
			val = (a + val) / 10;
			ListNode next = new ListNode(sum);
			next.next = node.next;
			node.next = next;
		}
		if (val != 0) {
			ListNode next = new ListNode(val);
			next.next = node.next;
			node.next = next;
		}
		return node;
	}
}
