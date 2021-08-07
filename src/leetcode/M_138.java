package leetcode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Queue;

/**
 * 
 * @author jackjoily
 *
 */
public class M_138 {
	public static void main(String[] args) {
		Node n = new Node(1);
		Node copyRandomList = copyRandomList(n);
		System.out.println(copyRandomList == n);
	}

	public static Node copyRandomList(Node head) {
		if (head == null )
			return head;
		Node n = head;
		Map<Node, Node> map = new HashMap<>();
		while (n != null) {
			map.put(n, new Node(n.value));
			n = n.next;
		}
		n = head;
		while (n != null) {
			Node node = map.get(n);
			if (n.next == null) {
				node.next = null;
				node.random = n.random == null ? null : map.get(n.random);
			} else {
				node.next = map.get(n.next);
				node.random = n.random == null ? null : map.get(n.random);
			}
			n = n.next;
		}

		return map.get(head);
	}
}
