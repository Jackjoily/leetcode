package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

import leetcode_list.ListNode;

/**
 * 
 * @author jackjoily
 *
 */
public class M_22 {
	public static void main(String[] args) {
		M_22 m = new M_22();
		System.out.println(m.generateParenthesis(3));
	}

	public List<String> generateParenthesis(int n) {
		List<String> list = new ArrayList<>();
		StringBuilder sb = new StringBuilder();
		f(n, sb, 0, 0, list);
		return list;
	}

	public void f(int n, StringBuilder sb, int left, int right, List<String> list) {
		if (sb.length() == 2 * n) {
			list.add(sb.toString());
		}
		if (left < n) {
			sb.append("(");
			f(n, sb, left + 1, right, list);
			sb.deleteCharAt(sb.length() - 1);
		}
		if (right < left) {
			sb.append(")");
			f(n, sb, left, right + 1, list);
			sb.deleteCharAt(sb.length() - 1);
		}
	}

}
