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
public class MianShi0107 {
	public void rotate(int[][] matrix) {
		int n = matrix.length;
		for (int i = 0; i < n; i++) {
			for (int j = i; j < n; j++) {
				int temp = matrix[i][j];
				matrix[i][j] = matrix[j][i];
				matrix[j][i] = temp;
			}
		}
		for (int i = 0; i < n; i++) {
			revers(matrix[i]);
		}
	}

	public void revers(int a[]) {
		int i = 0;
		int j = a.length - 1;
		while(i<j) {
			int temp =a[i];
			a[i]=a[j];
			a[j]=temp;
			i--;
			j++;
	   	}
	}
}
