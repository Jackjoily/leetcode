package leetcode;

import java.util.Arrays;
import java.util.HashMap;

import com.sun.org.apache.xerces.internal.util.SynchronizedSymbolTable;

public class E_88 {

	public static void main(String[] args) {
	}

	public void merge(int[] nums1, int m, int[] nums2, int n) {
		if (m == 0) {
			for (int i = 0; i < n; i++) {
				nums1[i] = nums2[i];
			}
		}
		if (n == 0) {
			return;
		}
		int i = m - 1;
		int j = n - 1;
		int tail = m + n - 1;
		while (i >= 0 && j >= 0) {
			if (nums1[i] >= nums2[j]) {
				nums1[tail--] = nums1[i--];
			} else if (nums1[i] < nums2[j]) {
				nums1[tail--] = nums2[j--];
			}
		}
		while (i >= 0) {
			nums1[tail--] = nums1[i--];
		}
		while (j >= 0) {
			nums1[tail--] = nums2[i--];
		}
	}
}
