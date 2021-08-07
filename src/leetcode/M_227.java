package leetcode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Stack;
import java.util.concurrent.Callable;

import javafx.scene.shape.Line;
import leetcode_list.ListNode;
import leetcode_tree.TreeNode;

/**
 * 
 * @author jackjoily
 *
 */

public class M_227 {
	public static void main(String[] args) {
		M_227 m = new M_227();
		m.calculate(" 3+5 / 2-23-423-53-2+7+8+45/2*3/37+78+78");
	}

	public int calculate(String s) {
		String trim = s.trim();
		char[] c = trim.toCharArray();
		Stack<Integer> num = new Stack<>();
		Stack<Character> op = new Stack<>();
		int val = 0;
		for (int i = 0; i < c.length; i++) {
			if (Character.isDigit(c[i])) {
				val = val * 10 + c[i] - '0';
			} else if (c[i] == ' ') {
				continue;
			} else {
				num.add(val);
				val = 0;
				if (op.isEmpty()) {
					op.add(c[i]);
				} else {
					int l = getLevel(c[i]);
					while (!op.isEmpty() && l <= getLevel(op.peek())) {
						int a = num.pop();
						int b = num.pop();
						num.add(cal(b, a, op.pop()));
					}
					op.add(c[i]);
				}
			}
		}
		num.add(val);
		while (!op.isEmpty()) {
			int a = num.pop();
			int b = num.pop();
			num.add(cal(b, a, op.pop()));
		}
		return num.peek();
	}

	public int cal(int a, int b, char c) {
		if (c == '*') {
			return a * b;
		} else if (c == '/') {
			return a / b;
		} else if (c == '+') {
			return a + b;
		} else {
			return a - b;
		}
	}

	public int getLevel(char c) {
		if (c == '*' || c == '/')
			return 1;
		else if (c == '+' || c == '-') {
			return 0;
		}
		return c;
	}
}
