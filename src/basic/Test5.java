package basic;

import java.util.Arrays;

public class Test5 {
	public static void main(String[] args) {
		Test5 t = new Test5();
		int a[] = { 5, 2, 3, 1 };
		t.sortArray(a);
		System.out.println(Arrays.toString(a));
	}

	public int[] sortArray(int[] nums) {
		int n = nums.length;
		if (n == 1)
			return nums;
		quickSort(nums, 0, n - 1);
		return nums;
	}

	public void quickSort(int a[], int low, int high) {
		if (low < high) {
			int inx = partion(a, low, high);
			quickSort(a, low, inx - 1);
			quickSort(a, inx + 1, high);
		}
	}

	public int partion(int a[], int low, int high) {
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
}
