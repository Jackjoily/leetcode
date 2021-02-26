package leetcode_list;

/**
 * 将两个升序链表合并为一个新的 升序 链表并返回。 新链表是通过拼接给定的两个链表的所有节点组成的。
 * 
 * @author jackjoily
 *
 */
public class E_21 {
	public static void main(String[] args) {
		ListNode l1 = ListNode.create(7);
		ListNode l2 = ListNode.create(5);
		ListNode n1 = new ListNode(2);
		ListNode n2 = new ListNode(3);
		ListNode mergeTwoLists = mergeTwoLists(n1, null);
		ListNode.print(mergeTwoLists);
	}

	public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
		if (l1 == null)
			return l2;
		if (l2 == null)
			return l1;
		ListNode p = l1;
		ListNode q = l2;
		ListNode head = new ListNode(0);
		ListNode h = head;
		while (p != null && q != null) {
			if (p.val < q.val) {
				head.next = p;
				head = p;
				p = p.next;
			} else {
				head.next = q;
				head = q;
				q = q.next;
			}
		}
		if (p != null) {
			head.next = p;
		} else {
			head.next = q;
		}
		return h.next;
	}
}
