package leetcode_array;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 
 * 给定一个范围在  1 ≤ a[i] ≤ n ( n = 数组大小 ) 的 整型数组，数组中的元素一些出现了两次，另一些只出现一次。
 * 
 * 找到所有在 [1, n] 范围之间没有出现在数组中的数字。
 * 
 * 您能在不使用额外空间且时间复杂度为O(n)的情况下完成这个任务吗? 你可以假定返回的数组不算在额外空间内。
 * 
 * @author jackjoily
 *
 */
public class E_448 {

	public static void main(String[] args) {
		int a[] = { 4, 3, 2, 7, 8, 2, 3, 1 };
		System.out.println(findDisappearedNumbers1(a));
	}

	public static List<Integer> findDisappearedNumbers(int[] nums) {
		List<Integer> list = new ArrayList<>();
		int a[] = new int[nums.length];
		for (int i : nums) {
			a[i - 1]++;
		}
		for (int i = 0; i < a.length; i++) {
			if (a[i] == 0) {
				list.add(i + 1);
			}
		}
		return list;
	}

	public static List<Integer> findDisappearedNumbers1(int[] nums) {
		List<Integer> list = new ArrayList<>();
		for (int i = 0; i < nums.length; i++) {
			int index = (nums[i] - 1) % nums.length;
			nums[index] += nums.length;
		}
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] <= nums.length) {
				list.add(i + 1);
			}
		}
		return list;
	}

}
