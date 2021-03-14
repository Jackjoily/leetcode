package leetcode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Queue;

import edu.princeton.cs.algs4.Count;
import javafx.scene.shape.Line;
import leetcode_list.ListNode;
import leetcode_tree.TreeNode;

/**
 * 
 * @author jackjoily
 *
 */
public class M_51 {
	static int count = 0;

	public static void main(String[] args) {
		M_51 m = new M_51();
		m.solveNQueens(8);
		System.out.println(count);
	}

	List<List<String>> list = new ArrayList<>();

	public List<List<String>> solveNQueens(int n) {
		int a[] = new int[n];
		f(a, 0, n);
		return list;
	}

	public void f(int a[], int n, int k) {
		if (n == k) {
			count++;
			System.out.println(Arrays.toString(a));
			return;
		}
		for (int i = 0; i < k; i++) {
			a[n] = i;
			if (judge(a, n, k)) {
				f(a, n + 1, k);
			}
		}
	}

	public boolean judge(int a[], int n, int k) {
		for (int i = 0; i < n; i++) {
			if (i != n) {
				if (a[i] == a[n] || Math.abs(a[i] - a[n]) == Math.abs(i - n)) {
					return false;
				}
			}
		}
		return true;
	}
}
