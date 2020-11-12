package JianZhiOffer;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import leetcode_tree.TreeNode;
import leetcode_tree.TreeUtils;

/**
 * 请实现 copyRandomList 函数，复制一个复杂链表。在复杂链表中， 每个节点除了有一个 next 指针指向下一个节点，还有一个 random
 * 指针指向链表中的任意节点或者 null。
 * 
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/fu-za-lian-biao-de-fu-zhi-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * 
 * @author jackjoily
 *
 */
public class JianZhiOffer35 {
	public static void main(String[] args) {
		Node n7 = new Node(7);
		Node n13 = new Node(13);
		Node n11 = new Node(11);
		Node n10 = new Node(10);
		Node n1 = new Node(1);
		n7.next = n13;
		n7.random = null;
		n13.next = n11;
		n13.random = n7;
		n11.next = n10;
		n11.random = n1;
		n10.next = n1;
		n10.random = n11;
		n1.random = n7;
		copyRandomList(n7);
	}

	public static Node copyRandomList(Node head) {
		if (head == null)
			return head;
		Node p, q, r, k;
		r = head;
		Node node = new Node(head.val);
		p = node;
		q = p;
		k = p;
		Map<Integer, Node> map = new HashMap<>();
		Map<Node, Integer> map1 = new HashMap<>();
		map.put(0, p);
		map1.put(head, 0);
		int i = 1;
		while (head.next != null) {
			head = head.next;
			map1.put(head, i);
			Node temp = new Node(head.val);
			p.next = temp;
			map.put(i, temp);
			p = p.next;
			i++;
		}
		while (r != null) {
			Node random = r.random;
			if (random == null) {
				q.random = null;
			} else {
				Integer integer = map1.get(random);
				Node node2 = map.get(integer);
				q.random = node2;
			}
			r = r.next;
			q = q.next;
		}
		return k;
	}
}

class Node {
	int val;
	Node next;
	Node random;

	public Node(int val) {
		this.val = val;
		this.next = null;
		this.random = null;
	}

	@Override
	public String toString() {
		return "Node [val=" + val + ", next=" + next + "]";
	}
	
}