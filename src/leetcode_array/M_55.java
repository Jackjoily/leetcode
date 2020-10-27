package leetcode_array;

import java.util.LinkedList;

public class M_55 {

	/**
	 * 给定一个非负整数数组，你最初位于数组的第一个位置。
	 * 
	 * 数组中的每个元素代表你在该位置可以跳跃的最大长度。
	 * 
	 * 判断你是否能够到达最后一个位置。
	 * 
	 * @param nums
	 * @return
	 */

	public static void main(String[] args) {
		M_55 m = new M_55();
		int a[] = { 3, 2, 1, 0, 4 };
		System.out.println(m.canJump(a));
	}

	boolean flag = false;

	public boolean canJump(int[] nums) {
		if (nums.length == 0)
			return true;
		int n = nums.length;
		int rightmost = 0;
		for (int i = 0; i < n; i++) {
			if (i < rightmost) {
				rightmost = Math.max(rightmost, i + nums[i]);
			}
			if (rightmost >= n - 1) {
				return true;
			}
		}
		return flag;
	}

	public void f(int nums[], int start) {
		if (start >= nums.length - 1) {
			this.flag = true;
			return;
		}
		if (nums[start] == 0)
			return;
		for (int i = 1; i <= nums[start]; i++) {
			start += i;
			f(nums, start);
			start -= i;
		}
	}
}
