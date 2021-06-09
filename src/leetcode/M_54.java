package leetcode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Queue;

import javafx.scene.shape.Line;
import leetcode_list.ListNode;
import leetcode_tree.TreeNode;

/**
 * 
 * @author jackjoily
 *
 */
public class M_54 {
	public static void main(String[] args) {
		int a[][] = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
		System.out.println(spiralOrder(a));
	}

	public static List<Integer> spiralOrder(int[][] matrix) {
		List<Integer> list = new ArrayList<>();
		int m = matrix.length;
		int n = matrix[0].length;
		int left = 0, right = n - 1;
		int down = m - 1, up = 0;
		while (true) {
			for (int i = left; i <= right; i++) {
				list.add(matrix[up][i]);
			}
			up++;
			if (up > down)
				break;
			for (int i = up; i <= down; i++) {
				list.add(matrix[i][right]);
			}
			right--;
			if (left > right)
				break;

			for (int i = right; i >= left; i--) {
				list.add(matrix[down][i]);
			}
			down--;
			if (up > down)
				break;

			for (int i = down; i >= up; i--) {
				list.add(matrix[i][left]);
			}
			left++;
			if (left > right)
				break;
		}
		return list;
	}
}
