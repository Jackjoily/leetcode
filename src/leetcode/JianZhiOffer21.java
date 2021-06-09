package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import com.sun.org.apache.xerces.internal.util.SynchronizedSymbolTable;

import javafx.css.PseudoClass;

/**
 * twosum
 * 
 * @author jackjoily
 *
 */
public class JianZhiOffer21 {
	public static void main(String[] args) {
		int a[] = { 5, 4, 8, 8, 46, 456, 13, 31, 1, 23, 123, 56, 96, 14, 4854, 23, 36, 2148, 13, 4, 1, 1 };
		System.out.println(Arrays.toString(exchange(a)));
	}

	public static int[] exchange(int[] nums) {
		int n = nums.length;
		if (n == 1)
			return nums;
		int odd = -1;
		int even = 0;
		while (even < n) {
			if (nums[even] % 2 != 0) {
				odd++;
				even++;
			} else {
				int i = even + 1;
				while (i < n && nums[i] % 2 == 0)
					i++;
				if (i < n) {
					swap(nums, i, even);
					odd++;
				} else {
					break;
				}
			}
		}
		return nums;
	}

	public static void swap(int a[], int left, int right) {
		int temp = a[left];
		a[left] = a[right];
		a[right] = temp;
	}
}
