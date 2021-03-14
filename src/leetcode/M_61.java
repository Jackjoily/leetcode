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
public class M_61 {
	public static void main(String[] args) {
		ListNode create = ListNode.create(2);
		ListNode.print(	rotateRight(create, 2));
	}

	public static ListNode rotateRight(ListNode head, int k) {
		if (head == null || head.next == null)
			return head;
		ListNode p = head;
		ListNode q = head;
		int count = 0;
		while (p.next != null) {
			count++;
			p=p.next;
		}
		count++;
		k = k % count;
		if (k == 0)
			return head;
		for (int i = 0; i < count - k - 1; i++) {
			q = q.next;
		}
		ListNode s = q.next;
		q.next=null;
		p.next = head;
		return s;
	}
}
