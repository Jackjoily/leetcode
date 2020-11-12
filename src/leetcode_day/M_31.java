package leetcode_day;

import java.util.Arrays;

public class M_31 {
	public static void main(String[] args) {
		int a[] = {5,1,1};
	nextPermutation(a);
		System.out.println(Arrays.toString(a));
	}

	public static void nextPermutation(int[] nums) {
		if (nums.length <= 1)
			return;
		int i = nums.length - 1;
		while (i > 0 && nums[i] <= nums[i - 1])
			i--;
		if (i == 0) {
			Arrays.sort(nums);
			return;
		}
		int j = i - 1;
		for (i = nums.length - 1; i > j; i--) {
			if (nums[i] > nums[j])
				break;
		}
		int temp = nums[j];
		nums[j] = nums[i];
		nums[i] = temp;
		Arrays.sort(nums, j + 1, nums.length);
	}
}
