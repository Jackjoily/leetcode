package leetcode;

import java.util.Arrays;
import java.util.HashMap;

import com.sun.org.apache.xerces.internal.util.SynchronizedSymbolTable;

/**
 * 
 * @author jackjoily
 *
 */
public class E_26 {
	public static void main(String[] args) {
		int a[] = { 0, 0, 1, 1, 1, 2, 2, 3, 3, 4 };
		System.out.println(removeDuplicates(a));
	}

	public static int removeDuplicates(int[] nums) {
		int n = nums.length;
		if (n <= 1)
			return n;
		int i = 0, j = 1;
		for (; j < n; j++) {
			if (nums[i] != nums[j]) {
				i++;
				nums[i] = nums[j];
			}
		}
		return i+1;
	}
}
