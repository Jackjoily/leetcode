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

import javafx.scene.shape.Line;
import leetcode_list.ListNode;
import leetcode_tree.TreeNode;

/**
 * 
 * @author jackjoily
 *
 */
public class M_1190 {
	public static void main(String[] args) {
		System.out.println(reverseParentheses("a(bcdefghijkl(mno)p)q"));
	}

	public static String reverseParentheses(String s) {
		int len = s.length();
		if (len <= 1)
			return s;
		Stack<String> s1 = new Stack<>();
		char[] c = s.toCharArray();
		for (int i = 0; i < c.length; i++) {
			if (c[i] == '(') {
				s1.push(c[i] + "");
			} else if (c[i] == ')') {
				StringBuilder sb = new StringBuilder();
				while (!s1.isEmpty() && !s1.peek().equals("(")) {
					sb.append(s1.pop());
				}
				s1.pop();
				s1.push(sb.reverse().toString());
			} else {
				s1.push(c[i] + "");
			}
		}
		StringBuilder sb1 = new StringBuilder();
		while (s1.size() != 0) {
			sb1.append(s1.pop());
		}
		return sb1.reverse().toString();
	}
}
