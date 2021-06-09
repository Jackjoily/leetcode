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
public class M_240 {

	public boolean searchMatrix(int[][] matrix, int target) {
		int m = matrix.length;
		int n = matrix[0].length;
		for (int i = 0; i < n; i++) {
			for (int j = m - 1; m >= 0; j--) {
				if (matrix[i][j] == target) {
					return true;
				} else if (matrix[i][j] < target) {
					break;
				} else {
					continue;
				}
			}
		}
		return false;
	}
}
