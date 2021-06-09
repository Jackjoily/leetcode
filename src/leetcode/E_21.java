package leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Stack;

import com.sun.org.apache.xerces.internal.util.SynchronizedSymbolTable;

import leetcode_list.ListNode;

/**
 * twosum
 * 
 * @author jackjoily
 *
 */
public class E_21 {
	public static void main(String[] args) {
	}

	public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
		if (l1 == null)
			return l2;
		if (l2 == null)
			return l1;
		ListNode l3 = new ListNode();
		ListNode r = l3;
		while (l1 != null && l2 != null) {
			if (l1.val > l2.val) {
				l3.next = l2;
				l2 = l2.next;
			} else {
				l3.next = l1;
				l1 = l1.next;
			}
			l3 = l3.next;
		}
		while (l1 != null) {
			l3.next = l1;
			l1 = l1.next;
			l3 = l3.next;
		}
		while (l2 != null) {
			l3.next = l2;
			l2 = l2.next;
			l3 = l3.next;
		}
		return r.next;
	}
}
