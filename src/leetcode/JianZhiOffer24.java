package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import com.sun.org.apache.xerces.internal.util.SynchronizedSymbolTable;

import leetcode_list.ListNode;

/**
 * twosum
 * 
 * @author jackjoily
 *
 */
public class JianZhiOffer24 {
  public static void main(String[] args) {
	
	  ListNode create = ListNode.create(7);
	  ListNode.print(reverseList(create));
}
	public static ListNode reverseList(ListNode head) {
		if (head == null)
			return head;
		ListNode pre = null;
		ListNode next = null;
		ListNode p = head;
		while (p != null) {
			next = p.next;
			p.next = pre;
			pre = p;
			p = next;
		}
		return pre;
	}

}
