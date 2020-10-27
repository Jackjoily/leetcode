package JianZhiOffer;

import leetcode_list.ListNode;

/**
 * 输入一个链表，输出该链表中倒数第k个节点。 为了符合大多数人的习惯， 本题从1开始计数， 即链表的尾节点是倒数第1个节点。例如，一个链表有6个节点，
 * 从头节点开始，它们的值依次是1、2、3、4、5、6。 这个链表的倒数第3个节点是 值为4的节点。
 * 
 * @author jackjoily
 *
 */
public class JianZhiOffer22 {
	public ListNode getKthFromEnd(ListNode head, int k) {
		if (head == null)
			return head;
		if (k <= 0)
			return null;
		ListNode p = head, q = head;
		for (int i = 0; i < k - 1; i++) {
			q = q.next;
		}
		if (q.next == null)
			return p;
		while (q .next!= null) {
			q = q.next;
			p = p.next;
		}
		return p;

	}
}
