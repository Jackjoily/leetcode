package leetcode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.stream.Collectors;

import javafx.scene.shape.Line;
import leetcode_list.ListNode;
import leetcode_tree.TreeNode;

/**
 * 
 * @author jackjoily
 *
 */
public class M_46 {
	public static void main(String[] args) {
		int a[] = { 1, 2, 3 };
		f1(a, 0, 3);
	}

	static List<List<Integer>> list = new ArrayList<>();
	static boolean[] used;

	public static List<List<Integer>> permute(int[] nums) {
		used = new boolean[nums.length];
		LinkedList<Integer> list1 = new LinkedList<>();
		f(nums, nums.length, used, list1);
		return null;
	}

	public static void f1(int a[], int index, int n) {
		if (index == n) {
			System.out.println(Arrays.toString(a));
			return;
		}
		for (int i = index; i < n; i++) {
			swap(a, i, index);
			f1(a, index + 1, n);
			swap(a, i, index);
		}

	}

	public static void swap(int a[], int i, int j) {
		int temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}

	public static void f(int a[], int n, boolean used[], LinkedList<Integer> list1) {
		if (list1.size() == n) {
			System.out.println(list1);
		}
		for (int i = 0; i < n; i++) {
			if (!used[i]) {
				list1.add(a[i]);
				used[i] = true;
				f(a, n, used, list1);
				used[i] = false;
				list1.removeLast();
			}
		}
	}

}
