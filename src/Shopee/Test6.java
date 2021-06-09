package Shopee;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;
import java.util.Stack;

import jdk.nashorn.internal.runtime.regexp.joni.ScanEnvironment;
import leetcode_list.ListNode;
import leetcode_tree.TreeNode;

public class Test6 {
	public static void main(String[] args) {
		ListNode create = ListNode.create(8);
		ListNode.print(reverseLinkedList(create,5));

	}

	public static ListNode reverseLinkedList(ListNode head, int n) {
		if (head == null)
			return head;
		ListNode dummy = new ListNode();
		dummy.next = head;
		ListNode end = dummy;
		ListNode pre = dummy;
		while (end != null) {
			for (int i = 0; i < n && end != null; i++) {
				end = end.next;
			}
			if (end != null) {
				ListNode next = end.next;
				end.next = null;
				ListNode start = pre.next;
				pre.next = reverse(start);
				start.next=next;
				pre = start;
				end = pre;
			} else {
				ListNode start = pre.next;
				pre.next = reverse(start);
				break;
			}
		}
		return dummy.next;
	}

	public static ListNode reverse(ListNode head) {
		ListNode pre = null;
		while (head != null) {
			ListNode next = head.next;
			head.next = pre;
			pre = head;
			head = next;
		}
		return pre;
	}
}
