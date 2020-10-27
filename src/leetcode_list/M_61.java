package leetcode_list;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个链表，旋转链表，将链表每个节点向右移动 k 个位置，其中 k 是非负数。
 * 
 * @author jackjoily
 *
 */
public class M_61 {
	public static void main(String[] args) {
		M_61 m = new M_61();
		ListNode rotateRight = m.rotateRight(ListNode.create(3), 2000000000);
		ListNode.print(rotateRight);
	}

	public ListNode rotateRight(ListNode head, int k) {
		if (head == null)
			return head;
		ListNode tail, p;
		tail = head;
		List<Integer> list = new ArrayList<>();
		while (tail != null) {
			list.add(tail.val);
			tail = tail.next;
		}
		int a[] = new int[list.size()];
		for (int n = 0; n < list.size(); n++) {
			a[n] = list.get(n);
		}
		for (int i = 0; i < k; i++) {
			int temp = a[a.length - 1];
			for (int j = a.length - 1; j >= 1; j--) {
				a[j] = a[j - 1];
			}
			a[0] = temp;
		}
		tail = head;
		int m = 0;
		while (tail != null) {
			tail.val = a[m];
			tail = tail.next;
			m++;
		}
		return head;
	}

	public ListNode rotateRight1(ListNode head, int k) {
		  // base cases
	    if (head == null) return null;
	    if (head.next == null) return head;

	    // close the linked list into the ring
	    ListNode old_tail = head;
	    int n;
	    for(n = 1; old_tail.next != null; n++)
	      old_tail = old_tail.next;
	    old_tail.next = head;

	    // find new tail : (n - k % n - 1)th node
	    // and new head : (n - k % n)th node
	    ListNode new_tail = head;
	    for (int i = 0; i < n - k % n - 1; i++)
	      new_tail = new_tail.next;
	    ListNode new_head = new_tail.next;
	    // break the ring
	    new_tail.next = null;

	    return new_head;

	}

}
