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
public class M_647 {
	public static void main(String[] args) {

		System.out.println(countSubstrings("aaaaaa"));
	}

	public static int countSubstrings(String s) {
		int n = s.length();
		int sum = n;
		int dp[][] = new int[n][n];
		for (int i = 0; i < n; i++) {
			dp[i][i] = 1;
		}
		char[] c = s.toCharArray();
		for (int i = n - 1; i >= 0; i--) {
			for (int j = n - 1; j >= i; j--) {
				if (c[i] == c[j]) {
					if (j == i + 1) {
						dp[i][j] = 1;
						sum++;
					}
					else if (i + 1 < n && j - 1 >= 0) {
						if (dp[i + 1][j - 1] != 0) {
							dp[i][j] = 1;
							sum++;
						}
					}
				}
			}
		}
		return sum;
	}
}
