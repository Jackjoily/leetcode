package leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

import leetcode_list.ListNode;

public class M_24 {
	public static void main(String[] args) {
		ListNode create = ListNode.create(1);
		ListNode.print(swapPairs(create));
	}

	public static ListNode swapPairs(ListNode head) {
		if (head == null || head.next == null)
			return head;
		ListNode p = head;
		ListNode q = head.next;
		ListNode head1 = q;
		ListNode r = null;
		ListNode pre = new ListNode();
		while (q != null) {
			pre.next = q;
			r = q.next;
			pre = p;
			q.next = p;
			p.next = r;
			p = r;
			q = r == null ? null : r.next;
		}
		return head1;
	}
}
