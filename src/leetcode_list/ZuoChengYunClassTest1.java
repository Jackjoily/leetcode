package leetcode_list;

/**
 * 给定一个链表，给定一个val，将链表中的值分为<val =val >val三部分 返回新链表的头
 * 
 * @author jackjoily
 *
 */
public class ZuoChengYunClassTest1 {
	public static void main(String[] args) {
		ListNode n4 = new ListNode(4);
		ListNode n2 = new ListNode(2);
		ListNode n3 = new ListNode(3);
		ListNode n7 = new ListNode(7);
		ListNode n5 = new ListNode(5);
		ListNode n1 = new ListNode(1);
		ListNode n0 = new ListNode(0);
		n4.next = n2;
		n2.next = n3;
		n3.next = n7;
		n7.next = n5;
		n5.next = n1;
		n1.next = n0;
		ListNode.print(n4);
		ListNode sortListNodeWithVal = sortListNodeWithVal(n4, 10);
		ListNode.print(sortListNodeWithVal);
	}

	public static ListNode sortListNodeWithVal(ListNode root, int k) {
		if (root == null)
			return root;
		ListNode sh = null, st = null, eh = null, et = null, bh = null, bt = null;
		ListNode p = root;
		ListNode q = null;
		while (p != null) {
			q = p.next;
			if (p.val < k) {
				if (sh == null) {
					sh = p;
					st = p;
				} else {
					st.next = p;
					st = p;
				}
			} else if (p.val == k) {
				if (eh == null) {
					eh = p;
					et = p;
				} else {
					et.next = p;
					et = p;
				}
			} else {
				if (bh == null) {
					bh = p;
					bt = p;
				} else {
					bt.next = p;
					bt = p;
				}
			}
			p.next = null;
			p = q;
		}

		// 连接小于区域的头
		if (st != null) {
			st.next = eh;
			et = et == null ? st : et;
		}
		if (et != null) {
			et.next = bh;
		}
		return sh != null ? sh : (eh != null ? eh : bh);
	}
}
