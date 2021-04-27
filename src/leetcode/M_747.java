package leetcode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

import javafx.scene.shape.Line;
import leetcode_list.ListNode;
import leetcode_tree.TreeNode;

/**
 * 
 * @author jackjoily
 *
 */

public class M_747 {
	public static void main(String[] args) {
		int a[][] = {{1,3},{6,9}};
		int b[] = { 2,5 };
		insert(a, b);
	}

	public static int[][] insert(int[][] intervals, int[] newInterval) {
		int a[][] = new int[intervals.length + 1][];
		int i = 0;
		for (; i < intervals.length; i++) {
			a[i] = intervals[i];
		}
		a[i] = newInterval;
		Arrays.sort(a, (x, y) -> (x[0] - y[0]));
		boolean flag = true;
		boolean used[] = new boolean[a.length];
		int n = a.length;
		while (flag) {
			flag = false;
			for (int j = 0; j < a.length; j++) {
				if (used[j]) {
					continue;
				}
				for (int k = j + 1; k < a.length; k++) {
					if (used[k]) {
						continue;
					}
					if (a[j][1] >= a[k][0]) {
						if (a[k][1] > a[j][1]) {
							a[j][1] = a[k][1];
						}
						used[k] = true;
						flag = true;
						n--;
					} else {
						break;
					}
				}
			}
		}
		int c[][] = new int[n][2];
		int m = 0;
		for (int l = 0; l < a.length; l++) {
			if (!used[l]) {
				c[m] = a[l];
				m++;
			}
		}
		System.out.println(Arrays.deepToString(a));
		return c;
	}
}
