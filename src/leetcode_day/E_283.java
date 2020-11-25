package leetcode_day;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * 
 * 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序
 *
 *
 *
 */
public class E_283 {
	public static void main(String[] args) {
		int a[] = { 1, 0, 1 };
		moveZeroes(a);
		System.out.println(Arrays.toString(a));
	}
	public static void moveZeroes(int[] nums) {
		if (nums.length <= 1)
			return;
		int j = 0, i = 0, k = 0;
		while (k < nums.length) {
			if (nums[i] == 0) {
				for (j = i; j < nums.length - 1; j++) {
					nums[j] = nums[j + 1];
				}
				nums[j] = 0;
			}
			if (nums[i] != 0) {
				i++;
			}
			k++;
		}
	}
	/**
	 * 使用双指针方法
	 */
	public void moveZeroes1(int[] nums) {
		int n = nums.length, left = 0, right = 0;
		while (right < n) {
			if (nums[right] != 0) {
				swap(nums, left, right);
				left++;
			}
			right++;
		}
	}
	public void swap(int[] nums, int left, int right) {
		int temp = nums[left];
		nums[left] = nums[right];
		nums[right] = temp;
	}

}
