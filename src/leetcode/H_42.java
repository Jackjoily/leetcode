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
public class H_42 {
	public static void main(String[] args) {
		int a[] = { 4, 2, 0, 3, 2, 5 };
		System.out.println(trap(a));
	}

	public static int trap(int[] height) {
		int n = height.length;
		if (n <= 1)
			return 0;
		int left[] = new int[n];
		int right[] = new int[n];
		left[0] = height[0];
		for (int i = 1; i < n; i++) {
			left[i] = Math.max(left[i - 1], height[i]);
		}
		right[n - 1] = height[n - 1];
		for (int j = n - 2; j >= 0; j--) {
			right[j] = Math.max(right[j + 1], height[j]);
		}
		int sum = 0;
		int leftMax = 0;
		leftMax = height[0];
		for (int i = 1; i < n; i++) {
			leftMax = Math.max(leftMax, height[i]);
			sum += Math.min(leftMax, right[i]) - height[i];
		}
		return sum;
	}
}
