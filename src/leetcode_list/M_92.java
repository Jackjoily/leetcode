package leetcode_list;

import leetcode_tree.TreeNode;

/**
 * 反转从位置 m 到 n 的链表。请使用一趟扫描完成反转。 1 ≤ m ≤ n ≤ 链表长度。
 */
public class M_92 {
	public static void main(String[] args) {
		ListNode create = ListNode.create(5);
		ListNode.print(create);
		ListNode reverseBetween = reverseBetween(create, 2, 3);
		ListNode.print(reverseBetween);
	}

	public static ListNode reverseBetween(ListNode head, int m, int n) {
		if (head == null)
			return head;
		if (m == n)
			return head;
		ListNode pre = null, next = null, p = head;
		ListNode ph = null, phpre = null, pt = null, pttail = null;
		int i = 1;
		while (p != null) {
			next = p.next;
			if (i == m - 1)
				phpre = p;
			if (i == m)
				ph = p;
			if (i == n)
				pt = p;
			if (i == n + 1)
				pttail = p;
			if (i >= m && i <= n) {
				p.next = pre;
			}
			pre = p;
			p = next;
			i++;
		}
		if (phpre == null && pttail == null) {
			return pt;
		} else if (phpre != null && pttail != null) {
			phpre.next = pt;
			ph.next = pttail;
			return head;
		} else if (phpre == null) {
			ph.next = pttail;
			return pt;
		} else {
			ph.next = null;
			phpre.next = pt;
			return head;
		}
	}
}
