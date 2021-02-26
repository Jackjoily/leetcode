package leetcode_array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

import javax.swing.text.html.HTMLDocument.HTMLReader.HiddenAction;

/**
 * 给定 n 个非负整数，用来表示柱状图中各个柱子的高度。 每个柱子彼此相邻，且宽度为 1 。 求在该柱状图中，能够勾勒出来的矩形的最大面积。
 * 
 * @author jackjoily
 *
 */
public class H_84 {
	public static void main(String[] args) {
		int a[] = { 2, 1, 5, 6, 2, 3 };
		System.out.println(largestRectangleArea1(a));
	}

	/**
	 * 固定高度从中心往左右两边寻找小于当前height[i]
	 * 
	 * @param heights
	 * @return
	 */
	public static int largestRectangleArea(int[] heights) {
		int l = 0, r = 0;
		int max = 0;
		for (int i = 0; i < heights.length; i++) {
			int height = heights[i];
			l = i;
			r = i;
			while (l - 1 >= 0 && heights[l - 1] >= height) {
				l--;
			}
			while (r + 1 < heights.length && heights[r + 1] >= height) {
				r++;
			}
			max = Math.max(max, (r - l + 1) * height);
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
