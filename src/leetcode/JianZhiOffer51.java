package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import com.sun.org.apache.xerces.internal.util.SynchronizedSymbolTable;

/**
 * twosum
 * 
 * @author jackjoily
 *
 */
public class JianZhiOffer51 {
	public static void main(String[] args) {
		int a[] = { 1,3,2,3,1 };
		JianZhiOffer51 j = new JianZhiOffer51();
		System.out.println(j.reversePairs(a));
	}

	public int reversePairs(int[] nums) {
		int n = nums.length;
		if (n <= 1)
			return 0;
		int copy[] = new int[n];
		for (int i = 0; i < n; i++) {
			copy[i] = nums[i];
		}
		int temp[] = new int[n];
		int a = reversePairs(copy, 0, n - 1, temp);
		return a;
	}

	public int reversePairs(int a[], int low, int high, int[] temp) {
		if (low == high)
			return 0;
		int mid = (low + high) / 2;
		int leftCount = reversePairs(a, low, mid, temp);
		int rightCount = reversePairs(a, mid + 1, high, temp);
		int crossCount = mergeCount(a, low, mid, high, temp);
		return leftCount + rightCount + crossCount;
	}

	public int mergeCount(int[] a, int low, int mid, int high, int temp[]) {
		int count = 0;
		int i = 0, j = 0, k = 0;
		for (k = low; k <= high; k++) {
			temp[k] = a[k];
		}
		for (i = low, j = mid + 1, k = i; i <= mid && j <= high;) {
			if (temp[i] < temp[j]) {
				a[k++] = temp[i++];
			} else if (temp[i] == temp[j]) {
				a[k++] = temp[i++];
			} else {
				count += mid - i + 1;
				a[k++] = temp[j++];
			}
		}
		while (i <= mid) {
			a[k++] = temp[i++];
		}
		while (j <= high) {
			a[k++] = temp[j++];
		}
		return count;
	}

}
