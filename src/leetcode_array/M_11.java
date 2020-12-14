package leetcode_array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 
 * 给你 n 个非负整数 a1，a2，...，an，每个数代表坐标中的一个点  (i, ai) 。在坐标内画 n 条垂直线，垂直线 i 的两个端点分别为 
 * (i, ai) 和 (i, 0) 。找出其中的两条线，使得它们与 x 轴共同构成的 容器可以容纳最多的水。
 * 
 * @author jackjoily
 *
 */
public class M_11 {
	public static void main(String[] args) {
		int a[] = { 1, 2, 1 };
		System.out.println(maxArea1(a));
	}

	public static int maxArea(int[] height) {
		int max = 0;
		for (int i = 0; i < height.length - 1; i++) {
			for (int j = i + 1; j < height.length; j++) {
				max = Math.max(max, Math.min(height[i], height[j]) * (j - i));
			}
		}
		return max;
	}

	public static int maxArea1(int[] height) {
		int i = 0, j = height.length - 1;
		int max = (j - i) * Math.min(height[i], height[j]);
		while (i < j) {
			if (height[i] < height[j]) {
				i++;
			} else {
				j--;
			}
			max = Math.max(max, (j - i) * Math.min(height[i], height[j]));
		}
		return max;
	}
}
