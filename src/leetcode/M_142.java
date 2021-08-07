package leetcode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Queue;

import javafx.scene.shape.Line;
import leetcode_list.ListNode;
import leetcode_tree.TreeNode;

/**
 * 
 * @author jackjoily
 *
 */
public class M_142 {
	public static void main(String[] args) {
		ListNode n = new ListNode(3);
		ListNode n1 = new ListNode(2);
		ListNode n2 = new ListNode(0);
		ListNode n3 = new ListNode(-4);
		n.next = n1;
		n1.next = n2;
		n2.next = n3;
		n3.next = n1;

		detectCycle(n);
	}

	public static ListNode detectCycle(ListNode head) {
		if (head == null || head.next == null)
			return null;
		ListNode fast = head;
		ListNode slow = head;
		while (fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
			if (fast == null)
				return fast;
			if (fast == slow) {
             ListNode p=head;
             while(p!=fast) {
            	 p=p.next;
            	 fast=fast.next;
             }
             return p.next;
			}

		}
		return null;
	}
}
