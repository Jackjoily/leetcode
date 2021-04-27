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
public class M_279 {
	public static void main(String[] args) {
		System.out.println(numSquares(13));
	}

	public static int numSquares(int n) {
		int m = (int) Math.sqrt(n);
		int val[] = new int[m + 1];
		int dp[] = new int[n + 1];

		Arrays.fill(dp, Integer.MAX_VALUE);
		dp[0]=0;
		for (int i = 1; i <= m; i++) {
			val[i] = i * i;
		}
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <=m; j++) {
				if (i < val[j]) {
					break;
				}
				dp[i] = Math.min(dp[i], dp[i - val[j]] + 1);
			}
		}
		return dp[n];
	}
}
