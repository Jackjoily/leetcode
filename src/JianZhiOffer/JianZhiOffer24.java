package JianZhiOffer;

import java.util.HashMap;
import java.util.Map;

import leetcode_list.ListNode;

/**
 * 
 * 定义一个函数，输入一个链表的头节点， 反转该链表并输出反转后链表的头节点。
 * 
 * @author jackjoily
 *
 */
public class JianZhiOffer24 {
	public static void main(String[] args) {
		ListNode create = ListNode.create(5);
		JianZhiOffer24 j = new JianZhiOffer24();
		ListNode reverseList = j.reverseList(create);
		ListNode.print(reverseList);
	}

	public ListNode reverseList(ListNode head) {
		if (head == null)
			return head;
		ListNode p = head;
		ListNode r = new ListNode();
		ListNode q = r;
		while (p != null) {
			ListNode m = p.next;
			p.next = r.next;
			r.next = p;
			p = m;
		}
		return q.next;
	}
}
