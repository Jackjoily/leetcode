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
public class M_1060 {
	public static void main(String[] args) {
		int a[] = {4,7,9,10};
		System.out.println(getK(a, 4));

	}

	public static int getK(int a[], int k) {
		int n = a.length;
		int len = a[n - 1] - a[0] + 1 - n;
		if (k > len) {
			int l = a[n - 1];
			while (len != k) {
				l++;
				len++;
			}
			return l;
		} else {
			int left = 0;
			int rigt = 1;
			while (rigt < n) {
				int i = a[rigt] - a[left]-1;
				if (i < k) {
					k -= i;
					left++;
					rigt++;
				} else {
					int l1 = a[left];
					while (k != 0) {
						l1++;
						k--;
					}
					return l1;
				}
			}
		}
		return k;
	}
}
