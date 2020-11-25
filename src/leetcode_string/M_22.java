package leetcode_string;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.Stack;

/**
 * 
 * 数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。
 * 
 * @author jackjoily
 *
 */
public class M_22 {
	public static void main(String[] args) {
		M_22 m = new M_22();
		char a[] = { '(', '(', ')', ')' };
		boolean flag[] = new boolean[a.length];
		System.out.println(m.generateParenthesis1(6));

	}

	public List<String> generateParenthesis1(int n) {
		List<String> ans = new ArrayList<String>();
		backtrack(ans, new StringBuilder(), 0, 0, n);
		return ans;
	}

	/**
	 * 方法一还有改进的余地：我们可以只在序列仍然保持有效时才添加 '(' or ')'，而不是像 方法一
	 * 那样每次添加。我们可以通过跟踪到目前为止放置的左括号和右括号的数目来做到这一点，
	 * 
	 * 如果左括号数量不大于 nn，我们可以放一个左括号。如果右括号数量小于左括号的数量，我们可以放一个右括号。
	 * 
	 * @param ans
	 * @param cur
	 * @param open
	 * @param close
	 * @param max
	 */

	public void backtrack(List<String> ans, StringBuilder cur, int open, int close, int max) {
		if (cur.length() == max * 2) {
			ans.add(cur.toString());
			return;
		}
		if (open < max) {
			cur.append('(');
			backtrack(ans, cur, open + 1, close, max);
			cur.deleteCharAt(cur.length() - 1);
		}
		if (close < open) {
			cur.append(')');
			backtrack(ans, cur, open, close + 1, max);
			cur.deleteCharAt(cur.length() - 1);
		}
	}

	Set<String> set = new HashSet<>();
	List<String> list1 = new ArrayList<>();

	public List<String> generateParenthesis(int n) {
		if (n == 0)
			return list1;
		if (n == 1) {
			list1.add("()");
			return list1;
		}
		char a[] = new char[n * 2];
		boolean flag[] = new boolean[n * 2];
		for (int i = 0; i < 2 * n; i++) {
			if (i < n) {
				a[i] = '(';
			} else {
				a[i] = ')';
			}
		}
		StringBuilder sb = new StringBuilder();
		f(a, flag, sb);
		list1.addAll(set);
		return list1;
	}

	public void f(char[] a, boolean flag[], StringBuilder sb) {
		if (sb.length() == a.length) {
			char[] charArray = sb.toString().toCharArray();
			if (valid(charArray)) {
				set.add(new String(charArray));
			}
			return;
		}
		for (int i = 0; i < a.length; i++) {
			if (!flag[i]) {
				if ((sb.length() == 0 && a[i] == ')') || sb.length() == a.length - 1 && a[i] == '(') {
				} else {
					flag[i] = true;
					sb.append(a[i]);
					f(a, flag, sb);
					sb.deleteCharAt(sb.length() - 1);
					flag[i] = false;
				}
			}
		}
	}

	public boolean valid(char[] current) {
		int balance = 0;
		for (char c : current) {
			if (c == '(') {
				++balance;
			} else {
				--balance;
			}
			if (balance < 0) {
				return false;
			}
		}
		return balance == 0;
	}
}
