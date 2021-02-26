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
	}

	public int[] searchRange(int[] nums, int target) {
		int n = nums.length;
		if (n == 0)
			return new int[] { -1, -1 };
		return new int[] { getLeft(nums, target), getRight(nums, target) };
	}

	public  int getLeft(int a[], int target) {
		int low = 0;
		int high = a.length - 1;
		while (low <= high) {
			int mid = (low + high) / 2;
			if (a[mid] == target) {
				high = mid - 1;
			} else if (a[mid] > target) {
				high = mid - 1;
			} else {
				low = mid + 1;
			}
		}
		if (low < a.length) {
			return a[low] == target ? low : -1;
		} else {
			return -1;
		}

	}

	public  int getRight(int a[], int target) {
		int low = 0;
		int high = a.length - 1;
		while (low <= high) {
			int mid = (low + high) / 2;
			if (a[mid] == target) {
				low = mid + 1;
			} else if (a[mid] > target) {
				high = mid - 1;
			} else {
				low = mid + 1;
			}
		}
		if (low > 0) {
			return a[low - 1] == target ? low - 1 : -1;
		} else {
			return a[low] == target ? low : -1;
		}

	}
}
