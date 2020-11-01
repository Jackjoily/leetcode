package JianZhiOffer;

import java.util.HashMap;
import java.util.Map;

import leetcode_list.ListNode;

/**
 * 找出数组中重复的数字。
 * 
 * 
 * 给定单向链表的头指针和一个要删除的节点的值， 定义一个函数删除该节点。 返回删除后的链表的头节点。
 * 
 * @author jackjoily
 *
 */
public class JianZhiOffer18 {
	public static void main(String[] args) {
		JianZhiOffer18 j=new JianZhiOffer18();
		ListNode create = ListNode.create(3);
		ListNode.print(deleteNode(create,1));
	}

	public static ListNode deleteNode(ListNode head, int val) {
		if (head == null)
			return head;
		if (head.val == val)
			return head.next;
		ListNode p = head.next;
		ListNode q = head;
		while (p != null && p.val != val) {
			p = p.next;
			q = q.next;
		}
		q.next = q.next.next;
		return head;
	}
}
