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
	public static void main(String[] args) {
		ListNode create = ListNode.create(5);
		M_92 m = new M_92();
		ListNode reverseBetween = m.reverseBetween(create, 3, 5);
		ListNode.print(reverseBetween);
	}

	public ListNode reverseBetween(ListNode head, int m, int n) {
		if (m == n)
			return head;
		ListNode pre = null, pmpre = null, pm = null, pn = null, pt = null;
		ListNode next;
		ListNode p = head;
		int i = 1;
		while (p != null) {
			next = p.next;
			if (i == m - 1) {
				pmpre = p;
			}
			if (i == m) {
				pm = p;
			}
			if (i == n) {
				pn = p;
			}
			if (i == n + 1) {
				pt = p;
			}
			if (i >= m & i <= n) {
				p.next = pre;
			}
			pre = p;
			p = next;
			i++;
		}
		if (pmpre == null) {
			if (pt == null) {
				return pn;
			} else {
				pm.next = pt;
				return pn;
			}
		} else {
			if (pt == null) {
				pmpre.next = pn;
				pm.next = null;
				return head;
			} else {
				pmpre.next = pn;
				pm.next = pt;
				return head;
			}
		}
	}
}
