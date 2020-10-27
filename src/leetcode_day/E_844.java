package leetcode_day;

import java.util.Stack;

public class E_844 {
	public static void main(String[] args) {
		boolean backspaceCompare = backspaceCompare("a#c","b");
		System.out.println(backspaceCompare);
	}

	public  static boolean backspaceCompare(String S, String T) {
		if (S == null || T == null)
			return false;
		Stack<Character> stack = new Stack<>();
		Stack<Character> stack1 = new Stack<>();
		int i = 0;
		while (i < S.length() && i < T.length()) {
			if (S.charAt(i) != '#') {
				stack.add(S.charAt(i));
			} else {
				if (!stack.isEmpty()) {
					stack.pop();
				}
			}
			if (T.charAt(i) != '#') {
				stack1.add(T.charAt(i));
			} else {
				if (!stack1.isEmpty()) {
					stack1.pop();
				}
			}
			i++;
		}
		while (i < T.length()) {
			if (T.charAt(i) != '#') {
				stack1.add(T.charAt(i));
			} else {
				if (!stack1.isEmpty()) {
					stack1.pop();
				}
			}
			i++;
		}
		while (i < S.length()) {
			if (S.charAt(i) != '#') {
				stack.add(S.charAt(i));
			} else {
				if (!stack.isEmpty()) {
					stack.pop();
				}
			}
			i++;
		}
		if (stack.size() != stack1.size()) {
			return false;
		} else {
			for (int j = 0; j < stack.size(); j++) {
				if (stack.get(j) != stack1.get(j)) {
					return false;
				}
			}
			return true;
		}

	}

}
