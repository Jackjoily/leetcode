package leetcode_day;

import leetcode_list.ListNode;

public class M_147 {
	/**
	 * 
	 * 插入排序的动画演示如上。从第一个元素开始， 该链表可以被认为已经部分排序（用黑色表示）。 每次迭代时，从输入数据中移除一个元素（用红色表示），
	 * 并原地将其插入到已排好序的链表中。
	 * 
	 */
	public static void main(String[] args) {
		ListNode n4 = new ListNode(4);
		ListNode n3 = new ListNode(3);
     	ListNode n2 = new ListNode(2);
//		ListNode n3 = new ListNode(1);
		n3.next = n2;
		n2.next = n4;
//		n1.next = n3;
		ListNode insertionSortList = insertionSortList(n3);
		System.out.println(insertionSortList);
	}

	public static ListNode insertionSortList(ListNode head) {
		if (head == null)
			return head;
		ListNode p = head;
		ListNode r = head;
		ListNode pre = null;
		ListNode sorted = head;
		p = p.next;
		while (p != null) {
			ListNode q = p.next;
			if (sorted.val < p.val) {
				sorted.next=p;
				sorted=p;
				p = p.next;
			} else {
				while (r.val < p.val) {
					pre = r;
					r = r.next;
				}
				if (pre == null) {
					p.next = r;
					head = p;
				} else {
					pre.next = p;
					p.next = r;
				}
				pre = null;
				r = head;
				p = q;
			}
		}
		sorted.next=null;
		return head;
	}
}
