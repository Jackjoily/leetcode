package leetcode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Queue;

import javafx.scene.shape.Line;
import leetcode_list.ListNode;
import leetcode_tree.TreeNode;

/**
 * 
 * @author jackjoily
 *
 */
public class M_92 {
	public ListNode reverseBetween(ListNode head, int m, int n) {
		if (head == null)
			return head;
		if (m == n)
			return head;
		ListNode pre = null, next = null, p = head;
		ListNode ph = null, phpre = null, pt = null, pttail = null;
		int i = 1;
		while (p != null) {
			next = p.next;
			if (i == m - 1)
				phpre = p;
			if (i == m)
				ph = p;
			if (i == n)
				pt = p;
			if (i == n + 1)
				pttail = p;
			if (i >= m && i <= n) {
				p.next = pre;
			}
			pre = p;
			p = next;
			i++;
		}
		if (phpre == null && pttail == null) {
			return pt;
		} else if (phpre != null && pttail != null) {
			phpre.next = pt;
			ph.next = pttail;
			return head;
		} else if (phpre == null) {
			ph.next = pttail;
			return pt;
		} else {
			ph.next = null;
			phpre.next = pt;
			return head;
		}
	}
}
