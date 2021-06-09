package leetcode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
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
public class M_148 {

	public ListNode sortList(ListNode head) {
		if (head == null || head.next == null)
			return head;
		List<ListNode> list = new ArrayList<>();
		ListNode p = head;
		while (p != null) {
			list.add(p);
			p = p.next;
		}
		Collections.sort(list, (x, y) -> {
			return x.val - y.val;
		});
		ListNode h = new ListNode();
		ListNode h1 = h;
		for (ListNode node : list) {
			h.next = node;
			h = node;
		}
		h.next = null;
		return h1.next;
	}
}
