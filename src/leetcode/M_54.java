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
		int left = 0;
		int right = n - 1;
		int up = 0;
		int down = m - 1;
		int i = 0;
		int count = 0;
		while (true) {

			while (i <= right) {
				list.add(matrix[up][i]);
				i++;
			}
			up++;
			if (up > down)
				break;
			i = up;
			while (i <= down) {
				list.add(matrix[i][right]);
				i++;
			}
			right--;
			if (right <left)
				break;
			i = right;
			while (i >= left) {
				list.add(matrix[down][i]);
				i--;
			}
			down--;
			if (down < up)
				break;
			i = down;
			while (i >= up) {
				list.add(matrix[i][left]);
				i--;
			}
			left++;
			if (left > right)
				break;
			i = left;
		}
		return list;
	}
}
