package leetcode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Queue;

import javafx.scene.shape.Line;
import leetcode_list.ListNode;
import leetcode_tree.TreeNode;

/**
 * 
 * @author jackjoily
 *
 */
public class M_498 {
	public static void main(String[] args) {
		int a[][] = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
		System.out.println(Arrays.toString(findDiagonalOrder(a)));
	}

	public static int[] findDiagonalOrder(int[][] mat) {
		int m = mat.length;
		if (m == 0)
			return new int[0];
		int n = mat[0].length;
		if (n == 0)
			return new int[0];
		int a[] = new int[m * n];
		int i = 0;
		List<Integer> list = new ArrayList<>();
		for (int d = 0; d < m + n - 1; d++) {
			int r = d < n ? 0 : d - n + 1;
			int c = d < n ? d : n - 1;
			list.clear();
			while (r < m && c > -1) {
				list.add(mat[r][c]);
				r++;
				c--;
			}
			if (d % 2 != 0) {
				Collections.reverse(list);
			}
			for (int l : list) {
				a[i++] = l;
			}

		}
		return a;
	}
}
