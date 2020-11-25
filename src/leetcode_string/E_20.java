package leetcode_string;

import java.util.Stack;

/**
 * 
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串， 判断字符串是否有效。 有效字符串需满足： 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 * 
 * @author jackjoily
 *
 */
public class E_20 {
	public static void main(String[] args) {
		System.out.println(isValid("()"));
	}

	public static boolean isValid(String s) {
		if (s.length() <= 1)
			return false;
		Stack<Character> stack = new Stack<>();
		for (int i = 0; i < s.length(); i++) {
			char charAt = s.charAt(i);
			if (charAt == '(' || charAt == '[' || charAt == '{') {
				stack.add(charAt);
			} else {
				if (charAt == ')') {
					if (stack.size() == 0)
						return false;
					else if (stack.peek() != '(')
						return false;
					else
						stack.pop();
				}
				else if (charAt == ']') {
					if (stack.size() == 0)
						return false;
					else if (stack.peek() != '[')
						return false;
					else
						stack.pop();
				}
				else if (charAt == '}') {
					if (stack.size() == 0)
						return false;
					else if (stack.peek() != '{')
						return false;
					else
						stack.pop();
				}else {
					return false;
				}
			
			}
		}
		if(stack.size()>0) {
			return false;
		}
		return true;
	}
}
