package leetcode;

import java.util.Arrays;
import java.util.HashMap;

import com.sun.org.apache.xerces.internal.util.SynchronizedSymbolTable;

import javafx.scene.control.Tab;
import sun.print.resources.serviceui;

/**
 * twosum
 * 
 * @author jackjoily
 *
 */
public class E_704 {
	public static void main(String[] args) {
		int a[] = {-1,0,3,5,9,12 };
		System.out.println(search(a, 2));
	}

	public static int search(int[] nums, int target) {
		int low = 0;
		int high = nums.length - 1;
		while (low <= high) {
			int mid = (high - low) / 2 + low;
			if (nums[mid] == target) {
				return mid;
			} else if (nums[mid] > target) {
				high = mid - 1;
			} else {
				low = mid + 1;
			}
		}
		return -1;
	}
}
