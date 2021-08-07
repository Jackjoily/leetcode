package leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;

import com.sun.org.apache.xerces.internal.util.SynchronizedSymbolTable;

/**
 * twosum
 * 
 * @author jackjoily
 *
 */
public class H_460 {
}

class LFUCache {
	Map<Integer, Node> cache;
	Map<Integer, LinkedHashSet<Node>> freMap;
	int size = 0;
	int min = 0;
	int capacity = 0;

	public LFUCache(int capacity) {
		this.capacity = capacity;
		cache = new HashMap<>(capacity);
		freMap = new HashMap<>();
	}

	public int get(int key) {
		Node node = cache.get(key);
		if (node == null) {
			return -1;
		}
		incFre(node);
		return node.value;
	}

	public void put(int key, int value) {
		if (capacity == 0) {
			return;
		}
		Node node = cache.get(key);
		if (node != null) {
			node.value = value;
			incFre(node);
		} else {
			if (capacity == size) {
				Node n = removeNode();
				cache.remove(n);
				size--;
			}
			node = new Node(key, value);
			cache.put(key, node);
			addNode(node);
			size++;
		}
	}

	public Node removeNode() {
		LinkedHashSet<Node> set = freMap.get(min);
		Node next = set.iterator().next();
		set.remove(next);
		return next;
	}

	public void addNode(Node node) {
		LinkedHashSet<Node> set = freMap.get(1);
		if (set == null) {
			set = new LinkedHashSet<>();
			freMap.put(1, set);
		}
		set.add(node);
		min = 1;
	}

	public void incFre(Node node) {
		int freq = node.freq;
		LinkedHashSet<Node> set = freMap.get(freq);
		set.remove(node);
		if (min == freq && set.size() == 0) {
			min = freq + 1;
		}
		node.freq++;
		LinkedHashSet<Node> set1 = freMap.get(freq + 1);
		if (set1 == null) {
			freMap.put(freq + 1, set1);
			set1 = new LinkedHashSet<>();
		}
		set1.add(node);
	}
}

class Node {
	int key;
	int value;
	int freq = 1;
	Node next;
	Node random;

	public Node(int valu) {
		this.value = value;
		this.random = null;
		this.next = null;
	}

	public Node() {
	}

	public Node(int key, int value) {
		this.key = key;
		this.value = value;
	}
}
