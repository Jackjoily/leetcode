package leetcode_array;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个包含 m x n 个元素的矩阵（m 行, n 列）， 请按照顺时针螺旋顺序，返回矩阵中的所有元素。
 * 
 * @author jackjoily
 *
 */
public class M_54 {
	public static void main(String[] args) {
		int a[][] = { { 2, 5, 8 }, { 4, 0, -1 } };
		M_54 m = new M_54();
		m.spiralOrder(a);
		System.out.println(m.list);
	}

	List<Integer> list = new ArrayList<>();

	public List<Integer> spiralOrder(int[][] matrix) {
		if (matrix.length == 0) {
			return list;
		}
		int i = 0;
		int up = 0, left = 0, right = matrix[0].length - 1, down = matrix.length - 1;
		while (true) {
			for (i = left; i <= right; i++) {
				list.add(matrix[up][i]);
			}
			if (++up > down)
				break;
			for (i = up; i <= down; i++) {
				list.add(matrix[i][right]);
			}

			if (--right < left)
				break;
			for (i = right; i >= left; i--) {
				list.add(matrix[down][i]);
			}

			if (--down < up)
				break;
			for (i = down; i >= up; i--) {
				list.add(matrix[i][left]);
			}
			if (++left > right)
				break;
		}
		return list;
	}
}
