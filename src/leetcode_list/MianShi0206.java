package leetcode_list;

import edu.princeton.cs.algs4.Stack;

/**
 * 编写一个函数，检查输入的链表是否是回文的。
 * 
 * @author jackjoily
 *
 */
public class MianShi0206 {
	public static void main(String[] args) {
	}

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
