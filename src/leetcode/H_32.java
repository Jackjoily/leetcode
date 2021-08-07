package leetcode;

import java.util.Arrays;
import java.util.HashMap;

/**
 * twosum
 * 
 * @author jackjoily
 *
 */
public class H_32 {

	public static void main(String[] args) {
		System.out.println(longestValidParentheses("(()())"));
	}

	public static int longestValidParentheses(String s) {
		int n = s.length();
		if (n <= 1)
			return 0;
		char[] c = s.toCharArray();
		int dp[] = new int[n];
		int max = 0;
		for (int i = 0; i < n; i++) {
			if (c[i] == '(') {
				continue;
			} else {
				if (i > 0) {
					if (c[i - 1] == '(') {
						if (i >= 2) {
							dp[i] = dp[i - 2] + 2;
						} else {
							dp[i] = 2;
						}
						max = Math.max(max, dp[i]);
					} else {
						int inx = i - dp[i - 1] - 1;
						if (inx >=0) {
							if (c[inx] == '(') {
								if (inx >= 2) {
									dp[i] = dp[i - 1] + 2 + dp[inx - 1];
								} else {
									dp[i] = dp[i - 1] + 2;
								}
							}
						}
						max = Math.max(max, dp[i]);
					}
				} else {
					continue;
				}
			}
		}
		return max;
	}
}
