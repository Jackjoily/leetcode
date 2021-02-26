package leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 
 * @author jackjoily
 *
 */
public class M_78 {
	public static void main(String[] args) {
		int a[] = { 1, 2, 3 };
	}

	List<List<Integer>> list = new ArrayList<>();

	public List<List<Integer>> subsets(int[] nums) {
		list.add(new ArrayList<>());
		Stack<Integer> s = new Stack<>();
		for (int i = 1; i <= nums.length; i++) {
			f(nums, 0, i, s);
		}
		return list;

	}

	public void f(int a[], int start, int k, Stack<Integer> s) {
		if (s.size() == k) {
			list.add(new ArrayList<>(s));
			return;
		}
		for (int i = start; i < a.length; i++) {
			if (!s.contains(a[i])) {
				s.add(a[i]);
				f(a, i + 1, k, s);
				s.pop();
			}
		}
	}
}
