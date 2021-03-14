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
public class M_328 {
	public static void main(String[] args) {
		ListNode create = ListNode.create(2);
		ListNode.print(oddEvenList(create));
	}

	public static ListNode oddEvenList(ListNode head) {
		if (head == null || head.next == null)
			return null;
		ListNode evenHead = null;
		evenHead = head.next;
		ListNode p = head;
		ListNode q = head.next;
		ListNode r = null;
		while ( p.next != null) {
			r = q.next;
			if (r == null) {
				break;
			}
			p.next = r;
			p = r;
			q.next = p == null ? null : p.next;
			q = p == null ? null : p.next;
		}
		p.next = evenHead;
		return head;
	}
}
