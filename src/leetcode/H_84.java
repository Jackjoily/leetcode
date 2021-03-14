package leetcode;

import java.util.Arrays;
import java.util.Stack;

import sun.launcher.resources.launcher;

/**
 * twosum
 * 
 * @author jackjoily
 *
 */
public class H_84 {
	public static void main(String[] args) {
		int a[] = { 2,1,5,6,2,2,3,4,5,6,7,8,5,2,5,2,5,6,5,7,2,5 };
		System.out.println(largestRectangleArea(a));
	}

	public static int largestRectangleArea(int[] heights) {
		int n = heights.length;
		if (n == 0)
			return 0;
		if (n == 1)
			return heights[0];
		Stack<Integer> s = new Stack<>();
		int left[] = new int[n];
		int right[] = new int[n];
		for (int i = 0; i < n; i++) {
			while (!s.isEmpty() && heights[s.peek()] >= heights[i]) {
				s.pop();
			}
			if (s.isEmpty()) {
				left[i] = -1;
			} else {
				left[i] = s.peek();
			}
			s.add(i);
		}
		s.clear();
		int max = 0;
		for (int i = n - 1; i >= 0; i--) {
			while (!s.isEmpty() && heights[s.peek()] >= heights[i]) {
				s.pop();
			}
			if (s.isEmpty()) {
				right[i] =n;
			} else {
				right[i] = s.peek();
			}
			max = Math.max((right[i] - left[i] - 1) * heights[i], max);
			s.add(i);
		}
		return max;
	}
}
