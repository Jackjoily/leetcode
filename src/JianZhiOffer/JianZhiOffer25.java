package JianZhiOffer;

import leetcode_list.ListNode;

/**
 * 找出数组中重复的数字。
 * 
 * 输入两个递增排序的链表， 合并这两个链表并使新链表中的节点仍然是递增排序的。
 * 
 * @author jackjoily
 *
 */
public class JianZhiOffer25 {
	public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
		if (l1 == null)
			return l2;
		if (l2 == null)
			return l1;
		ListNode p = l1;
		ListNode q = l2;
		ListNode r = new ListNode();
		ListNode r1 = r;
		while (p != null && q != null) {
			if (p.val > q.val) {
				r.next = new ListNode(q.val);
				r = r.next;
				q = q.next;
			} else {
				r.next = new ListNode(p.val);
				r = r.next;
				p = p.next;
			}
		}
		if (p == null) {
			while (q != null) {
				r.next = new ListNode(q.val);
				r = r.next;
				q = q.next;
			}
		} else {
			while (p != null) {
		
			r.next = new ListNode(p.val);
			r = r.next;
			p = p.next;
			}
		}
		return r1.next;
	}
}
