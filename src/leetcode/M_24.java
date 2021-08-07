package leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

import leetcode_list.ListNode;

public class M_24 {
	public static void main(String[] args) {
		ListNode create = ListNode.create(8);
		ListNode.print(swapPairs(create));
	}

	public static ListNode swapPairs(ListNode head) {
		if (head == null || head.next == null)
			return head;
		ListNode p = head;
		ListNode pre = null;
		ListNode q = p.next;
		ListNode next = null;
		while (p != null) {
			next = p.next;
			if (next == null) {
				pre.next = p;
				p = null;
			} else {
				ListNode n = next.next;
				if (pre == null) {
					pre = p;
					next.next = p;
					p.next = null;
					p = n;
				} else {
					pre.next = next;
					pre = p;
					next.next = p;
					p.next = null;
					p = n;
				}
			}
		}
		return q;
	}
}
