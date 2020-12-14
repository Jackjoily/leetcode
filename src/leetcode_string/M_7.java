package leetcode_string;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.Stack;

public class M_7 {

	public static void main(String[] args) {
		System.out.println(removeDuplicateLetters("aaaba"));
	}

	/**
	 * 给你一个字符串 s ，请你去除字符串中重复的字母， 使得每个字母只出现一次。
	 *  需保证 返回结果的字典序最小 （要求不能打乱其他字符的相对位置）。
	 *  
	 * 通过贪心的方法，进行比较，遍历到的字符与当前栈顶字符进行比较，如果大于则加入，否则的话，如果小于的话
	 * 则将栈中在后续数组不再出现的给pop出，然后加入
	 */
	public static String removeDuplicateLetters(String s) {
		Set<Character> set = new HashSet<>();
		Stack<Character> stack = new Stack<>();
		Map<Character, Integer> map = new HashMap<>();
		for (int i = 0; i < s.length(); i++) {
			map.put(s.charAt(i), i);
		}
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if (stack.isEmpty()) {
				stack.push(c);
				set.add(c);
			} else {
				if (stack.peek() < c && !set.contains(c)) {
					stack.add(c);
					set.add(c);
				} else if (stack.peek() == c) {
					continue;
				} else {
					if (!set.contains(c)) {
					while (!stack.isEmpty() && stack.peek() >= c && map.get(stack.peek()) >= i) {
						set.remove(stack.pop());
					}
						stack.add(c);
						set.add(c);
					}
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
