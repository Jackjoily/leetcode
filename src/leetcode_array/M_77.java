package leetcode_array;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 给定两个整数 n 和 k，返回 1 ... n 中所有可能的 k 个数的组合。
 * 
 * @author jackjoily
 *
 */
public class M_77 {
	List<List<Integer>> list = new ArrayList<>();

	public List<List<Integer>> combine(int n, int k) {
		if (n == 0 || k == 0)
			return list;
		int a[] = new int[n];
		for (int i = 0; i < n; i++) {
			a[i] = i + 1;
		}
		f(a, k, 0, 0);
		return list;
	}

	public Stack<Integer> stack = new Stack<Integer>();

	private void f(int[] shu, int targ, int has, int cur) {
		if (has == targ) {
			ArrayList<Integer> list1 = new ArrayList<>();
			list1.addAll(stack);
			list.add(list1);
			return;
		}
		for (int i = cur; i < shu.length; i++) {
			if (!stack.contains(shu[i])) {
				stack.add(shu[i]);
				f(shu, targ, has + 1, i);
				stack.pop();
			}
		}

	}
}
