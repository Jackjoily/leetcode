package leetcode_day;

import java.util.ArrayList;
import java.util.List;

import leetcode_list.ListNode;

public class M_328 {
	public static void main(String[] args) {
		ListNode create = ListNode.create(3);
		ListNode oddEvenList = oddEvenList(create);
		System.out.println(oddEvenList);
	}

	public static ListNode oddEvenList(ListNode head) {
		if (head == null||head.next==null||head.next.next==null)
			return head;
		ListNode p = head;
		ListNode k = head.next;
		ListNode temp = null, temp1 = null;
		while (p.next != null && p.next.next != null) {
			ListNode q = p.next;
			temp = p.next.next;
			temp1 = q.next.next;
			p.next = temp;
			p = temp;
			q.next = temp1;
			q = temp1;
		}
		temp.next = k;
		return head;
	}
}
