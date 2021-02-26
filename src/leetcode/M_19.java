package leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

import leetcode_list.ListNode;

/**
 * 给你一个链表，删除链表的倒数第 n 个结点，并且返回链表的头结点。
 * 
 * 进阶：你能尝试使用一趟扫描实现吗？
 * 
 * @author jackjoily
 *
 */
public class M_19 {
	public ListNode removeNthFromEnd(ListNode head, int n) {
		ListNode p = head, q = head;
		ListNode pre = null;
		for (int i = 0; i < n - 1; i++) {
			p = p.next;
		}
		if (p.next == null)
			return q.next;
		while (p.next != null) {
			pre = q;
			p = p.next;
			q = q.next;
		}
		pre.next = q.next;
		return head;
	}

}
