package leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * 
 * @author jackjoily
 *
 */
public class M_78 {
	public static void main(String[] args) {
		M_78 m = new M_78();
		int a[] = { 1, 2, 3, 4, 5 };
		int n = a.length;
		LinkedList<Integer> list = new LinkedList<>();
		f(a, 0, list, n);
	}

	static List<List<Integer>> list = new ArrayList<>();

	public List<List<Integer>> subsets(int[] nums) {
		int n = nums.length;
		if (n == 0) {
			ArrayList<Integer> arrayList = new ArrayList<>();
			list.add(arrayList);
			return list;
		} else if (n == 1) {
			ArrayList<Integer> arrayList = new ArrayList<>();
			list.add(arrayList);
			arrayList = new ArrayList<>();
			arrayList.add(nums[0]);
			list.add(arrayList);
			return list;
		} else {
			LinkedList<Integer> list1 = new LinkedList<>();
			f(nums, 0, list1, n);
		}
		return list;
	}

	public static void f(int a[], int inx, LinkedList<Integer> list1, int n) {
		list.add(new ArrayList<>(list1));
		for (int i = inx; i < n; i++) {
			list1.add(a[i]);
			f(a, i + 1, list1, n);
			list1.removeLast();
		}
	}
}
