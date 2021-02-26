package leetcode_array;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Queue;

/**
 * 编写一个高效的算法来搜索 m x n 矩阵 matrix 中的一个目标值 target 。 该矩阵具有以下特性： 每行的元素从左到右升序排列。
 * 每列的元素从上到下升序排列。
 * 
 * 来源：力扣（LeetCode） 链接：https://leetcode-cn.com/problems/search-a-2d-matrix-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * 
 * @author jackjoily
 *
 */
public class M_240 {
	public static void main(String[] args) {
		int a[][] = { { 1, 4, 7, 11, 15 }, { 2, 5, 8, 12, 19 }, { 3, 6, 9, 16, 22 }, { 10, 13, 14, 17, 24 },
				{ 18, 21, 23, 26, 30 } };
		System.out.println(searchMatrix1(a, 22));
	}

	public static boolean searchMatrix1(int[][] matrix, int target) {
		int m = matrix.length;
		int n = matrix[0].length;
		int row = m - 1;
		int col = 0;
		while (col < n && col >= 0 && row >= 0 && row < m) {
			if (matrix[row][col] < target) {
				col++;
			} else if (matrix[row][col] > target) {
				row--;
			} else {
				return true;
			}
		}
		return false;
	}

	public static boolean searchMatrix(int[][] matrix, int target) {
		int m = matrix.length;
		int n = matrix[0].length;
		Queue<Info> queue = new ArrayDeque<>();
		queue.add(new Info(0, 0));
		int direction[][] = { { 1, 0 }, { 0, 1 } };
		while (queue.size() > 0) {
			Info poll = queue.poll();
			if (matrix[poll.x][poll.y] == target) {
				return true;
			}
			for (int i = 0; i < 2; i++) {
				int newx = poll.x + direction[i][0];
				int newy = poll.y + direction[i][1];
				if (newx < m && newy < n) {
					queue.add(new Info(newx, newy));
				}
			}
		}
		return false;
	}

	public static class Info {
		int x;
		int y;

		public Info(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

}
