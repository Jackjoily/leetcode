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
public class M_142 {

	public ListNode detectCycle(ListNode head) {
		   if (head == null)
				return head;
			ListNode p, q;
			p = head;
			q = head;
			while (p != null && q != null) {
				p = p.next;
				if (q.next == null) {
					break;
				}
				q = q.next.next;
				if (p == q) {
					ListNode ptr = head;
					while (ptr != p) {
						p = p.next;
						ptr = ptr.next;
					}
					return ptr;
				}
			}
			return null;
	}
}
