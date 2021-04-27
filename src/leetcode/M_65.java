package leetcode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Queue;

import javafx.scene.layout.Border;
import javafx.scene.shape.Line;
import leetcode_list.ListNode;
import leetcode_tree.TreeNode;

/**
 * 
 * @author jackjoily
 *
 */
public class M_65 {
	public static void main(String[] args) {
		int a[][] ={
				{0,0,0,0,0,0},
				{0,0,0,0,0,0},
				{0,0,1,1,1,0},
				{0,1,1,1,0,0},
				{0,0,0,0,0,0},
				{0,0,0,0,0,0}
				};
		gameOfLife(a);
	}

	public static void gameOfLife(int[][] board) {
		int m = board.length;
		int n = board[0].length;
		int newj = 0, newi = 0;
		// 3之前是活的变死了
		// 2之前是死的变活了
		int[][] d = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 }, { -1, -1 }, { 1, 1 }, { -1, 1 }, { 1, -1 } };
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				int live = 0;
				for (int k = 0; k < 8; k++) {
					newi = i + d[k][0];
					newj = j + d[k][1];
					if (newi >= 0 && newi < m && newj >= 0 && newj < n) {
						if (board[newi][newj] == 1 || board[newi][newj] == 3) {
							live++;
						}
					}
				}
				if (live < 2) {
					if (board[i][j] == 1) {
						board[i][j] = 3;
					}
				}
				if (live > 3) {
					if (board[i][j] == 1) {
						board[i][j] = 3;
					}
				}
				if (live == 3) {
					if (board[i][j] == 0) {
						board[i][j] = 2;
					}
				}
			}
		}
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (board[i][j] == 3) {
					board[i][j] = 0;
				}
				if (board[i][j] == 2) {
					board[i][j] = 1;
				}
			}
		}
		System.out.println(Arrays.deepToString(board));
	}
}
