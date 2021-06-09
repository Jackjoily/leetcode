package leetcode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.stream.Stream;

import basic.Node;
import javafx.scene.shape.Line;
import leetcode_list.ListNode;
import leetcode_tree.TreeNode;

/**
 * 
 * @author jackjoily
 *
 */
public class M_143 {
	public static void main(String[] args) {
		ListNode create = ListNode.create(4);
		reorderList(create);
		ListNode.print(create);
	}

	public static void reorderList(ListNode head) {
		LinkedList<ListNode> list = new LinkedList<>();
		ListNode p = head;
		while (p != null) {
			list.add(p);
			p = p.next;
		}
		ListNode l = new ListNode();
		ListNode r = l;
		while (list.size() != 0) {
			ListNode poll = list.poll();
			l.next = poll;
			l = poll;
			if (list.size() != 0) {
				ListNode pollLast = list.pollLast();
				l.next = pollLast;
				l = pollLast;
			}
		}
		l.next = null;
	}
}
