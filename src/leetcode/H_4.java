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
		int a[] = { 1, 3 };
		int b[] = { 2 };
		System.out.println(getKth(a, 0, a.length - 1, b, 0, b.length - 1, 8));
	}

	public static double findMedianSortedArrays(int[] a, int[] b) {
		int n = a.length;
		int m = b.length;
		int left = (n + m + 1) / 2;
		int right = (n + m + 2) / 2;
		return (getKth(a, 0, n - 1, b, 0, m - 1, left) + getKth(a, 0, n - 1, b, 0, m - 1, right)) * 0.5;
	}

	public static int getKth(int a[], int as, int ah, int b[], int bs, int bh, int k) {

		int alen = ah - as + 1;
		int blen = bh - bs + 1;
		// 让 len1 的长度小于 len2，这样就能保证如果有数组空了，一定是 len1
		if (alen > blen)
			return getKth(b, bs, bh, a, as, ah, k);
		if (alen <= 0) {
			return b[bs + k - 1];
		}
		if (k == 1) {
			return a[as] < b[bs] ? a[as] : b[bs];
		}
		int len = k / 2;
		int ainx = len >= alen ? ah : (as + len - 1);
		int binx = len >= blen ? bh : (bs + len - 1);

		if (a[ainx] > b[binx]) {
			return getKth(a, as, ah, b, binx + 1, bh, k - (binx - bs + 1));
		} else {
			return getKth(a, ainx + 1, ah, b, bs, bh, k - (ainx - as + 1));
		}
	}
}
