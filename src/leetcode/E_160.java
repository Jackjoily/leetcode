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
public class E_160 {
	public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
		if (headA == null || headB == null)
			return null;
		ListNode p = headA;
		ListNode q = headB;
		int n = 0;
		while (p.next != null) {
			n++;
		}
		while (q.next != null) {
			n--;
		}
		if (p != q)
			return null;
		p = headA;
		q = headB;
		if (n == 0) {
			while (p != q) {
				p = p.next;
				q = q.next;
			}
		} else if (n > 0) {
			for (int i = 0; i < n; i++) {
				p = p.next;
			}
			while (p != q) {
				p = p.next;
				q = q.next;
			}
		} else {
			for (int i = 0; i < n; i++) {
				q = q.next;
			}
			while (p != q) {
				p = p.next;
				q = q.next;
			}
		}
		return p;
	}
}
