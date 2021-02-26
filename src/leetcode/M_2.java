package leetcode;

import java.util.Arrays;
import java.util.HashMap;

import com.sun.org.apache.xerces.internal.util.SynchronizedSymbolTable;

import leetcode_list.ListNode;

/**
 * twosum 给你两个 非空 的链表，表示两个非负的整数。 它们每位数字都是按照 逆序 的方式存储的，并且每个节点只能存储 一位 数字。
 * 
 * 请你将两个数相加，并以相同形式返回一个表示和的链表。
 * 
 * 你可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 * 
 * @author jackjoily
 *
 */
public class M_2 {
	public static void main(String[] args) {

	}
	public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		ListNode p = l1, q = l2;
		int val = 0;
		int mod = 0;
		ListNode l = new ListNode();
		ListNode c = l;
		while (p != null & q != null) {
			val = mod + p.val + q.val;
			mod = val / 10;
			val = val % 10;
			ListNode n = new ListNode(val);
			l.next = n;
			l = n;
			p = p.next;
			q = q.next;
		}
		while (p != null) {
			val = mod + p.val;
			mod = val / 10;
			val = val % 10;
			ListNode n = new ListNode(val);
			l.next = n;
			l = n;
			p = p.next;
		}
		while (q != null) {
			val = mod + q.val;
			mod = val / 10;
			val = val % 10;
			ListNode n = new ListNode(val);
			l.next = n;
			l = n;
			q = q.next;
		}
		if (mod == 1) {
			ListNode n = new ListNode(1);
			l.next = n;
			l = n;
		}
		return c.next;
	}
}
