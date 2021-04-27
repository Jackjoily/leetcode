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
public class E_219II {
	public static void main(String[] args) {
		int a[] = {1,2,3,1,2,3};
		System.out.println(containsNearbyDuplicate(a, 2));
	}

	public static boolean containsNearbyDuplicate(int[] nums, int k) {
		for (int i = 0; i < nums.length; i++) {
			int l = 1;
			int j = i + l;
			for (; j < nums.length && l <= k; l++) {
				if (nums[i] == nums[j])
					return true;
				j++;
			}
		}
		return false;
	}
}
