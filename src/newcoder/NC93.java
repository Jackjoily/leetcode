package newcoder;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import leetcode_tree.TreeNode;
import leetcode_tree.TreeUtils;

public class NC93 {

	public static void main(String[] args) {
		NC93 n = new NC93();
		int a[][] = { { 1, 1, 1 }, { 1, 2, 2 }, { 1, 3, 2 }, { 2, 1 }, { 1, 4, 4 }, { 2, 2 } };
		n.LRU(a, 4);
	}

	Node head = new Node();
	Node tail = new Node();
	int k = 0;
	int size = 0;
	Map<Integer, Node> map = new HashMap<>();

	public NC93() {
		head.next = tail;
		head.prev=tail;
		tail.prev = head;
		tail.next=head;
	}

	public void moToHead(Node node) {
		node.next = head.next;
		head.next.prev = node;
		node.prev = head;
		head.next = node;
	}

	public void deleteNode(Node node) {
		node.prev.next = node.next.next;
		node.next.prev = node.prev;
	}

	public int get(int key) {
		if (map.containsKey(key)) {
			Node node = map.get(key);
			deleteNode(node);
			moToHead(node);
			return node.val;
		} else {
			return -1;
		}
	}

	public int deleteTail() {
		int a = tail.prev.val;
		tail.prev.prev.next = tail;
		tail.prev = tail.prev.prev;
		return a;
	}

	public Node set(int key, int val) {
		if (map.containsKey(key)) {
			Node node = map.get(key);
			node.val = val;
			deleteNode(node);
			moToHead(node);
			return node;
		} else {
			Node node = new Node();
			node.key = key;
			node.val = val;
			map.put(key, node);
			moToHead(node);
			if (size > k) {
				int deleteTail = deleteTail();
				map.remove(deleteTail);
				size--;
			} else {
				size++;
			}
			return node;
		}
	}

	/**
	 * lru design
	 * 
	 * @param operators
	 *            int整型二维数组 the ops
	 * @param k
	 *            int整型 the k
	 * @return int整型一维数组
	 */
	public int[] LRU(int[][] operators, int k) {
		List<Integer> list = new ArrayList<>();
		this.k = k;
		for (int i = 0; i < operators.length; i++) {
			int a[] = operators[i];
			if (a.length == 2) {
				int j = get(a[1]);
				list.add(j);
			} else {
				set(a[1], a[2]);
			}
		}
		System.out.println(list);
		return null;
	}

}

class Node {
	public int key;
	public int val;
	public Node next;
	public Node prev;
}
