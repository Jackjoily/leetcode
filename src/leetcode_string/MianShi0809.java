package leetcode_string;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 
 * 
 * 括号。设计一种算法，打印n对括号的所有合法的（例如，开闭一一对应）组合。
 * 
 * 说明：解集不能包含重复的子集。
 * 
 * 例如，给出 n = 3，生成结果为：
 * 
 * [ "((()))", "(()())", "(())()", "()(())", "()()()" ]
 * 
 * @author jackjoily
 *
 */
public class MianShi0809 {
	public static void main(String[] args) {
		generateParenthesis(4);
	}

	public static List<String> generateParenthesis(int n) {
		List<String> list = new ArrayList<>();
		StringBuilder sb = new StringBuilder();
		f(sb, n, n, n, list);
		return list;
	}

	public static void f(StringBuilder sb, int l, int r, int n, List<String> list) {
		if (sb.length() == 2 * n) {
			list.add(sb.toString());
			return;
		}
		if (l > 0) {
			sb.append("(");
			f(sb, l - 1, r, n, list);
			sb.deleteCharAt(sb.length() - 1);
		}
		if (r > l) {
			sb.append(")");
			f(sb, l, r - 1, n, list);
			sb.deleteCharAt(sb.length() - 1);
		}
	}
}
