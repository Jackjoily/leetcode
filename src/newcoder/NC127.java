package newcoder;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;

import leetcode_tree.TreeNode;
import leetcode_tree.TreeUtils;

public class NC127 {
	public static void main(String[] args) {
		System.out.println(LCS("22222", 
				"22222"));
	}

	public static String LCS(String str1, String str2) {
		int m = str1.length();
		int n = str2.length();
		int max = 0;
		int dp[][] = new int[m][n];
		for (int i = 0; i < m; i++) {
			if(str1.charAt(i)==str2.charAt(0)) {
				dp[i][0]=1;
			}
		}
		for (int i = 0; i < n; i++) {
			if(str1.charAt(0)==str2.charAt(i)) {
				dp[0][i]=1;
			}
		}
		int index = 0;
		for (int i = 1; i < m; i++) {
			for (int j = 1; j < n; j++) {
				if (str1.charAt(i) == str2.charAt(j)) {
					dp[i][j] = dp[i - 1][j - 1] + 1;
				}
				if (max < dp[i][j]) {
                    index=j;
                    max=dp[i][j];
				}
			}
		}
		return str2.substring(index+1-max,index+1);
	}
}
