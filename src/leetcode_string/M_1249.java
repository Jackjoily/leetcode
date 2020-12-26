package leetcode_string;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class M_1249 {
	public static void main(String[] args) {
		System.out.println(minRemoveToMakeValid("(a(b(c)d)"));
	}

	public static String minRemoveToMakeValid(String s) {
		Stack<Character> stack = new Stack<>();
		int r = 0;
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if (c != ')') {
				if (c == '(') {
					r++;
				}
				stack.add(c);
			} else {
				if (r > 0) {
					stack.add(c);
					r--;
				} else {
					continue;
				}
			}
		}
		StringBuilder sb = new StringBuilder();
		if (r == 0) {
			for (int i = 0; i < stack.size(); i++) {
				sb.append(stack.get(i));
			}
			return sb.toString();
		} else {
			int i = 0;
			while(i<r) {
				for (int k = stack.size()-1; i < r && k>=0; k--) {
					if (stack.get(k) == '(') {
						stack.remove(k);
						i++;
					}
				}
			}
		}
		for (int i = 0; i < stack.size(); i++) {
			sb.append(stack.get(i));
		}
		return sb.toString();
	}
}
