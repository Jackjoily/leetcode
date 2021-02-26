package basic;

import java.util.Arrays;

public class HeapTest {
	public static void main(String[] args) {
		int a[] = { 1, 2, 3, 4, 5, 6, 7 };
		HeapSort(a);
	}

	/**
	 * 建立一个大顶堆
	 * 
	 * @param a
	 */
	public static void buildBigHeap(int a[], int n) {
		for (int i = n; i >= 1; i--) {
			int j = i;
			while (j >= 0) {
				int p = (j - 1) / 2;
				if (a[j] > a[p]) {
					int temp = a[j];
					a[j] = a[p];
					a[p] = temp;
					j = p;
				} else {
					break;
				}
			}
		}
	}

	public static void HeapSort(int a[]) {
		for (int i = a.length - 1; i >= 0; i--) {
			buildBigHeap(a, i);
			System.out.println(a[0]);
			a[0] = a[i];
		}
	}

	/**
	 * 建立一个小顶堆
	 * 
	 * @param a
	 */
	public static void buildSmallHeap(int a[]) {
		for (int i = a.length - 1; i >= 1; i--) {
			int j = i;
			while (j >= 0) {
				int p = (j - 1) / 2;
				if (a[j] < a[p]) {
					int temp = a[j];
					a[j] = a[p];
					a[p] = temp;
					j = p;
				} else {
					break;
				}
			}
		}
	}
}
