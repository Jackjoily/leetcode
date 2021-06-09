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
		int a[][] = { {1,3},{2,6},{8,10},{15,18}};
		merge(a);
	}

	public static int[][] merge(int[][] intervals) {
		Arrays.sort(intervals, (x, y) -> {
			if (x[0] != y[0]) {
				return x[0] - y[0];
			} else {
				return y[1] - x[1];
			}
		});
		int n = intervals.length;
		boolean used[] = new boolean[n];
		int count = n;
		for (int i = 0; i < n; i++) {
			if (!used[i]) {
				for (int j = i + 1; j < n; j++) {
					if (!used[j]) {
						if (intervals[j][0] <= intervals[i][1] && intervals[i][1] >= intervals[j][1]) {
							used[j] = true;
							count--;
						} else if (intervals[j][0] <= intervals[i][1] && intervals[i][1] < intervals[j][1]) {
							used[j] = true;
							count--;
							intervals[i][1] = intervals[j][1];
						} else if (intervals[j][0] > intervals[i][1]) {
							break;
						}
					}
				}
			}
		}
		int a[][] = new int[count][];
		int inx = 0;
		for (int i = 0; i < n; i++) {
			if (!used[i]) {
				a[inx++] = intervals[i];
			}
		}
		System.out.println(Arrays.deepToString(a));
		return a;
	}
}
