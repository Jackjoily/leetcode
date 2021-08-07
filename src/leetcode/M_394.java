package leetcode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;

import edu.princeton.cs.algs4.Stack;
import javafx.scene.shape.Line;
import leetcode_list.ListNode;
import leetcode_tree.TreeNode;

/**
 * 
 * @author jackjoily
 *
 */
public class M_394 {
	public static void main(String[] args) {
		System.out.println(decodeString("abc3[cd]xyz"));
	}

	public static String decodeString(String s) {
		int n = s.length();
		if (n == 0)
			return s;
		char[] c = s.toCharArray();
		Stack<Character> str = new Stack<>();
		Stack<Integer> num = new Stack<>();
		int val = 0;
		for (int i = 0; i < c.length; i++) {
			char d = c[i];
			if (Character.isDigit(d)) {
				val = val * 10 + d - '0';
			} else if (d == '[') {
				str.push('[');
				num.push(val);
				val = 0;
			} else if (d == ']') {
				List<Character> list = new ArrayList<>();
				while (!str.isEmpty() && str.peek() != '[') {
					list.add(str.pop());
				}
				str.pop();
				int n1 = num.pop();
				for (int i1 = 0; i1 < n1; i1++) {
					for (int i2 = list.size() - 1; i2 >= 0; i2--) {
						str.push(list.get(i2));
					}
				}
			} else {
				str.push(d);
			}
		}
		StringBuilder sb1 = new StringBuilder();
		while (!str.isEmpty()) {
			sb1.append(str.pop());
		}
		return sb1.reverse().toString();
	}
}
