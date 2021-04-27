package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import com.sun.org.apache.xerces.internal.util.SynchronizedSymbolTable;

/**
 * twosum
 * 
 * @author jackjoily
 *
 */
public class JianZhiOffer56I {
	public static void main(String[] args) {
		int a[] = { 1, 2, 10, 4, 1, 4, 3, 3 };
		System.out.println(Arrays.toString(singleNumbers(a)));
	}

	public static int[] singleNumbers(int[] nums) {
		int k = 0;
		int i = 0;
		int a[] = new int[2];
		while (i< nums.length) {
			k ^= nums[i];
			i++;
		}
		int mask = 1;
		while ((mask&k)==0) {
			mask <<= 1;
		}
		i = 0;
		for (; i < nums.length; i++) {
			if ((nums[i] & mask) == 0) {
				a[0] ^= nums[i];
			} else {
				a[1] ^= nums[i];
			}
		}
		return a;
	}
}
