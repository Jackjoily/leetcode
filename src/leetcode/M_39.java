package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

/**
 * 
 * @author jackjoily
 *
 */
public class M_39 {
	public static void main(String[] args) {
		int a[] = { 2, 3, 6, 7 };
		LinkedList<Integer> list = new LinkedList<>();
		f(a, 0, list, 4, 7);
	}

	static List<List<Integer>> list1 = new ArrayList<>();

	public List<List<Integer>> combinationSum(int[] candidates, int target) {
		int n = candidates.length;
		if (n == 0)
			return list1;
		Arrays.sort(candidates);
		LinkedList<Integer> list = new LinkedList<>();
		f(candidates, 0, list, n, target);
		return list1;
	}

	public static void f(int a[], int inx, LinkedList<Integer> list, int n, int sum) {
		if (sum == 0) {
			list1.add(new ArrayList<>(list));
			return;
		}
		for (int i = inx; i < n; i++) {
			if (sum - a[i] < 0)
				break;
			list.add(a[i]);
			f(a, i, list, n, sum - a[i]);
			list.removeLast();
		}
	}
}
