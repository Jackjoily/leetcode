package leetcode_array;

import java.util.Arrays;

/**
 * 输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字
 * 
 * @author jackjoily
 *
 */
public class MianShi29 {
	public static void main(String[] args) {
		MianShi29 m = new MianShi29();
		int matrix[][] = { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 } };
		int[] spiralOrder = m.spiralOrder(matrix);
		System.out.println(Arrays.toString(spiralOrder));
	}

	public int[] spiralOrder(int[][] matrix) {
		if (matrix.length == 0 || matrix[0].length == 0)
			return new int[0];
		int left = 0, up = 0, right =matrix[0].length - 1, down =  matrix.length - 1;
		int n = (matrix.length) * (matrix[0].length);
		int a[] = new int[n];
		int i = 0;
		int count = 0;
		while (true) {
			for (i = left; i <= right; i++) {
				a[count] = matrix[up][i];
				count++;
			}
			up++;
			if (up > down)
				break;
			for (i = up; i <= down; i++) {
				a[count] = matrix[i][right];
				count++;
			}
			right--;
			if (right < left)
				break;
			for (i = right; i >= left; i--) {
				a[count] = matrix[down][i];
				count++;
			}
			down--;
			if (down < up)
				break;
			for (i = down; i >= up; i--) {
				a[count] = matrix[i][left];
				count++;
			}
			left++;
			if (left > right)
				break;
		}
		return a;
	}
}
