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
public class H_85 {
	public static void main(String[] args) {
		char a[][] = { { '1', '0', '1', '0', '0' }, { '1', '0', '1', '1', '1' }, { '1', '1', '1', '1', '1' },
				{ '1', '0', '0', '1', '0' } };

		int b[] = { 3, 1, 3, 2, 2 };
		System.out.println(largestRectangleArea(b));
	}

	public static int maximalRectangle(char[][] matrix) {
		int max = 0;
		int m = matrix.length;
		int n = matrix[0].length;
		int heights[][] = new int[m][n];
		for (int j = 0; j < n; j++) {
			for (int i = 0; i < m; i++) {
				if (i == 0) {
					if (matrix[i][j] == '1') {
						heights[0][j] = 1;
					}
				} else {
					if (matrix[i][j] == '1') {
						heights[i][j] = heights[i - 1][j] + 1;
					}
				}
			}
		}

		for (int i = 0; i < m; i++) {
			max = Math.max(largestRectangleArea(heights[i]), max);
		}
		return max;
	}

	public static int largestRectangleArea(int[] heights) {
		int n = heights.length;
		int left[] = new int[n];
		int right[] = new int[n];
		Stack<Integer> s = new Stack<>();
		for (int i = 0; i < n; i++) {
			while (!s.isEmpty() && heights[s.peek()] >= heights[i]) {
				s.pop();
				right[i] = -1;
			}
			if (s.isEmpty()) {
				left[i] = -1;
			} else {
				left[i] = s.peek();
			}
			s.add(i);
		}
		s = new Stack<>();
		for (int i = n - 1; i >= 0; i--) {
			while (!s.isEmpty() && heights[s.peek()] >= heights[i]) {
				s.pop();
			}
			if (s.isEmpty()) {
				right[i] = n;
			} else {
				right[i] = s.peek();
			}
			s.add(i);
		}
		int max = 0;
		for (int i = 0; i < n; i++) {
			max = Math.max((right[i] - left[i] - 1) * heights[i], max);
		}
		return max;
	}
}
