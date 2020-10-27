package leetcode_list;

/**
 * 反转一个单链表。
 * 
 * @author jackjoily
 *
 */
public class E_206 {
	public ListNode reverseList(ListNode head) {
		if (head == null) {
			return head;
		}
		ListNode p = head;
		ListNode r = new ListNode();
		while (p != null) {
			ListNode q = new ListNode();
			q.val = p.val;
			q.next = r.next;
			r.next = q;
			p = p.next;
		}
		return r.next;
	}

	/**
	 * 使用递归进行反转
	 * 
	 * @param head
	 * @return
	 */
	public ListNode reverseList1(ListNode head) {
		if (head == null || head.next == null) {
			return head;
		}
		// 遍历至倒数第二个节点
		ListNode p = reverseList1(head.next);
		/**
		 * 1->2->3->4->5 5->4->null
		 */
		head.next.next = head;
		head.next = null;
		return p;
	}
}
