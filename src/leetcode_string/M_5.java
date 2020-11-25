package leetcode_string;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import edu.princeton.cs.algs4.In;

/**
 * 
 * 罗马数字包含以下七种字符: I， V， X， L，C，D 和 M。
 * 
 * @author jackjoily
 *
 */
public class M_5 {
	public static void main(String[] args) {
		System.out.println(longestPalindrome("cbbd"));
	}

	public static String longestPalindrome(String s) {
	       int n = s.length();
	        boolean[][] dp = new boolean[n][n];
	        String ans = "";
	        for (int l = 0; l < n; ++l) {
	            for (int i = 0; i + l < n; ++i) {
	                int j = i + l;
	                if (l == 0) {
	                    dp[i][j] = true;
	                } else if (l == 1) {
	                    dp[i][j] = (s.charAt(i) == s.charAt(j));
	                } else {
	                    dp[i][j] = (s.charAt(i) == s.charAt(j) && dp[i + 1][j - 1]);
	                }
	                if (dp[i][j] && l + 1 > ans.length()) {
	                    ans = s.substring(i, i + l + 1);
	                }
	            }
	        }
	        return ans;
	}

	private static boolean isHuiWen(String string) {
		StringBuilder sb = new StringBuilder(string).reverse();
		if (sb.toString().equals(string)) {
			return true;
		} else {
			return false;
		}
	}
}
