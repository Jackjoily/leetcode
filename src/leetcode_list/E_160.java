package leetcode_list;

/**
 * 编写一个程序，找到两个单链表相交的起始节点。
 * 
 * @author jackjoily
 *
 */
public class E_160 {
	public static void main(String[] args) {
		ListNode n1 = new ListNode(1);
		ListNode n2 = new ListNode(2);
		ListNode n3 = new ListNode(3);
		ListNode n4 = new ListNode(4);
		ListNode n5 = new ListNode(5);
		n1.next = n2;
		n2.next = n3;
		n3.next = n4;
		n4.next = n5;
		ListNode n11 = new ListNode(1);
		n11.next = n4;
		ListNode.print(getIntersectionNode(n5, null));
	}

	public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
		int n = 0;
		int i = 0;
		ListNode p = headA, q = headB;
		if(p==null||q==null)return null;
		while (p.next != null) {
			p = p.next;
			n++;
		}
		while (q.next != null) {
			q = q.next;
			n--;
		}
		if (p != q)
			return null;
		if (p == null)
			return null;
		p = headA;
		q = headB;
		if (n == 0) {
			while (p != q) {
				p = p.next;
				q = q.next;
			}
			return p;
		} else if (n > 0) {
			while (i < n) {
				p = p.next;
				i++;
			}
			while (p != q) {
				p = p.next;
				q = q.next;
			}
			return p;
		} else {
			while (i > n) {
				q = q.next;
				i--;
			}
			while (p != q) {
				p = p.next;
				q = q.next;
			}
			return p;
		}
	}
}
