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
		ListNode create = ListNode.create(7);
		ListNode oddEvenList = oddEvenList(create);
		ListNode.print(oddEvenList);
	}

	public static ListNode oddEvenList(ListNode head) {
		if (head == null || head.next == null)
			return head;
		ListNode odd = head;
		ListNode even = head.next;
		ListNode p = odd;
		ListNode q = even;
		while (p != null && q != null) {
			if (q.next == null) {
				break;
			}
			p.next = q.next;
			p = q.next;
			if (p == null) {
				q.next = null;
				q = null;
			} else {
				q.next = p.next;
				q = p.next;
			}
		}
		p.next = even;
		return odd;
	}
}
