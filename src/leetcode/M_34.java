package leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

import leetcode_list.ListNode;

/**
 * 
 * @author jackjoily
 *
 */
public class M_34 {
	public static void main(String[] args) {
		M_34 m = new M_34();
		int a[] = { 1 };
		m.searchRange(a, 0);
	}

	public int[] searchRange(int[] nums, int target) {
		int left = searchLeft(nums, target);
		int right = searchRight(nums, target);
		System.out.println(left);
		System.out.println(right);
		int a[] = new int[2];
		a[0] = left;
		a[1] = right;
		return a;
	}

	public int searchLeft(int a[], int b) {
		int low = 0;
		int high = a.length - 1;
		while (low <= high) {
			int mid = (high + low) / 2;
			if (a[mid] == b) {
				high = mid - 1;
			} else if (a[mid] > b) {
				high = mid - 1;
			} else {
				low = mid + 1;
			}
		}
		if (low == a.length)
			return -1;
		return a[low] == b ? low : -1;
	}

	public int searchRight(int a[], int b) {
		int low = 0;
		int high = a.length - 1;
		while (low <= high) {
			int mid = (high + low) / 2;
			if (a[mid] == b) {
				low = mid + 1;
			} else if (a[mid] > b) {
				high = mid - 1;
			} else {
				low = mid + 1;
			}
		}
		if (high == -1)
			return -1;
		return a[high] == b ? high : -1;
	}
}
