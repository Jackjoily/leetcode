package leetcode_day;

import java.util.Arrays;
import java.util.Collections;

import leetcode_list.ListNode;

public class M_48 {
	/**
	 * 
	 * 给定一个 n × n 的二维矩阵表示一个图像。
	 * 
	 * 将图像顺时针旋转 90 度。
	 * 
	 * 说明：
	 * 
	 * 你必须在原地旋转图像，这意味着你需要直接修改输入的二维矩阵。请不要使用另一个矩阵来旋转图像。
	 * 
	 * 
	 */
	public static void main(String[] args) {
		int a[][] = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
		rotate(a);
	}

	public static void rotate(int[][] matrix) {
		int n = matrix.length;
		for (int i = 0; i < n; i++) {
			for (int j = i + 1; j < n; j++) {
				int temp = matrix[i][j];
				matrix[i][j] = matrix[j][i];
				matrix[j][i] = temp;
			}
		}
		for (int k = 0; k < n; k++) {
			swap(matrix[k]);
		}
	}

	public static void swap(int a[]) {
		int i = 0, j = a.length - 1;
		while (i < j) {
			int temp = a[i];
			a[i] = a[j];
			a[j] = temp;
			i++;
			j--;
		}
	}
}
