package leetcode_day;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

import leetcode_list.ListNode;
import leetcode_tree.TreeNode;
import leetcode_tree.TreeUtils;

/**
 * 给定一个仅包含 0 和 1 、大小为 rows x cols 的二维二进制矩阵，找出只包含 1 的最大矩形，并返回其面积。
 * 
 * @author jackjoily
 *
 */
public class H_85 {
	public static void main(String[] args) {
		char a[][] = { { '1', '0', '1', '0', '0' }, { '1', '0', '1', '1', '1' }, { '1', '1', '1', '1', '1' },
				{ '1', '0', '0', '1', '0' } };
		System.out.println(maximalRectangle(a));
		System.out.println(maximalRectangle1(a));
	}

	/**
	 * 使用暴力的方法
	 * 
	 * @param matrix
	 * @return
	 */
	public static int maximalRectangle(char[][] matrix) {
		int m = matrix.length;
		if (m == 0)
			return 0;
		int n = matrix[0].length;
		int dp[][] = new int[m][n];
		int max = 1;
		int mianji = 0;
		int min = 1;
		for (int i = 0; i < m; i++) {
			if (matrix[i][0] == '1') {
				dp[i][0] = 1;
			}
			for (int j = 0; j < n; j++) {
				if (matrix[i][j] == '1') {
					if (j == 0) {
						dp[i][0] = 1;
					} else {
						dp[i][j] += dp[i][j - 1] + 1;
					}
				}
				int minWidth = dp[i][j];
				for (int k = i; k >= 0; k--) {
					int height = i - k + 1;
					minWidth = Math.min(minWidth, dp[k][j]);
					mianji = Math.max(mianji, height * minWidth);
				}
			}
		}
		return mianji;
	}

	/**
	 * 
	 * @param matrix
	 * @return
	 */
	public static int maximalRectangle1(char[][] matrix) {
		int m = matrix.length;
		int n = matrix[0].length;
		int max = 0;
		if (m == 0)
			return 0;
		int dp[][] = new int[m][n];
		// 按列
		for (int i = 0; i < n; i++) {
			// 按行
			for (int j = 0; j < m; j++) {
				if (matrix[j][i] == '1') {
					if (j == 0) {
						dp[j][i] = 1;
					} else {
						dp[j][i] = dp[j - 1][i] + 1;
					}
				}
			}
		}

		System.out.println(Arrays.deepToString(dp));
		for (int i = 0; i < m; i++) {
			max = Math.max(max, largestRectangleArea1(dp[i]));
		}
		return max;
	}

	// 使用栈维护高度
	public static int largestRectangleArea1(int[] heights) {
		int max = 0;
		int len = heights.length;
		if (len == 0)
			return 0;
		if (len == 1)
			return heights[0] * 1;
		int left[] = new int[len];
		int right[] = new int[len];
		Stack<Integer> stack = new Stack<>();
		for (int i = 0; i < len; i++) {
			// 将栈中大于heights的都弹出
			while (!stack.isEmpty() && heights[stack.peek()] >= heights[i]) {
				stack.pop();
			}
			left[i] = stack.isEmpty() == true ? -1 : stack.peek();
			stack.add(i);
		}
		stack.clear();
		for (int i = len - 1; i >= 0; i--) {
			// 将栈中大于heights的都弹出
			while (!stack.isEmpty() && heights[stack.peek()] >= heights[i]) {
				stack.pop();
			}
			right[i] = stack.isEmpty() == true ? len : stack.peek();
			stack.add(i);
		}
		for (int i = 0; i < len; i++) {
			max = Math.max(max, heights[i] * (right[i] - left[i] - 1));
		}
		return max;
}
	}
