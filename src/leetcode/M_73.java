package leetcode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Queue;

import javax.swing.plaf.synth.SynthScrollBarUI;

import javafx.scene.shape.Line;
import leetcode_list.ListNode;
import leetcode_tree.TreeNode;

/**
 * 
 * @author jackjoily
 *
 */
public class M_73 {
	public static void main(String[] args) {
		int a[][] = {{0,1,2,0},{3,4,5,2},{1,3,1,5} };
		setZeroes(a);
	}

	public static void setZeroes(int[][] matrix) {
		int m = matrix.length;
		int n = matrix[0].length;
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (matrix[i][j] == 0) {
					for (int k = 0; k < m; k++) {
						if (k != i) {
							if (matrix[k][j] != 0) {
								matrix[k][j] = Integer.MIN_VALUE/2;
							}
						}
					}
					for (int k = 0; k < n; k++) {
						if (k != j) {
							if (matrix[i][k] != 0) {
								matrix[i][k] = Integer.MIN_VALUE/2;
							}
						}
					}
				}
			}
		}
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (matrix[i][j] ==  Integer.MIN_VALUE/2) {
					matrix[i][j]=0;
				}
			}
		}
		System.out.println(Arrays.deepToString(matrix));
	}
}
