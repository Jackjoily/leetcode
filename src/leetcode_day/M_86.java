package leetcode_day;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import leetcode_list.ListNode;
import leetcode_tree.TreeNode;
import leetcode_tree.TreeUtils;

public class M_86 {
	/**
	 * 
	 * 
	 * 给你一个链表和一个特定值 x ，请你对链表进行分隔，使得所有小于 x 的节点都出现在大于或等于 x 的节点之前。
	 * 你应当保留两个分区中每个节点的初始相对位置。
	 * 
	 */
	public static void main(String[] args) {
		ListNode n1 = new ListNode(1);
		ListNode n4 = new ListNode(4);
		ListNode n3 = new ListNode(3);
		ListNode n2 = new ListNode(2);
		ListNode n5 = new ListNode(5);
		ListNode n21 = new ListNode(2);
		n1.next = n4;
		n4.next = n3;
		n3.next = n2;
		n2.next = n5;
		n5.next = n21;
//		ListNode.print(n1);
		ListNode.print(partition1(n1, 3));
	}

	public static ListNode partition(ListNode head, int x) {
		if (head == null)
			return head;
		ListNode p = head;
		List<ListNode> list = new ArrayList<>();
		while (p != null) {
			list.add(p);
			p = p.next;
		}
		List<ListNode> list1 = new ArrayList<>();
		List<ListNode> list2 = new ArrayList<>();
		for (int i = 0; i < list.size(); i++) {
			ListNode listNode = list.get(i);
			if (listNode.val < x) {
				list1.add(listNode);
			} else {
				list2.add(listNode);
			}
		}
		if (list1.size() > 0 && list2.size() > 0) {
			int j = 0;
			while (j < list1.size() - 1) {
				list1.get(j).next = list1.get(j + 1);
				j++;
			}
			list1.get(j).next = list2.get(0);
			int k = 0;
			while (k < list2.size() - 1) {
				list2.get(k).next = list2.get(k + 1);
				k++;
			}
			list2.get(k).next = null;
			return list1.get(0);
		} else if (list1.size() == 0) {
			int k = 0;
			while (k < list2.size() - 1) {
				list2.get(k).next = list2.get(k + 1);
				k++;
			}
			list2.get(k).next = null;
			return list2.get(0);
		} else if (list2.size() == 0) {
			int k = 0;
			while (k < list1.size() - 1) {
				list1.get(k).next = list1.get(k + 1);
				k++;
			}
			list1.get(k).next = null;
			return list1.get(0);
		}
		return p;
	}

	public static ListNode partition1(ListNode head, int x) {
		ListNode p = new ListNode(999);
		ListNode p1 = p;
		ListNode q = new ListNode(999);
		ListNode q1 = q;
		while (head != null) {
			if (head.val < x) {
				p.next = head;
				p = p.next;
			} else {
				q.next = head;
				q = q.next;
			}
			head = head.next;
		}
		if (p.val != 999 && q.val != 999) {
			p.next = q1.next;
			q.next=null;
			return p1.next;
		} else if (p.val == 999) {
			q.next = null;
			return q1.next;
		} else {
			p.next=null;
			return p1.next;
		}
	}
}
