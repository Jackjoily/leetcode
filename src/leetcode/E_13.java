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
public class E_13 {
	public static void main(String[] args) {
		int a[] = {2,7,11,15 };
		System.out.println(Arrays.toString(twoSum(a, 9)));
	}

	public static int[] twoSum(int[] nums, int target) {
		HashMap<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < nums.length; i++) {
			int j = target - nums[i];
			if (map.containsKey(j)) {
				return new int[] { map.get(j), i };
			} else {
				map.put(nums[i], i);
			}
		}
		return new int[] {};
	}
}
