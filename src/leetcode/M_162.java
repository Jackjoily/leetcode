package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

import com.sun.xml.internal.bind.v2.runtime.unmarshaller.XsiNilLoader.Array;

import leetcode_list.ListNode;

/**
 * 
 * @author jackjoily
 *
 */
public class M_162 {
	public static void main(String[] args) {
		int a[] = { 1, 2, 1, 3, 5, 6, 4 };
		System.out.println(findPeakElement(a));
	}

	public static int findPeakElement(int[] nums) {
		int left = 0, right = nums.length - 1;
		for (; left < right;) {
			int mid = left + (right - left) / 2;
			if (nums[mid] > nums[mid + 1]) {
				right = mid;
			} else {
				left = mid + 1;
			}
		}
		return left;
	}
}