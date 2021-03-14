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
public class M_86 {
	public static void main(String[] args) {
		ListNode n1 = new ListNode(1);
		ListNode n4 = new ListNode(4);
		ListNode n3 = new ListNode(3);
		ListNode n2 = new ListNode(2);
		ListNode n5 = new ListNode(5);
		ListNode n21 = new ListNode(2);
		n1.next = n4;
		n4.next = n3;
		n3.next = n2;
		n2.next = n5;
		n5.next = n21;

		ListNode partition = partition(n1, 3);
		ListNode.print(partition);
	}

	public static ListNode partition(ListNode head, int x) {
		if (head == null)
			return head;
		ListNode p = new ListNode(999);
		ListNode p1 = p;
		ListNode q = new ListNode(-999);
		ListNode q1 = q;
		ListNode r = null;
		while (head != null) {
			r = head.next;
			if (head.val < x) {
				p.next = head;
				p = p.next;
			} else {
				q.next = head;
				q = q.next;
			}
			head = r;
		}
		if (p1.next == null) {
			return q1.next;
		} else if (q1.next == null) {
			return p1.next;
		} else {
			q.next = null;
			p.next = q1.next;
			return p1.next;
		}
	}
}
