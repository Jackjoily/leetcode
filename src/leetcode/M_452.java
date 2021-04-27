package leetcode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
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
public class M_452 {
	public static void main(String[] args) {

		int a[][] = { { 9, 12 }, { 1, 10 }, { 4, 11 }, { 8, 12 }, { 3, 9 }, { 6, 9 }, { 6, 7 } };
		System.out.println(findMinArrowShots(a));
	}

	public static int findMinArrowShots(int[][] points) {
		int n = points.length;
		if (n <= 1)
			return n;
		Arrays.sort(points, new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				if (o1[0] != o2[0]) {
					if (o1[0] < o2[0]) {
						return -1;
					} else {
						return 1;
					}
				} else {
					if (o1[1] != o2[1]) {
						if (o1[1] < o2[1]) {
							return -1;
						} else {
							return 1;
						}
					}
					return 0;
				}
			}
		});
		int len = n;
		boolean used[] = new boolean[n];
		for (int i = 0; i < n; i++) {
			if (!used[i]) {
				for (int j = i + 1; j < n; j++) {
					if (!used[j]) {
						if (points[i][1] > points[j][0]) {
							used[j] = true;
							len--;
							points[i][1] = points[i][1] < points[j][1] ? points[i][1] : points[j][1];
						} else if (points[i][1] < points[j][0]) {
							break;
						} else {
							used[j] = true;
							len--;
							points[i][0] = points[j][0];
						}
					}
				}
			}
		}
		return len;
	}
}
