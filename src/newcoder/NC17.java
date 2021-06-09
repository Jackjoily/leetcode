package newcoder;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;

import leetcode_tree.TreeNode;
import leetcode_tree.TreeUtils;

public class NC17 {
	public static void main(String[] args) {
		NC17 n = new NC17();
		System.out.println(n.getLongestPalindrome("baabccc", 7));

	}

	public int getLongestPalindrome(String A, int n) {
		if (n <= 1)
			return n;
		int max = 1;
		char[] c = A.toCharArray();
		for (int i = 1; i < n; i++) {
			max =Math.max(Math.max(huiWen(c, i,i), max), huiWen(c, i,i+1)); 
		}
		return max;
	}

	public int huiWen(char c[], int left,int right) {
	    while (left >= 0 && right < c.length &&c[left] == c[right]) {
            --left;
            ++right;
        }
        return right - left - 1;
	}
}
