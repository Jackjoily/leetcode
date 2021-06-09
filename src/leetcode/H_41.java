package leetcode;

import java.util.Arrays;
import java.util.HashMap;

import com.sun.org.apache.xerces.internal.util.SynchronizedSymbolTable;

/**
 * twosum
 * 
 * @author jackjoily
 *
 */
public class H_41 {
	public int firstMissingPositive1(int[] nums) {
		int n = nums.length;
		if (n == 0)
			return 1;
		for (int i = 0; i < n; i++) {
			if (nums[i] < 0) {
				nums[i] = n + 1;
			}
		}
		for (int i = 0; i < n; i++) {
			if (nums[i] < n) {
				nums[nums[i] - 1] = -Math.abs(nums[nums[i] - 1]);
			}
		}
		for (int i = 0; i < n; i++) {
			if (nums[i] > 0) {
				return i + 1;
			}
		}
		return n;
	}

	public int firstMissingPositive(int[] nums) {
		if (nums.length == 0)
			return 1;
		Arrays.sort(nums);
		// 最左端大于0的情况
		if (nums[0] >= 0) {
			if (nums[0] - 1 > 0)
				return 1;
			else {
				int i = 0;
				for (; i < nums.length - 1; i++) {
					if (nums[i + 1] - nums[i] > 1) {
						return nums[i] + 1;
					}
				}
				return nums[i] + 1;
			}
		}
		// 最右端小于0的情况
		else if (nums[nums.length - 1] < 0) {
			return 1;
		} else {
			int i = 0;
			for (; i < nums.length; i++) {
				if (nums[i] > 0) {
					if (nums[i] > 1) {
						return 1;
					} else if (nums[i] == 1) {
						int j = i;
						for (; j < nums.length - 1; j++) {
							if (nums[j + 1] - nums[j] > 1) {
								return nums[j] + 1;
							}
						}
						return nums[j] + 1;
					}
				}
			}
		}
		return 0;
	}
}
