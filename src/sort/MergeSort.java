package sort;

import java.util.Arrays;

import com.sun.swing.internal.plaf.metal.resources.metal_ja;

public class MergeSort {

	public static void main(String[] args) {
		int a[] = { 9, 8, 7, 6, 5, 4, 3, 2, 1 };
		int[] temp = new int[a.length];
		sort(a, 0, a.length - 1, temp);
		System.out.println(count);
	}

	/**
	 * 
	 * @param a
	 *            a[left...right]
	 * @param left
	 * @param right
	 */
	public static void sort(int a[], int left, int right, int[] temp) {
		if (left < right) {
			int mid = (left + right) / 2;
			sort(a, left, mid, temp);
			sort(a, mid + 1, right, temp);
			merge(a, left, mid, right, temp);
		}
	}

	static int count = 0;

	public static void merge(int a[], int left, int mid, int right, int[] temp) {
		int i = left;
		int j = mid + 1;
		int k = left;
		while (i <= mid && j <= right) {
			if (a[i] < a[j]) {
				temp[k++] = a[i++];
			} else
				count += (mid - i + 1);
				temp[k++] = a[j++];
		}
		while (i <= mid) {
			temp[k++] = a[i++];
		}
		while (j <= right) {
			temp[k++] = a[j++];
		}
		for (k = left; k <= right; k++) {
			a[k] = temp[k];
		}
	}

}
