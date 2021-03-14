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
public class M_16 {
	public static void main(String[] args) {
		int a[] = { -1, 2, 1, -4 };
		System.out.println(threeSumClosest(a, 1));
	}

	public static int threeSumClosest(int[] nums, int target) {
		Arrays.sort(nums);
		int a, b, c;
		int val = 0;
		int small = Integer.MAX_VALUE;
		for (int i = 0; i < nums.length - 2; i++) {
			if (i > 0 && nums[i] == nums[i - 1])
				continue;
			int j = i + 1, k = nums.length - 1;
			while (j < k) {
				int sum = nums[i] + nums[j] + nums[k];
				if (sum == target) {
					return target;
				}
				if (Math.abs(sum - target) < Math.abs(small - target)) {
					small = sum;
				}
				if (sum > target) {
					// 如果和大于 target，移动 c 对应的指针
					int k0 = k - 1;
					// 移动到下一个不相等的元素
					while (j < k0 && nums[k0] == nums[k]) {
						--k0;
					}
					k = k0;
				} else {
					// 如果和小于 target，移动 b 对应的指针
					int j0 = j + 1;
					// 移动到下一个不相等的元素
					while (j0 < k && nums[j0] == nums[j]) {
						++j0;
					}
					j = j0;
				}
			}
		}
		return small;
	}
}
