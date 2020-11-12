package JianZhiOffer;

import java.util.HashMap;
import java.util.Map;

import leetcode_list.ListNode;

/**
 * 
 * 输入两个链表，找出它们的第一个公共节点。
 * 
 * @author jackjoily
 *
 */
public class JianZhiOffer52 {
	public static void main(String[] args) {
		JianZhiOffer52 j = new JianZhiOffer52();
	}

	public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
		ListNode p = headA;
		ListNode q = headB;
		if (p == null || q == null) {
			return p == null ? p : q;
		}
		while (p != null && q != null) {
			p = p.next;
			q = q.next;
		}
		int k = 0;
		ListNode p1 = headA;
		ListNode q1 = headB;
		if (p == null) {
			while (q != null) {
				q = q.next;
				k++;
			}
			for (int i = 0; i < k; i++) {
				q1 = q1.next;
			}
		} else {
			while (p != null) {
				p = p.next;
				k++;
			}
			for (int i = 0; i < k; i++) {
				p1 = p1.next;
			}
		}

		while (p1 != null && q1 != null) {
			if (p1 == q1)
				return p1;
			p1 = p1.next;
			q1 = q1.next;
		}
		return null;

	}
}
