package leetcode_day;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.Stack;

import leetcode_list.ListNode;

/**
 * 
 * 给你一个字符串 s ，请你去除字符串中重复的字母，使得每个字母只出现一次。 需保证 返回结果的字典序最小（要求不能打乱其他字符的相对位置）。
 * 
 * @author jackjoily
 *
 */
public class M_316 {
	public static void main(String[] args) {
		System.out.println(		removeDuplicateLetters("abacb"));
	}

	public static String removeDuplicateLetters(String s) {
		if (s.length() == 1)
			return s;
		Map<Character, Integer> map = new HashMap<>();
		Set<Character> set = new HashSet<>();
		for (int i = 0; i < s.length(); i++) {
			map.put(s.charAt(i), i);
		}
		Stack<Character> stack = new Stack<>();
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if (stack.isEmpty()) {
				stack.add(c);
				set.add(c);
			} else {
				if (!set.contains(c)) {
				while (!stack.isEmpty() && stack.peek() > c && map.get(stack.peek()) > i) {
					set.remove(stack.pop());
				}
					stack.add(c);
					set.add(c);
				}
			}
		}
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < stack.size(); i++) {
			sb.append(stack.get(i));
		}
		return sb.toString();
	}
}
