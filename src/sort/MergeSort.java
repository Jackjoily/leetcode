package sort;

import java.util.Arrays;

import com.sun.swing.internal.plaf.metal.resources.metal_ja;

public class MergeSort {

	public static void main(String[] args) {
		MergeSort m = new MergeSort();
		int a[] = { 9, 8, 7, 6, 5, 4, 3, 2, 1 };
		m.mergeSort(a, 0, a.length - 1);
		System.out.println(Arrays.toString(a));
	}

	int temp[] = new int[1000];

	public void mergeSort(int a[], int low, int high) {
		if (low < high) {
			int mid = (low + high) / 2;
			mergeSort(a, low, mid);
			mergeSort(a, mid + 1, high);
			merge(a, low, mid, high, temp);
		}
	}

	public void merge(int a[], int low, int mid, int high, int temp[]) {
		int i = 0, j = 0, k = 0;
		for (k = low; k <= high; k++) {
			temp[k] = a[k];
		}
		for (i = low, j = mid + 1, k = i; i <= mid && j <= high; k++) {
			if (temp[i] < temp[j]) {
				a[k] = temp[i++];
			} else {
				a[k] = temp[j++];
			}
		}
		while (i <= mid)
			a[k++] = temp[i++];
		while (j <= high)
			a[k++] = temp[j++];

	}

}
