package leetcode_tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 实现一个 Trie (前缀树)，包含 insert, search, 和 startsWith 这三个操作。
 * 
 * 示例:
 * 
 * @author jackjoily
 *
 */
public class M_208 {
}

class TrieNode {

	// R links to node children
	private TrieNode[] links;

	private final int R = 26;

	private boolean isEnd;

	public TrieNode() {
		links = new TrieNode[R];
	}

	public boolean containsKey(char ch) {
		return links[ch - 'a'] != null;
	}

	public TrieNode get(char ch) {
		return links[ch - 'a'];
	}

	public void put(char ch, TrieNode node) {
		links[ch - 'a'] = node;
	}

	public void setEnd() {
		isEnd = true;
	}

	public boolean isEnd() {
		return isEnd;
	}
}

class Trie {

	private TrieNode root;

	public Trie() {
		root = new TrieNode();
	}

	public void insert(String word) {
		TrieNode node = root;
		for (int i = 0; i < word.length(); i++) {
			char c = word.charAt(i);
			if (!node.containsKey(c)) {
				node.put(c, new TrieNode());
			}
			node = node.get(c);
		}
		node.setEnd();
	}

	private TrieNode searchPrefix(String word) {
		TrieNode node = root;
		for (int i = 0; i < word.length(); i++) {
			char curLetter = word.charAt(i);
			if (node.containsKey(curLetter)) {
				node = node.get(curLetter);
			} else {
				return null;
			}
		}
		return node;
	}

	public boolean search(String word) {
		TrieNode node = searchPrefix(word);
		return node != null && node.isEnd();
	}

	public boolean startsWith(String prefix) {
		  TrieNode node = searchPrefix(prefix);
	        return node != null;
	}
}
