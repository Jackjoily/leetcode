package leetcode_day;

import leetcode_list.ListNode;

public class M_19 {
	/**
	 * 给定一个链表，删除链表的倒数第 n 个节点，并且返回链表的头结点。
	 * 
	 * @param head
	 * @param n
	 * @return
	 */
	public static void main(String[] args) {
		ListNode create = ListNode.create(2);
		ListNode.print(removeNthFromEnd(create, 2));
	}

	public static ListNode removeNthFromEnd(ListNode head, int n) {
		if (head == null)
			return head;
		ListNode p = head, q = head;
		for (int i = 0; i < n - 1; i++) {
			q = q.next;
		}
		if (q.next != null) {
			while (q.next.next != null) {
				q = q.next;
				p = p.next;
			}
			p.next = p.next.next;
		} else {
			if (p == q) {
				return null;
			}
			return p.next;
		}
		return head;
	}
}
