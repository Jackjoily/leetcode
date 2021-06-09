package leetcode;

import java.util.Arrays;
import java.util.BitSet;
import java.util.HashMap;

import com.sun.org.apache.xerces.internal.util.SynchronizedSymbolTable;

import leetcode_list.ListNode;

/**
 * twosum
 * 
 * @author jackjoily
 *
 */
public class E_234 {
	public static void main(String[] args) {
		E_234 e = new E_234();
		ListNode create = ListNode.create(7);
		e.isPalindrome(create);
	}

	public boolean isPalindrome(ListNode head) {
		if (head == null || head.next == null)
			return false;
		ListNode pre;
		ListNode fast = head;
		ListNode slow = head;
		while (fast.next != null && fast.next.next != null) {
			fast = fast.next.next;
			slow = slow.next;
		}
		ListNode r = reverse(slow.next);
		while (head != null && r != null) {
			if (head.val != r.val) {
				return false;
			}
		}
		return true;
	}

	public ListNode reverse(ListNode head) {
		ListNode pre = null;
		while (head != null) {
			ListNode next = head.next;
			head.next = pre;
			pre = head;
			head = next;
		}
		return pre;
	}
}
