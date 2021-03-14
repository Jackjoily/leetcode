package leetcode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Queue;

import com.sun.management.jmx.Trace;

import javafx.scene.shape.Line;
import leetcode_list.ListNode;
import leetcode_tree.TreeNode;

/**
 * 
 * @author jackjoily
 *
 */
public class M_120 {
	public static void main(String[] args) {
		M_120 m = new M_120();
		List<List<Integer>> triangle = new ArrayList<>();
		List<Integer> l1 = new ArrayList<>();
		l1.add(2);
		List<Integer> l2 = new ArrayList<>();
		l2.add(3);
		l2.add(4);
		List<Integer> l3 = new ArrayList<>();
		l3.add(6);
		l3.add(5);
		l3.add(7);
		List<Integer> l4 = new ArrayList<>();
		l4.add(4);
		l4.add(1);
		l4.add(8);
		l4.add(3);
		triangle.add(l1);
		triangle.add(l2);
		triangle.add(l3);
		triangle.add(l4);
		System.out.println(	m.minimumTotal(triangle));
	}

	public int minimumTotal(List<List<Integer>> triangle) {
		int n = triangle.size();
		if (n == 0)
			return triangle.get(0).get(0);
		int dp[][] = new int[n][n];
		dp[0][0] = triangle.get(0).get(0);
		for (int i = 1; i < n; i++) {
			dp[i][0] = dp[i - 1][0] + triangle.get(i).get(0);
		}
		for (int i = 1; i < n; i++) {
			List<Integer> list = triangle.get(i);
			for (int j = 1; j <= i; j++) {
				if (j<i) {
					dp[i][j] = list.get(j) + Math.min(dp[i - 1][j], dp[i - 1][j - 1]);
				} else {
					dp[i][j] = list.get(j) + dp[i - 1][j - 1];
				}

			}
		}
		int min = Integer.MAX_VALUE;
		for (int i = 0; i < n; i++) {
			min = Math.min(min, dp[n - 1][i]);
		}
		return min;
	}
}
