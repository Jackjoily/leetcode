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
public class M_48 {
	public static void main(String[] args) {
		int a[][] = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
		rotate(a);
	}

	public static void rotate(int[][] matrix) {
		int m = matrix.length;
		for (int i = 0; i < m; i++) {
			for (int j = i+1; j < m; j++) {
				if (i != j) {
					int temp = matrix[i][j];
					matrix[i][j] = matrix[j][i];
					matrix[j][i] = temp;
				}
			}
		}
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < m / 2; j++) {
				int temp = matrix[i][j];
				matrix[i][j] = matrix[i][m - j-1];
				matrix[i][m - j-1] = temp;
			}
		}
	}
}
