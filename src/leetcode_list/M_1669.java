package leetcode_list;

/**
 * 给你两个链表 list1 和 list2 ，它们包含的元素分别为 n 个和 m 个。
 * 
 * 请你将 list1 中第 a 个节点到第 b 个节点删除，并将list2 接在被删除节点的位置。
 *
 * 
 */
public class M_1669 {
	public static void main(String[] args) {
		ListNode list1 = ListNode.create(6);
		ListNode list2 = ListNode.create(3);
		ListNode.print(mergeInBetween(list1,1,1,list2));
	}

	public static ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) {
		ListNode la = null, lb = null;
		ListNode p = list1;
		int i = 0;
		while (p != null) {
			if (i == a - 1) {
				la = p;
			}
			if (i == b - 1) {
				lb = p;
			}
			p = p.next;
			i++;
		}
		p = list2;
		while (p.next != null) {
			p = p.next;
		}
		ListNode next = lb.next.next;
		la.next = list2;
		if (next == null) {
			return list1;
		} else {
			p.next = next;
			return list1;
		}
	}
}
