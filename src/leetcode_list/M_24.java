package leetcode_list;

/**
 * 
 * 给定一个链表，两两交换其中相邻的节点，并返回交换后的链表。
 * 
 * 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
 * 
 * @author jackjoily
 *
 */
public class M_24 {
	public static void main(String[] args) {
		ListNode create = ListNode.create(1);
		ListNode.print(create);
		ListNode swapPairs = swapPairs(create);
		ListNode.print(swapPairs);
	}

	public static ListNode swapPairs(ListNode head) {
		ListNode p = head;
		if (p == null) {
			return p;
		}
		ListNode q = p.next;
		ListNode l = q;
		ListNode pre = null;
		if (q == null) {
			return p;
		}
		while (true) {
			ListNode m = q.next;
			q.next = p;
			pre = p;
			if (m != null) {
				p = m;
				q = m.next;
				if (q == null) {
					pre.next = p;
					break;
				} else {
					pre.next = q;
				}
			} else {
				pre.next = null;
				break;
			}

		}
		return l;
	}
}
