package basic;

import java.util.Arrays;

public class Sort {
	public static void main(String[] args) {
		int a[] = gennerateArray(20, 100);
		int temp[] = new int[a.length];
		sort(a);
	}

	public static void sort(int a[]) {
		int temp[] = new int[101];
		for (int i = 0; i < a.length; i++) {
			temp[a[i]]++;
		}
		for (int i = 0; i < 101; i++) {
			if (temp[i] > 0) {
				for (int j = 0; j < temp[i]; j++) {
					System.out.print(i+" ");
				}
				System.out.println();
			}
		}

	}

	public static int[] gennerateArray(int len, int max) {
		int[] arr = new int[len];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = (int) (Math.random() * max);
		}
		return arr;
	}

	/**
	 * 冒泡算法
	 * 
	 * @param a
	 */
	public static void bubbleSort(int a[]) {
		for (int i = 0; i < a.length - 1; i++) {
			boolean flag = false;
			for (int j = a.length - 1; j > i; j--) {
				if (a[j - 1] > a[j]) {
					swap(a, j - 1, j);
					flag = true;
				}
			}
			if (!flag)
				return;
		}
	}

	/**
	 * 插入排序算法
	 * 
	 * @param a
	 * @param low
	 * @param high
	 */
	public static void quickSort(int a[], int low, int high) {
		if (low < high) {
			int pivot = partition(a, low, high);
			quickSort(a, low, pivot - 1);
			quickSort(a, pivot + 1, high);
		}
	}

	public static int partition(int a[], int low, int high) {
		int pivot = a[low];
		while (low < high) {
			while (low < high && a[high] >= pivot)
				high--;
			a[low] = a[high];
			while (low < high && a[low] <= pivot)
				low++;
			a[high] = a[low];
		}
		a[low] = pivot;
		return low;
	}

	/**
	 * 归并排序算法
	 * 
	 * @param a
	 * @param low
	 * @param high
	 * @param temp
	 */
	public static void mergeSort(int a[], int low, int high, int temp[]) {
		if (low < high) {
			int mid = (low + high) / 2;
			mergeSort(a, low, mid, temp);
			mergeSort(a, mid + 1, high, temp);
			merge(a, low, mid, high, temp);
		}
	}

	public static void merge(int a[], int low, int mid, int high, int temp[]) {
		int i, j, k;
		for (k = low; k <= high; k++) {
			temp[k] = a[k];
		}
		for (i = low, j = mid + 1, k = i; i <= mid && j <= high;) {
			if (temp[i] > temp[j]) {
				a[k++] = temp[j++];
			} else {
				a[k++] = temp[i++];
			}
		}
		while (i <= mid) {
			a[k++] = temp[i++];
		}
		while (j <= high) {
			a[k++] = temp[j++];
		}
	}

	public static void swap(int a[], int i, int j) {
		int temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}

}
