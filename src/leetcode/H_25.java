package leetcode;

import java.util.Arrays;
import java.util.HashMap;

import leetcode_list.ListNode;

/**
 * twosum
 * 
 * @author jackjoily
 *
 */
public class H_25 {
	public static void main(String[] args) {
		ListNode create = ListNode.create(7);
		ListNode.print(reverseKGroup(create, 3));
	}

	public static ListNode reverseKGroup(ListNode head, int k) {
		if (head.next == null)
			return head;
		ListNode dummy = new ListNode(1000);
		dummy.next = head;
		ListNode pre = dummy;
		ListNode end = dummy;
		while (end != null) {
			for (int i = 0; i < k && end != null; i++) {
				end = end.next;
			}
			if (end == null)
				break;
			ListNode start = pre.next;
			ListNode next = end.next;
			end.next = null;
			pre.next = reverse(start);
			start.next = next;
			pre = start;
			end = pre;
		}
		return dummy.next;
	}

	public static ListNode reverse(ListNode head) {
		ListNode p = head;
		ListNode pre = null;
		while (p != null) {
			ListNode next = p.next;
			p.next = pre;
			pre = p;
			p = next;
		}
		return pre;
	}
}
