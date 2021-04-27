package leetcode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Queue;

import javafx.scene.shape.Line;
import leetcode_list.ListNode;
import leetcode_tree.TreeNode;

/**
 * 
 * @author jackjoily
 *
 */
public class M_912 {
	public static void main(String[] args) {
		M_912 m = new M_912();
		int a[] = { 9, 8, 7, 6, 5, 4, 3, 2, 1 };
		System.out.println(Arrays.toString(m.sortArray(a)));
	}

	public int[] sortArray(int[] nums) {
		int n = nums.length;
		if (n == 1)
			return nums;
		int temp[] = new int[n];
		mergeSort(nums, 0, n - 1, temp);
		return nums;
	}

	public void mergeSort(int a[], int low, int high, int[] temp) {
		if (low < high) {
			int mid = low + (high - low) / 2;
			mergeSort(a, low, mid, temp);
			mergeSort(a, mid + 1, high, temp);
			merge(a, low, mid, high, temp);
		}
	}

	private void merge(int[] a, int low, int mid, int high, int temp[]) {
		int i, j, k;
		// swap
		for (k = low; k <= high; k++) {
			temp[k] = a[k];
		}
		for (i = low, k = low, j = mid + 1; i <= mid && j <= high;) {
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
}
