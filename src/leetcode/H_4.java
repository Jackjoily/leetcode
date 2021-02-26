package leetcode;

import java.util.Arrays;
import java.util.HashMap;

/**
 * twosum
 * 
 * @author jackjoily
 *
 */
public class H_4 {

	public static void main(String[] args) {
		int a[] = { 1, 2 };
		int b[] = { 3, 4 };
		System.out.println(findMedianSortedArrays(a, b));
	}

	public static double findMedianSortedArrays(int[] a, int[] b) {
		int n = a.length;
		int m = b.length;
		int left = (n + m + 1) / 2;
		int right = (n + m + 2) / 2;
		int minK = getMinK(a, 0, n - 1, b, 0, m - 1, left);
		System.out.println(minK);
		int minK2 = getMinK(a, 0, n - 1, b, 0, m - 1, right);
		System.out.println(minK2);
		return (minK + minK2) * 0.5;
	}

	public static int getMinK(int a[], int as, int ae, int b[], int bs, int be, int k) {
		int len1 = ae - as + 1;
		int len2 = be - bs + 1;
		if (len1 > len2) {
			return getMinK(b, bs, be, a, as, ae, k);
		} else {
			if (len1 == 0)
				return b[bs + k - 1];
			if (k == 1)
				return Math.min(b[bs], a[as]);
			int i = as + Math.min(len1, k / 2) - 1;
			int j = bs + Math.min(len2, k / 2) - 1;
			if (a[i] < b[j]) {
				return getMinK(a, i + 1, ae, b, bs, be, k - (i - as + 1));
			} else {
				return getMinK(a, as, ae, b, j + 1, be, k - (j - bs + 1));
			}
		}
	}

}
