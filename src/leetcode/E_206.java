package leetcode;

import java.util.Arrays;
import java.util.HashMap;

import com.sun.org.apache.xerces.internal.util.SynchronizedSymbolTable;

import leetcode_list.ListNode;

/**
 * twosum 你可以迭代或递归地反转链表。你能否用两种方法解决这道题？
 * 
 * @author jackjoily
 *
 */
public class E_206 {
	public static void main(String[] args) {
		ListNode create = ListNode.create(3);
		ListNode reverseList1 = reverseList1(create,create.next);
		reverseList1.next=null;
		ListNode.print(reverseList1);
	}

	public static ListNode reverseList(ListNode head) {
		if (head == null || head.next == null)
			return head;
		ListNode q = head;
		ListNode p = new ListNode();
		ListNode next = null;
		while (q != null) {
			next = q.next;
			q.next = p.next;
			p.next = q;
			q = next;
		}
		return p.next;
	}

	public static ListNode reverseList1(ListNode head, ListNode pre) {
		if (pre != null) {
			reverseList1(pre, pre.next);
			pre.next = head;
		}
		return pre;
	}
}
