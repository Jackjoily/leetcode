package leetcode;

import java.util.Arrays;
import java.util.HashMap;

import com.sun.org.apache.xerces.internal.util.SynchronizedSymbolTable;

/**
 * twosum
 * 
 * @author jackjoily
 *
 */
public class MianShi1714 {
	public static void main(String[] args) {
		int a[] = { 1, 3, 2, 3, 5, 6, 7, 8, 5, 7, 2, 4, 6, 8 };
		System.out.println(Arrays.toString(smallestK(a, 4)));
	}

	public static int[] smallestK(int[] arr, int k) {
		sort(arr, 0, arr.length - 1, k);
		int b[] = new int[k];
		for (int i = 0; i < k; i++) {
			b[i] = arr[i];
		}
		return b;
	}

	public static void sort(int a[], int low, int high, int k) {
		while (low < high) {
			int num = partition(a, low, high);
			if (num == k)
				return;
			else if (num < k) {
				low = num + 1;
			} else {
				high = num - 1;
			}
		}
	}

	public static int partition(int a[], int low, int high) {
		int temp = a[low];
		while (low < high) {
			while (low < high && a[high] >= temp)
				high--;
			a[low] = a[high];
			while (low < high && a[low] <= temp)
				low++;
			a[high] = a[low];
		}
		a[low] = temp;
		return low;
	}

}
