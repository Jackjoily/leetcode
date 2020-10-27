package leetcode_array;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class M_78 {
	/**
	 * 给定一组不含重复元素的整数数组 nums，返回该数组所有可能的子集（幂集）。
	 * 
	 * @param nums
	 * @return
	 */

	List<List<Integer>> list1 = new ArrayList<>();

	public List<List<Integer>> subsets(int[] nums) {
		if (nums.length == 0)
			return list1;
		for (int i = 0; i < nums.length; i++) {
			f(nums, i, 0, 0);
		}
		return list1;
	}

	Stack<Integer> stack = new Stack<Integer>();
	public void f(int a[], int k, int count, int cur) {
		if (k == count) {
			ArrayList<Integer> list = new ArrayList<>();
			list.addAll(stack);
			list1.add(list);
			return;
		}
		for (int i = cur; i < a.length; i++) {
			if (!stack.contains(a[i])) {
				stack.add(a[i]);
				f(a, k, count + 1, i);
				stack.pop();
			}
		}
	}

}
