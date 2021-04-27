package leetcode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
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
public class M_147 {
	public static void main(String[] args) {
		ListNode create = ListNode.reverseCreate(7);
		ListNode.print(	insertionSortList(create));
	}

	public static ListNode insertionSortList(ListNode head) {
		if (head == null || head.next == null) {
			return head;
		}
		ListNode p = new ListNode();
		ListNode lastSorted = head;
		ListNode q = head.next;
		ListNode r = p;
		ListNode pre = null;
		p.next = head;
		while (q != null) {
			if (q.val >= lastSorted.val) {
				lastSorted.next = q;
				lastSorted = q;
			} else {
				r = p.next;
				pre = p;
				while (r != null) {
					if (r.val >= q.val) {
						ListNode n=new ListNode(q.val);
						n.next=r;
						pre.next = n;
						break;
					} else {
						pre = r;
						r = r.next;
					}
				}
			}
			q=q.next;
		}
		lastSorted.next=null;
		return p.next;
	}
}
