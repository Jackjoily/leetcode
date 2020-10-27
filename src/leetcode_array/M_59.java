package leetcode_array;

import java.util.Arrays;

/**
 * 给定一个正整数 n，生成一个包含 1 到 n2 所有元素， 且元素按顺时针顺序螺旋排列的正方形矩阵。
 * 
 * @author jackjoily
 *
 */
public class M_59 {
	public static void main(String[] args) {
		M_59 m = new M_59();
		System.out.println(Arrays.deepToString(		m.generateMatrix(3)));

	}

	public int[][] generateMatrix(int n) {
		if (n <= 0) {
			return new int[][] {};
		}
		int a[][] = new int[n][n];

		int up = 0, down = n - 1, left = 0, right = n - 1;
		int i = 0;
		int count=1;
		while (up <= down) {
			for (i = left; i <= right; i++) {
				a[up][i]=count;
				count++;
			}
			up++;
			if (up > down)
				break;
			for (i = up; i <= down; i++) {
				a[i][right]=count;
				count++;
			}
			right--;
			if (right < left)
				break;
			for (i = right; i >= left; i--) {
				a[down][i]=count;
				count++;
			}
			System.out.println();
			down--;
			if (down < up)
				break;
			for (i = down; i >= up; i--) {
				a[i][left]=count;
				count++;
			}
			System.out.println();
			left++;
			if (left > right)
				break;
		}
		return a;
	}
}
