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
public class M_82 {
	public static void main(String[] args) {
		ListNode create = ListNode.create(5);
		ListNode n1 = new ListNode(1);
		ListNode n2 = new ListNode(2);
		ListNode n3 = new ListNode(2);
		ListNode n4 = new ListNode(2);
		ListNode n5 = new ListNode(3);
		n1.next = n2;
		n2.next = n3;
		n3.next = n4;
		 n4.next = n5;
		ListNode.print(deleteDuplicates(n1));
	}

	public static ListNode deleteDuplicates(ListNode head) {
		if (head == null || head.next == null)
			return head;
		ListNode p = head;
		ListNode q = head.next;
		ListNode l = new ListNode();
		ListNode l1 = l;
		while (q != null) {
			while (q != null && q.val == p.val) {
				q = q.next;
			}
			if (q != p.next) {
				p = q;
			} else {
				l.next = p;
				l = p;
				l.next = null;
				p = q;
			}
		}
		return l1.next;
	}
}
