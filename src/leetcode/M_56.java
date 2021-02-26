package leetcode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
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
public class M_56 {
	public static void main(String[] args) {
		int a[][] = { { 1, 4 }, { 4, 5 } };
		merge(a);
	}

	public static int[][] merge(int[][] intervals) {
		Arrays.sort(intervals, (x, y) -> x[0] - y[0]);
		boolean flag[] = new boolean[intervals.length];
		int count = 0;
		for (int i = 0; i + 1 < intervals.length; i++) {
			if (intervals[i][1] >= intervals[i + 1][0]) {
				if (intervals[i][1] <= intervals[i + 1][1]) {
					intervals[i + 1][0] = intervals[i][0];
				} else {
					intervals[i + 1][0] = intervals[i][0];
					intervals[i + 1][1] = intervals[i][1];
				}
				flag[i] = true;
			} else {
				count++;
			}
		}
		int a[][] = new int[2][];
		for (int i = 0; i < intervals.length; i++) {
			if (!flag[i]) {
				a[i] = intervals[i];
			}
		}
		return a;
	}
}
