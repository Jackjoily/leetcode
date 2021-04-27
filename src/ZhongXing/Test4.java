package ZhongXing;

import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Scanner;

import javax.print.attribute.HashAttributeSet;

public class Test4 {

	public static class Node {
		Node prev;
		Node next;
		int val;
		int index;

		public Node(int val, int index) {
			this.val = val;
			this.index = index;
		}

	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Node head = new Node(-1, 0);
		Node p = head;
		Node head1 = new Node(-1, 0);
		Node q = head1;
		Map<Integer, Node> map = new HashMap<>();
		Map<Integer, Node> map1 = new HashMap<>();
		int n1 = sc.nextInt();
		for (int i = 1; i <= n1; i++) {
			Node node = new Node(i, i);
			p.next = node;
			node.prev = p;
			p = node;
			map.put(i, node);
		}
		int n2 = sc.nextInt();
		for (int i = 1; i <= n2; i++) {
			Node node = new Node(i + n1, i + n1);
		
			q.next = node;
			node.prev = q;
			q = node;
			map1.put(i+n1, node);
		}
		int qq = sc.nextInt();
		for (int i = 0; i < qq; i++) {
			int n = sc.nextInt();
			if (map.containsKey(n)) {
				Node node = map.get(n);
				map.remove(n);
				map1.put(n, node);
				node.prev.next = node.next;
				node.next.prev = node.prev;
				q.next = node;
				node.prev = q;
				q = node;
			} else {
				Node node = map1.get(n);
				map1.remove(n);
				map.put(n, node);
				node.prev.next = node.next;
				node.next.prev = node.prev;
				p.next = node;
				node.prev = p;
				p = node;
			}
		}
		System.out.println();
	}
}
