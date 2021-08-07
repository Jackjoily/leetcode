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
public class M_59 {
	public static void main(String[] args) {
		generateMatrix(1);
	}

	public static int[][] generateMatrix(int n) {
		int a[][] = new int[n][n];
		int cnt = n * n;
		int left = 0, right = n - 1;
		int up = 0, down = n - 1;
		int inx = 1;
		while (cnt != 0) {
			for (int i = left; i <= right; i++) {
				a[up][i] = inx++;
				cnt--;
			}
			up++;
			for (int i = up; i <= down; i++) {
				a[i][right] = inx++;
				cnt--;
			}
			right--;
			for (int i = right; i >= left; i--) {
				a[down][i] = inx++;
				cnt--;
			}
			down--;
			for (int i = down; i >= up; i--) {
				a[i][left] = inx++;
				cnt--;
			}
			left++;
		}
		System.out.println(Arrays.deepToString(a));
		return a;
	}
}
