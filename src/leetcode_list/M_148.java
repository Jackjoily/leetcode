package leetcode_list;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import leetcode_tree.TreeNode;

/**
 * 给你链表的头结点 head ，请将其按 升序排列并返回 排序后的链表 。
 */
public class M_148 {
	public static void main(String[] args) {
		ListNode n4 = new ListNode(4);
		ListNode n2 = new ListNode(2);
		ListNode n1 = new ListNode(1);
		ListNode n3 = new ListNode(3);
		n4.next = n2;
		n2.next = n1;
		n1.next = n3;
		ListNode.print(n4);
		ListNode.print(sortList(n4));
	}

	public static ListNode sortList(ListNode head) {
		if (head == null || head.next == null)
			return head;
		List<ListNode> list = new ArrayList<>();
		ListNode p = head;
		while (p != null) {
			list.add(p);
			p = p.next;
		}
		Collections.sort(list, new Comparator<ListNode>() {
			@Override
			public int compare(ListNode o1, ListNode o2) {
				return o1.val - o2.val;
			}
		});
		ListNode n=new ListNode(0);
		p = n;
		for (int i = 0; i < list.size(); i++) {
			p.next = list.get(i);
			p = p.next;
		}
		p.next = null;
		return n.next;
	}
}
