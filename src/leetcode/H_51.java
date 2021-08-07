package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 
 * @author jackjoily
 *
 */
public class H_51 {

	public static void main(String[] args) {
		H_51 h = new H_51();
		int a[] = { 1, 3, 432, 5465, 756, 876, 86798, 345, 345, 645, 678, 24, 678, 4, 6, 8, 9, 3554, 647, 879, 2 };
		int temp[] = new int[a.length];
		h.megerSort(a, 0, a.length - 1, temp);

	}

	public int reversePairs(int[] nums) {
		int n = nums.length;
		if (n<=1)
			return 0;
		int temp[] = new int[n];
		return megerSort(nums, 0, n - 1, temp);
	}

	public int megerSort(int a[], int low, int high, int temp[]) {
		if (low < high) {
			int mid = (high + low) / 2;
			int left = megerSort(a, low, mid, temp);
			int right = megerSort(a, mid + 1, high, temp);
			int left_right = merge(a, low, mid, high, temp);
			return left + right + left_right;
		} else {
			return 0;
		}
	}

	public int merge(int a[], int low, int mid, int high, int temp[]) {
		int i = 0, j = 0, k = low;
		int count = 0;
		for (; k <= high; k++) {
			temp[k] = a[k];
		}
		for (k = low, i = low, j = mid + 1; i <= mid && j <= high;) {
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
