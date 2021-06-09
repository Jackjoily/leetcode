package leetcode;

import java.util.Arrays;
import java.util.HashMap;

import leetcode_list.ListNode;

/**
 * twosum
 * 
 * @author jackjoily
 *
 */
public class H_23 {
	public static void main(String[] args) {
		H_23 h = new H_23();
		ListNode create = ListNode.create(5);
		ListNode create1 = ListNode.create(7);
		ListNode[] a = new ListNode[2];
		a[0] = create;
		a[1] = create1;
		ListNode mergeKLists = h.mergeKLists(a);
		ListNode.print(mergeKLists);
	}

	public ListNode mergeKLists(ListNode[] lists) {
		if (lists.length == 0)
			return null;
		return mergeList(lists, 0, lists.length - 1);
	}

	public ListNode mergeList(ListNode[] lists, int l, int h) {
		if (l == h)
			return lists[l];
		if (l > h)
			return null;
		int mid = (l + h)/2;
		ListNode mergeList = mergeList(lists, l, mid);
		ListNode mergeList2 = mergeList(lists, mid + 1, h);
		return merge(mergeList, mergeList2);
	}

	public ListNode merge(ListNode a, ListNode b) {
		if (a == null || b == null) {
			return a != null ? a : b;

		}
		ListNode head = new ListNode(0);
		ListNode tail = head, aPtr = a, bPtr = b;
		while (aPtr != null && bPtr != null) {
			if (aPtr.val < bPtr.val) {
				tail.next = aPtr;
				aPtr = aPtr.next;
			} else {
				tail.next = bPtr;
				bPtr = bPtr.next;
			}
			tail = tail.next;
		}
		tail.next = (aPtr == null ? bPtr : aPtr);
		return head.next;
	}
}
