package JianZhiOffer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * 一个整型数组 nums 里除两个数字之外，其他数字都出现了两次。 请写程序找出这两个只出现一次的数字。 要求时间复杂度是O(n)，空间复杂度是O(1)。
 * 
 * @author jackjoily
 *
 */
public class JianZhiOffer56_I {
	public static void main(String[] args) {
		int a[] = { 1, 2, 10, 4, 1, 4, 3, 3 };
		System.out.println(Arrays.toString(singleNumbers1(a)));
	}

	public static int[] singleNumbers(int[] nums) {
		Map<Integer, Integer> map = new HashMap<>();
		if (nums.length < 4) {
			return nums;
		}
		HashSet<Integer> set = new HashSet<>();
		for (int i = 0; i < nums.length; i++) {
			if (!map.containsKey(nums[i])) {
				set.add(nums[i]);
				map.put(nums[i], 1);
			} else {
				set.remove(nums[i]);
			}
		}
		int a[] = new int[set.size()];
		Iterator<Integer> iterator = set.iterator();
		int i = 0;
		while (iterator.hasNext()) {
			a[i] = iterator.next();
			i++;
		}
		return a;
	}

	/**
	 * 采用亦或的方法
	 */
	public static int[] singleNumbers1(int[] nums) {
		int ret = 0;
		int i = 0;
		// 将所有的数亦或一遍
		while (i < nums.length) {
			ret ^= nums[i];
			i++;
		}
		int mask = 1;
		while ((mask & ret) == 0) {
			mask <<= 1;
		}
		int a = 0, b = 0;
		for (int k : nums) {
			if ((k & mask) == 0) {
				a ^= k;
			} else {
				b ^= k;
			}
		}
		return new int[] { a, b };
	}
}
