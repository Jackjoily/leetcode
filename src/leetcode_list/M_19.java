package leetcode_list;

public class M_19 {
	public ListNode removeNthFromEnd(ListNode head, int n) {
		if (head == null)
			return head;
		ListNode p = head;
		ListNode q = head;
		ListNode k = head;
		for (int i = 0; i < n - 1; i++) {
			q = q.next;
		}
		int m = 0;
		if (q != null) {
			while (q.next != null) {
				p = p.next;
				q = q.next;
				m++;
			}
			if (m == 0) {
				return p.next;
			}
			for (int l = 0; l < m - 1; l++) {
				k = k.next;
			}
			k.next = k.next.next;
			return head;
		} else {
			return q;
		}
	}
}
