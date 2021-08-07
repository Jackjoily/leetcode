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
public class M_208 {
}

class Trie {
	Trie[] children;
	boolean isEnd;

	public Trie() {
		children = new Trie[26];
		isEnd = false;
	}

	public void insert(String word) {
		Trie node = this;
		for (int i = 0; i < word.length(); i++) {
			char c = word.charAt(i);
			if (node.children[c - 'a'] == null) {
				node.children[c - 'a'] = new Trie();
			}
			node = node.children[c - 'a'];
		}
		node.isEnd = true;
	}

	public boolean search(String word) {
		Trie node = searchPrefix(word);
		return node != null && node.isEnd;

	}

	public boolean startsWith(String prefix) {
		return searchPrefix(prefix) != null;
	}

	private Trie searchPrefix(String prefix) {
		Trie node = this;
		for (int i = 0; i < prefix.length(); i++) {
			char ch = prefix.charAt(i);
			int index = ch - 'a';
			if (node.children[index] == null) {
				return null;
			}
			node = node.children[index];
		}
		return node;
	}
}
