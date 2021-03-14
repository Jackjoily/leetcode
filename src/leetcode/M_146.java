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
public class M_146 {
	public static void main(String[] args) {

		LRUCache l = new LRUCache(2);
		l.put(1, 0);
		l.put(2, 2);
		System.out.println(l.get(1));
		l.put(3, 3);
		System.out.println(l.get(2));
		l.put(4, 4);
		System.out.println(l.get(1));
		System.out.println(l.get(3));
		System.out.println(l.get(4));
	}

}

class LRUCache {

	Map<Integer, MyNode> map;
	MyNode head;
	MyNode tail;
	int count = 0;

	public LRUCache(int capacity) {
		map = new HashMap<>(capacity);
		head = new MyNode(-1000, -1000);
		tail = new MyNode(1000, 1000);
		head.next = tail;
		head.pre = tail;
		tail.next = head;
		tail.pre = head;
		count = capacity;
	}

	public int get(int key) {
		if (map.containsKey(key)) {
			MyNode myNode = map.get(key);
			moveToHead(myNode);
			return myNode.val;
		} else {
			return -1;
		}
	}

	public void moveToHead(MyNode myNode) {
		myNode.pre.next = myNode.next;
		myNode.next.pre = myNode.pre;
		myNode.next = head.next;
		head.next.pre = myNode;
		myNode.pre = head;
		head.next = myNode;
	}

	public void addHead(MyNode myNode) {
		myNode.next = head.next;
		head.next.pre = myNode;
		myNode.pre = head;
		head.next = myNode;
	}

	public int deleteTail() {
		int a = tail.pre.key;
		tail.pre.pre.next = tail;
		tail.pre = tail.pre.pre;
		return a;
	}

	public void put(int key, int value) {
		if (map.containsKey(key)) {
			MyNode myNode = map.get(key);
			myNode.val = value;
			map.put(key, myNode);
			moveToHead(myNode);
		} else {
			if (map.size() == count) {
				int a = deleteTail();
				map.remove(a);
				MyNode myNode = new MyNode(key, value);
				addHead(myNode);
				map.put(key, myNode);
			} else {
				MyNode myNode = new MyNode(key, value);
				addHead(myNode);
				map.put(key, myNode);
			}
		}
	}
}

class MyNode {
	MyNode pre;
	MyNode next;
	int val;
	int key;

	public MyNode(int key, int val) {
		this.key = key;
		this.val = val;
	}

	public MyNode() {
	}
}
