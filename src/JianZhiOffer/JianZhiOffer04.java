package JianZhiOffer;

import java.util.HashMap;
import java.util.Map;

/**
 * 找出数组中重复的数字。
 * 
 * 
 * 在一个 n * m 的二维数组中，每一行都按照从左到右递增的
 * 顺序排序，每一列都按照从上到下递增的顺序排序。请完成一个函数，输入这样的一个二维数组和一个整数， 判断数组中是否含有该整数。
 * 
 * @author jackjoily
 *
 */
public class JianZhiOffer04 {
	public static void main(String[] args) {
		JianZhiOffer04 j = new JianZhiOffer04();
//		int a[][] = { { 1, 4, 7, 11, 15 }, { 2, 5, 8, 12, 19 }, { 3, 6, 9, 16, 22 }, { 10, 13, 14, 17, 24 },
//				{ 18, 21, 23, 26, 30 } };
		int a[][]= {{1,3,5}};
		System.out.println(j.findNumberIn2DArray(a, 3));

	}

	public boolean findNumberIn2DArray(int[][] matrix, int target) {
		int n = matrix.length;
		if (n == 0) {
			return false;
		}
		int m = matrix[0].length;
		if (m == 0)
			return false;
		int i, j;
		for (i = 0; i < n; i++) {
			if (matrix[i][m - 1] < target);
			else if (matrix[i][m - 1] == target)
				return true;
			else break;
		}
		for (j = 0; j < m; j++) {
			if (matrix[n - 1][j] < target);
			else if (matrix[n - 1][j] == target)
				return true;
			else
				break;
		}
		int p=0, q=0;
		for (q = i; q < n; q++) {
			for (p = j; p < m; p++) {
				if (matrix[q][p] == target)
					return true;
			}
		}

		return false;
	}
}
