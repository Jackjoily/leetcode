package leetcode;

import java.util.Arrays;
import java.util.HashMap;

import com.sun.org.apache.xerces.internal.util.SynchronizedSymbolTable;

import leetcode_list.ListNode;

/**
 * twosum
 * 
 * @author jackjoily
 *
 */
public class E_83 {
	public static void main(String[] args) {
		ListNode create = ListNode.create(5);
		ListNode n5 = new ListNode(1);
		n5.next = create.next;
		create.next = n5;
		ListNode.print(deleteDuplicates(create));
	}

	public static ListNode deleteDuplicates(ListNode head) {
		if (head == null || head.next == null)
			return head;
		ListNode p = head;
		ListNode q = head.next;
		while (q != null) {
			while (q != null && q.val == p.val) {
				q = q.next;
			}
			if (q == null) {
				p.next = null;
			} else {
				ListNode next = q.next;
				p.next = q;
				p = q;
				q = next;
			}
		}
		return head;
	}
}
