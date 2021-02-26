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
public class M_1691 {
	public static void main(String[] args) {

	}

	public int rob(int[] nums) {
		int n = nums.length;
		if (n == 0)
			return 0;
		if (n == 1)
			return nums[0];
		if (n == 2)
			return Math.max(nums[0], nums[1]);
		int max = 0;
		int hold[] = new int[n];
		int uhold[] = new int[n];
		hold[0] = nums[0];
		for (int i = 1; i < n; i++) {
			hold[i] = Math.max(uhold[i - 1] + nums[i], hold[i - 1]);
			uhold[i] = Math.max(uhold[i - 1], hold[i - 1]);
			max = Math.max(hold[i], uhold[i]);
		}
		return max;
	}
}
