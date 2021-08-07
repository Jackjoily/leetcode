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
public class M_33 {

	public static void main(String[] args) {
		int a[] = { 5, 1, 3 };
		System.out.println(search(a, 5));
	}

	public static int search(int[] nums, int target) {
		int high = nums.length - 1;
		if (high == 0)
			return nums[0] == target ? 0 : -1;
		int low = 0;
		while (low <= high) {
			int mid = (high + low) / 2;
			if (nums[mid] == target)
				return mid;
			else {
				if (nums[0] <= mid) {
					if (nums[0] <= target && nums[mid] > target) {
						high =mid-1;
					} else {
                       low=mid+1;
					}
				} else {
					if (nums[mid] < target && nums[nums.length -1] >= target) {
						low=mid+1;
					} else {
                       high=mid-1;
					}
				}
			}
		}
		return -1;
	}
}
