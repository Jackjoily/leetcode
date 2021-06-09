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
public class E_238 {
	public static void main(String[] args) {
		int a[] = {0,1,0,3,12,2,3,45,0,86455,0,5,5,1,6,0};
		moveZeroes(a);
		System.out.println(Arrays.toString(a));
	}

	public static void moveZeroes(int[] nums) {
		int n = nums.length;
		if (n <= 1)
			return;
		int inx = -1;
		int right = 0;
		while (right < n) {
			if (nums[right] != 0) {
				inx++;
				right++;
			} else {
				int i = right + 1;
				while (i < n && nums[i] == 0)
					i++;
				if (i < n) {
					swap(nums, i, right);
					inx++;
					right++;
				} else {
					break;
				}
			}
		}
		inx++;
		while (inx < n) {
			nums[inx] = 0;
			inx++;
		}
	}

	public static void swap(int a[], int left, int right) {
		int temp = a[left];
		a[left] = a[right];
		a[right] = temp;
	}
}
