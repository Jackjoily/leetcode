package leetcode_array;

import java.util.LinkedList;

/**
 * 
 * @author jackjoily
 *
 */
public class M_16 {
	public static void main(String[] args) {
		M_16 m = new M_16();
		int[] nums = { 1, 1, 1, 0 };
		m.threeSumClosest(nums, -100);
		System.out.println(m.val1);
	}

	int val = Integer.MAX_VALUE;
	int val1 = 0;
	LinkedList<Integer> list = new LinkedList<>();

	public int threeSumClosest(int[] nums, int target) {
		f(nums, 0, 0, 0, target);
		return val1;
	}

	public void f(int nums[], int cur, int sum, int count, int target) {
		if (count == 3) {
			int temp = Math.abs(sum - target);
			if (temp < val) {
				val = temp;
				val1 = 0;
				for (int i : list) {
					val1 += i;
				}
			}
			return;
		}
		for (int i = cur; i < nums.length; i++) {
			list.add(nums[i]);
			sum += nums[i];
			f(nums, i + 1, sum, count + 1, target);
			sum -= nums[i];
			list.removeLast();
		}
	}

}
