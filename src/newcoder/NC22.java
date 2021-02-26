package newcoder;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import leetcode_tree.TreeNode;
import leetcode_tree.TreeUtils;

public class NC22 {
	public static void main(String[] args) {
		int a[] = { 1, 3, 5, 7, 9, 11, 12, 13, 0, 0, 0, 0 };
		int b[] = { 2, 4, 6, 8, 0, 0, 0, 0, 0 };
		merge(a, 8, b, 4);
		System.out.println(Arrays.toString(a));
	}

	/**
	 * 合并两个有序数组
	 */
	public static void merge(int A[], int m, int B[], int n) {
		if (m == 0 && n == 0)
			return;
		if (m == 0 && n != 0) {
           for(int i=0;i<n;i++) {
        	   A[i]=B[i];
           }
		}
		int a[] = new int[m];
		for (int i = 0; i < m; i++) {
			a[i] = A[i];
		}
		int i = 0, j = 0, k = 0;
		while (i < m && j < n) {
			if (a[i] < B[j]) {
				A[k] = a[i];
				i++;
			} else {
				A[k] = B[j];
				j++;
			}
			k++;
		}
		if (i >= m) {
			while (j < n) {
				A[k] = B[j];
				j++;
				k++;
			}
		} else {
			while (i < m) {
				A[k] = a[i];
				i++;
				k++;
			}
		}
	}
}
