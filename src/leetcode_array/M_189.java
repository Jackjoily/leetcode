package leetcode_array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 给定一个数组，将数组中的元素向右移动 k 个位置，其中 k 是非负数
 * 
 * @author jackjoily
 *
 */
public class M_189 {
	public static void main(String[] args) {
		int a[] = { -1,-100,3,99 };
		rotate(a, 0);
		System.out.println(Arrays.toString(a));
	}

	public static void rotate(int[] nums, int k) {
		int n = nums.length;
		k %= n;
		if (k != 0) {
			reverse(nums, 0, n - 1);
			reverse(nums, 0, k - 1);
			reverse(nums, k, n-1);
		}
	}

	public static void reverse(int nums[], int start, int end) {
		int i = 0;
		int mid = (start + end) / 2;
		while ((i+start) <= mid) {
			int temp = nums[i+start];
			nums[i+start] = nums[end - i];
			nums[end - i] = temp;
			i++;
		}
	}
}
