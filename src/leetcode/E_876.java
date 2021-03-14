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
public class E_876 {

	public ListNode middleNode(ListNode head) {
		if (head == null || head.next == null) {
			return head;
		}
		ListNode fast = head;
		ListNode slow = head.next;
		while (fast != null || fast.next != null) {
			fast = fast.next.next;
			slow = slow.next;
		}
		return slow;
	}
}
