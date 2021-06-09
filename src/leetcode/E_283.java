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
public class E_283 {
	public static void main(String[] args) {
		int a[] = { 0,0, 0, 3, 12 };
		moveZeroes(a);
		System.out.println(Arrays.toString(a));
	}

	public static void moveZeroes(int[] nums) {
		int n = nums.length;
		if (n <= 1)
			return;
		int inx = 0;
		int start = 0;
		while (start < n) {
			if (nums[start] != 0) {
				nums[inx] = nums[start];
				start++;
				inx++;
			} else {
				start++;
			}
		}
		while (inx < n) {
			nums[inx++] = 0;
		}
	}
}