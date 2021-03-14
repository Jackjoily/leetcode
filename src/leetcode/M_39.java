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
		int a[] = { 2, 3, 5 };
		// combinationSum(a, 8);
		LinkedList<Integer> list = new LinkedList<>();
		f1(a, 8, 0, list);
	}

	static Set<List<Integer>> set = new HashSet<>();


	public static void f(int a[], int target, int sum, LinkedList<Integer> list) {
		if (sum == target) {
			System.out.println(list);
			return;
		}
		for (int i = 0; i < a.length; i++) {
			sum += a[i];
			if (sum > target) {
				sum -= a[i];
				break;
			}
			list.add(a[i]);
			f(a, target, sum, list);
			sum -= a[i];
			list.removeLast();
		}
	}
	static List<List<Integer>> list2 = new ArrayList<>();

	public static List<List<Integer>> combinationSum(int[] candidates, int target) {
		LinkedList<Integer> list = new LinkedList<>();
		Arrays.sort(candidates);
		f1(candidates, target, 0, list);
		return null;
	}
	public  static void f1(int a[], int target, int begin, LinkedList<Integer> list) {
		if (target == 0) {
			list2.add(new ArrayList<>(list));
			return;
		}
		if (target < 0)
			return;
		for (int i = begin; i < a.length; i++) {
			if (target - a[i] < 0)
				break;
			list.add(a[i]);
			f1(a, target - a[i], i, list);
			list.removeLast();
		}
	}
}
