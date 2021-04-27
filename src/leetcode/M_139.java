package leetcode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;

import com.sun.corba.se.impl.ior.WireObjectKeyTemplate;

import javafx.scene.shape.Line;
import leetcode_list.ListNode;
import leetcode_tree.TreeNode;

/**
 * 
 * @author jackjoily
 *
 */
public class M_139 {
	public static void main(String[] args) {
		String s = "catsandog";
		Set<String> w = new HashSet<>();
		w.add("cats");
		w.add("og");
		w.add("sand");
		w.add("and");
		w.add("cat");
		f(s, 0, w);
	}

	public boolean wordBreak(String s, List<String> wordDict) {
		int n = s.length();
		boolean[] dp = new boolean[n + 1];
		Set<String> set = new HashSet<>(wordDict);
		dp[0] = true;
		for (int i = 1; i <= n; i++) {
			for (int j = 0; j < i; j++) {
				if (dp[j]) {
					if (set.contains(s.substring(j, i))) {
						dp[i] = true;
						break;
					}
				}
			}
		}
		return dp[n];
	}

	static boolean flag = false;

	public static void f(String s, int begin, Set<String> wordDict) {
		if (begin == s.length()) {
			flag = true;
			System.out.println(flag);
			return;
		}
		for (int i = begin; i < s.length(); i++) {
			if (!flag) {
				if (wordDict.contains(s.substring(begin, i + 1))) {
					f(s, i + 1, wordDict);
				}
			} else {
				break;
			}

		}
	}
}
