package leetcode_array;

import java.util.Arrays;

/**
 * 你必须在原地旋转图像，这意味着你需要直接修改输入的二维矩阵。 请不要使用另一个矩阵来旋转图像。
 * 
 * @author jackjoily
 *
 */
public class M_48 {
	public static void main(String[] args) {
		int a[][] = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
		M_48 m = new M_48();
		m.rotate(a);
		System.out.println(Arrays.deepToString(a));
	}

	// 原地转置1
	public void rotate(int[][] matrix) {
		// 列
		int m = matrix[0].length;
		if (m == 0) {
			return;
		} else {
			// 进行转置
			int i, j, temp;
			for (i = 0; i < m; i++) {
				for (j = i; j < m; j++) {
					temp = matrix[i][j];
					matrix[i][j] = matrix[j][i];
					matrix[j][i] = temp;
				}
			}
			// 进行翻转
			for (i = 0; i < m; i++) {
				for (j = 0; j < m / 2; j++) {
					temp = matrix[i][j];
					matrix[i][j] = matrix[i][m - j - 1];
					matrix[i][m - j - 1] = temp;
				}
			}
		}
	}
}
