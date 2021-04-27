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

import edu.princeton.cs.algs4.In;
import javafx.scene.shape.Line;
import leetcode_list.ListNode;
import leetcode_tree.TreeNode;

/**
 * 
 * @author jackjoily
 *
 */
public class M_150 {
	public static void main(String[] args) {
		M_150 m = new M_150();
		String a[] = { "10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+" };
		System.out.println(m.evalRPN(a));
	}

	public int evalRPN(String[] tokens) {
		Stack<Integer> numStack = new Stack<>();
		for (int i = 0; i < tokens.length; i++) {
			String str = tokens[i];
			if (str.equals("+") || str.equals("-") || str.equals("*") || str.equals("/")) {
				int a = numStack.pop();
				int b = numStack.pop();
				int c = calcValue(str, b, a);
				numStack.push(c);
			} else {
				numStack.add(Integer.valueOf(str));
			}
		}
		return numStack.pop();
	}

	public int calcValue(String opertor, int a, int b) {
		int val = 0;
		switch (opertor) {
		case "+":
			val = a + b;
			break;
		case "-":
			val = a - b;
			break;
		case "*":
			val = a * b;
			break;
		case "/":
			val = a / b;
			break;
		default:
			break;
		}
		return val;
	}
}
