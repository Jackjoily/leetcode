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
public class E_141 {
	public static void main(String[] args) {
	}

	public boolean hasCycle(ListNode head) {
		if (head == null || head.next == null)
			return false;
		ListNode fast = head.next;
		ListNode slow = head;
		while (fast != null) {
			fast = fast.next == null ? null : fast.next.next;
			slow = slow.next;
			if (fast == null)
				return false;
			if (fast == slow)
				return true;
		}
		return false;
	}
}
