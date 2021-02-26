package leetcode_day;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import leetcode_list.ListNode;
import leetcode_tree.TreeNode;
import leetcode_tree.TreeUtils;

public class M_567 {
	public boolean checkInclusion(String s1, String s2) {
		int n = s1.length();
		int m = s2.length();
		int b[] = new int[26];
		int a[] = new int[26];
		for (int i = 0; i < n; i++) {
			a[s1.charAt(i) - 'a']++;
			a[s2.charAt(i) - 'a']++;
		}
		if (Arrays.equals(a, b)) {
			return true;
		}
		for (int j = n; j < m; j++) {
			a[s2.charAt(j) - 'a']++;
			a[s2.charAt(j - 'n') - 'a']--;
			if (Arrays.equals(a, b)) {
				return true;
			}
		}
		return false;
	}

}
