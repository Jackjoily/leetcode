package leetcode_stack;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * 
 * 运用你所掌握的数据结构，设计和实现一个  LRU (最近最少使用) 缓存机制 。 实现 LRUCache 类： LRUCache(int
 * capacity) 以正整数作为容量 capacity 初始化 LRU 缓存 int get(int key) 如果关键字 key
 * 存在于缓存中，则返回关键字的值，否则返回 -1 。 void put(int key, int
 * value) 如果关键字已经存在，则变更其数据值；如果关键字不存在，则插入该组「关键字-值」。当缓存容量达到上限时，它应该在写入新数据之前删除最久未使用的数据值，从而为新的数据值留出空间。
 * 进阶：你是否可以在 O(1) 时间复杂度内完成这两种操作？
 * 
 * 
 * @author jackjoily
 *
 */
public class M_146 {
	public static void main(String[] args) {
		LRUCache lr = new LRUCache(2);
		lr.put(1, 1);
		lr.put(2, 2);
		System.out.println(lr.get(1));
		lr.put(3,3);
		System.out.println(lr.get(2));
		lr.put(4,4);
		System.out.println(lr.get(1));
		System.out.println(lr.get(3));
		System.out.println(lr.get(4));
	}
}

class LRUCache {
	// 双向链表
	class DLinkedNode {
		int key;
		int value;
		DLinkedNode prev;
		DLinkedNode next;

		public DLinkedNode() {
		}

		public DLinkedNode(int _key, int _value) {
			key = _key;
			value = _value;
		}

	}

	private Map<Integer, DLinkedNode> cache = new HashMap<Integer, DLinkedNode>();
	private int size;
	private int capacity;
	private DLinkedNode head, tail;

	public LRUCache(int capacity) {
		this.size = 0;
		this.capacity = capacity;
		// 使用伪头部和伪尾部节点
		head = new DLinkedNode();
		tail = new DLinkedNode();
		head.next = tail;
		tail.prev = head;
	}

	public int get(int key) {
		DLinkedNode node = cache.get(key);
		if (node == null) {
			return -1;
		}else {
			moveToHead(node);
			return node.value;	
		}
	}

	private void moveToHead(DLinkedNode node) {
		// TODO Auto-generated method stub
		DLinkedNode no = node;
		node.prev.next = node.next;
		node.next.prev = node.prev;
		addTohead(no);
	}

	public void put(int key, int value) {
		DLinkedNode node = cache.get(key);
		if (node == null) {
			DLinkedNode dl = new DLinkedNode(key, value);
			cache.put(key, dl);
			addTohead(dl);
			++size;
			if (size > capacity) {
				// 如果超出容量，删除双向链表的尾部节点
				DLinkedNode tail = removeTail();
				cache.remove(tail.key);
				--size;
			
			}
		}else {
			// 如果 key 存在，先通过哈希表定位，再修改 value，并移到头部
			node.value = value;
			moveToHead(node);
		}

	}

	private DLinkedNode removeTail() {
		DLinkedNode node = tail.prev;
		tail.prev.prev.next=tail;
		tail.prev = tail.prev.prev;
		return node;
	}

	private void addTohead(DLinkedNode node) {
		node.next = head.next;
		head.next.prev=node;
		head.next= node;
		node.prev = head;
	}
}
