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
public class E_414 {
	public static void main(String[] args) {
		int a[] = { 1, -2147483648, 2 };
		System.out.println(thirdMax(a));
	}

	public static int thirdMax(int[] nums) {
		int n = nums.length;
		if (n == 1)
			return nums[0];
		if (n == 2)
			return nums[0] > nums[1] ? nums[0] : nums[1];
		long a = Long.MIN_VALUE, b = Long.MIN_VALUE, c = Long.MIN_VALUE;
		for (int i : nums) {
			if (i == a || i == b || i == c)
				continue;
			if (i > a) {
				c=b;
				b = a;
				a = i;
			} else if (i > b) {
				c = b;
				b = i;
			} else if (i > c) {
				c = i;
			}
		}
		return (int) (c == Long.MIN_VALUE ? a : c);
	}
}
