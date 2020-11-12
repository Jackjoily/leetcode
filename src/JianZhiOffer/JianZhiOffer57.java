package JianZhiOffer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * 输入一个递增排序的数组和一个数字s， 在数组中查找两个数， 使得它们的和正好是s。 如果有多对数字的和等于s，则输出任意一对即可。
 * 
 * @author jackjoily
 *
 */
public class JianZhiOffer57 {
	public static void main(String[] args) {
		int a[] = { 10,26,30,31,47,60};
		int[] twoSum = twoSum(a, 40);
		System.out.println(Arrays.toString(twoSum));
	}

	public static int[] twoSum(int[] nums, int target) {
		if (nums.length == 1)
			return new int[0];
		if (nums.length == 2)
			return (nums[0] + nums[1]) == target ? new int[0] : new int[] { nums[0], nums[1] };
		int i = 0, j = nums.length - 1, k = 0;
		while (i < j) {
			if ((nums[i] + nums[j]) == target)
				return new int[] { nums[i], nums[j] };
			while (i < j && (nums[i] + nums[j]) < target)
				i++;
			if ((nums[i] + nums[j]) == target)
				return new int[] { nums[i], nums[j] };
			while (i < j && (nums[i] + nums[j]) > target)
				j--;
			if ((nums[i] + nums[j]) == target)
				return new int[] { nums[i], nums[j] };
		}
		return new int[0];
	}
}
