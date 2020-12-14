package leetcode_string;

import java.util.Stack;

public class M_272 {
	public static void main(String[] args) {
	}

	public int calculate(String s) {
		s = s.trim();
		return core(s.toCharArray());
	}

	private int i = 0;

	private int core(char[] chs) {
		Stack<Integer> stack = new Stack<>();
		int num = 0;
		char operation = '+';
		for (; i < chs.length; i++) {
			if (chs[i] == ' ') {
				continue;
			}
			if (Character.isDigit(chs[i])) {
				num = num * 10 + (chs[i] - '0');
			}
			if (!Character.isDigit(chs[i]) || i >= chs.length - 1) {
				if (operation == '+') {
					stack.push(num);
				} else if (operation == '-') {
					stack.push(-num);
				} else if (operation == '*') {
					int a = stack.pop();
					stack.push(a * num);
				} else if (operation == '/') {
					int a = stack.pop();
					stack.push(a / num);
				}
				if (i >= chs.length - 1) {
					break;
				}
				operation = chs[i];
				num = 0;
			}
		}
		int sum = 0;
		while (!stack.isEmpty()) {
			sum += stack.pop();
		}
		return sum;
	}
}
