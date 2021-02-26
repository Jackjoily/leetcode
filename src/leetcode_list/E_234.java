package leetcode_list;

import java.util.Stack;

/**
 * 
 * 判断是否是回文链表
 * 
 * @author jackjoily
 *
 */
public class E_234 {
	public boolean isPalindrome(ListNode head) {
		if (head == null) {
			return true;
		}
		if (head.next == null) {
			return true;
		}
		ListNode p = head;
		Stack<Integer> s = new Stack<>();
		while (p != null) {
			s.push(p.val);
			p = p.next;
		}
		p = head;
		while (p != null) {
			if (s.pop() != p.val) {
				return false;
			}
			p = p.next;
		}
		return true;
	}
}
