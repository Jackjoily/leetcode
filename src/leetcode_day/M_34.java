package leetcode_day;

import java.util.Arrays;

import com.sun.xml.internal.bind.v2.runtime.unmarshaller.XsiNilLoader.Array;

import leetcode_list.ListNode;

public class M_34 {
	/**
	 * 
	 * 
	 * 给定一个按照升序排列的整数数组 nums，和一个目标值 target。 找出给定目标值在数组中的开始位置和结束位置。 如果数组中不存在目标值
	 * target，返回 [-1, -1]。
	 * 
	 */
	public static void main(String[] args) {
		M_34 m = new M_34();
		int a[] = { 5, 7, 7, 8, 8, 10 };
		int[] searchRange = m.searchRange(a, 8);
		System.out.println(Arrays.toString(searchRange));
	}

	public int[] searchRange(int[] nums, int target) {
		if (nums.length == 0)
			return new int[] { -1, -1 };
		int left = findFirstPosition(nums, target);
		if (left == -1) {
			return new int[] { -1, -1 };
		}
		int right = findLastPosition(nums, target);
		return new int[] { left, right };
	}

	public int findFirstPosition(int nums[], int target) {
		int left = 0;
		int right = nums.length - 1;
		while (left < right) {
			int mid = (left + right) / 2;
			if (nums[mid] < target) {
				left = mid + 1;
			} else if (nums[mid] == target) {
				right = mid;
			} else {
				right = mid - 1;
			}
		}
		if (nums[left] == target)
			return left;
		else {
			return -1;
		}
	}

	public int findLastPosition(int nums[], int target) {
		int left = 0;
		int right = nums.length - 1;
		while (left < right) {
			int mid = (left + right) / 2+1;
			if (nums[mid] > target) {
				right = mid - 1;
			} else if (nums[mid] == target) {
				left = mid;
			} else {
				left = mid + 1;
			}
		}
		if (nums[right] == target)
			return right;
		else {
			return -1;
		}
	}

	public static int[] searchRange1(int[] nums, int target) {
		int i = 0, j = nums.length - 1;
		if (i < j) {
			while (i < j && nums[i] != target)
				i++;
			while (i < j && nums[j] != target)
				j--;
		}

		if (i > j)
			return new int[] { -1, -1 };
		else {
			if (nums[i] == nums[j] && nums[j] == target) {
				return new int[] { i, j };
			}
			return new int[] { -1, -1 };
		}
	}
}
