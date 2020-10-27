package leetcode_array;

import leetcode_list.ListNode;

/**
 * 给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。
 * 
 * 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
 * 
 * 您可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 * 
 * 来源：力扣（LeetCode） 链接：https://leetcode-cn.com/problems/add-two-numbers
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * 
 * @author jackjoily
 *
 */
public class M_2 {

	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		if (l1 == null) {
			return l2;
		}
		if (l2 == null) {
			return l1;
		}
		ListNode p = l1, q = l2;
		ListNode r = new ListNode();
		ListNode r2 = r;
		int i = 0, j = 0, k = 0, res = 0;
		while (p != null && q != null) {
			i = p.val;
			j = q.val;
			res = (i + j + k) % 10;
			k = (i + j + k) / 10;
			ListNode r1 = new ListNode();
			r.next = r1;
			r1.val = res;
			r = r1;
			p=p.next;
			q=q.next;
		}
		if (p == null && q == null) {
			return r2.next;
		} 
		else {
			if (p == null) {
				while (q != null) {
					i = q.val;
					res = (i + k) % 10;
					k = (i + k) / 10;
					ListNode r1 = new ListNode();
					r.next = r1;
					r1.val = res;
					r = r1;
					q=q.next;
				}
				if(k==1) {
					ListNode r1 = new ListNode();
					r.next = r1;
					r1.val = k;
				}
				return r2.next;
			} else {
				while (p != null) {
					i = p.val;
					res = (i + k) % 10;
					k = (i + k) / 10;
					ListNode r1 = new ListNode();
					r.next = r1;
					r1.val = res;
					r = r1;
					p=p.next;
				}
				if(k==1) {
					ListNode r1 = new ListNode();
					r.next = r1;
					r1.val = k;
				}
				return r2.next;
			}
		}
	}
}
