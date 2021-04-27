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
public class M_438 {

	public static void main(String[] args) {
		System.out.println(findAnagrams("cbaebabacd", "abc"));
	}

	public static List<Integer> findAnagrams(String s, String p) {
		List<Integer> list = new ArrayList<>();
		if (s == null || s.length() == 0 || p == null || p.length() == 0)
			return list;
		int left = 0, right = 0;
		int need[] = new int[26];
		char[] s1 = s.toCharArray();
		char[] p1 = p.toCharArray();
		for (int i = 0; i < p1.length; i++) {
			need[p1[i] - 'a']++;
		}
		int window[] = new int[26];
		while (right < s.length()) {
			window[s1[right]-'a']++;
			if (right - left + 1 == p1.length) {
				if (Arrays.equals(window, need))
					list.add(left);
				   window[s.charAt(left) - 'a']--;
	                left++;
			}
			right++;
		}
		return list;
	}
}
