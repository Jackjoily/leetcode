package leetcode_array;

import java.util.Arrays;

/**
 * 给定一个按照升序排列的整数数组 nums，和一个目标值 target。 找出给定目标值在数组中的开始位置和结束位置。
 * 
 * @author jackjoily
 *
 */
public class M_34 {

	public static void main(String[] args) {
		M_34 m = new M_34();
		int a[] = { 5, 7, 7, 8, 8, 10 };
		System.out.println(Arrays.toString(m.searchRange1(a, 8)));
	}

	public int[] searchRange(int[] nums, int target) {
		if (nums.length == 0) {
			return new int[] { -1, -1 };
		}
		if (nums[0] > target) {
			return new int[] { -1, -1 };
		}
		if (nums[nums.length - 1] < target) {
			return new int[] { -1, -1 };
		}
		int start = 0, end = nums.length - 1;
		boolean flag = true;
		while (start <= end && flag) {
			while (start < nums.length && nums[start] != target)
				start++;
			while (end >= 0 && nums[end] != target)
				end--;
			if (start < nums.length && end >= 0 && nums[start] == nums[end] && nums[end] == target) {
				flag = false;
			}
		}
		if (!flag) {
			return new int[] { start, end };
		} else {
			return new int[] { -1, -1 };
		}

	}

	public int[] searchRange1(int[] nums, int target) {
		if (nums.length == 0) {
			return new int[] { -1, -1 };
		}
		if (nums[0] > target) {
			return new int[] { -1, -1 };
		}
		if (nums[nums.length - 1] < target) {
			return new int[] { -1, -1 };
		}
		int i = 0, j = nums.length - 1, mid = 0;
		int start = 0, end = 0;
		while (i >= 0 && j < nums.length && i <= j) {
			mid = (i + j) / 2;
			if (nums[mid] == target) {
				start = mid-1;
				end = mid + 1;
				while (start>= 0 && nums[start] == target)
					start--;
				while (end < nums.length && nums[end] == target)
					end++;
				if (start >= 0 && end < nums.length) {
					if (nums[start] == nums[end] && nums[start] == target) {
						return new int[] { start, end };
					} else if (nums[start] != target && nums[end] != target) {
						return new int[] { mid, mid };
					} else if (nums[start] == target) {
						return new int[] { start, mid };
					} else if (nums[end] == target) {
						return new int[] { mid, end };
					}
				}

			} else if (nums[mid] > target) {
				j = mid - 1;
			} else {
				i = mid + 1;
			}
		}
		return new int[] { -1, -1 };
	}

}
