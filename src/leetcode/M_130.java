package leetcode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

import javafx.scene.shape.Line;
import leetcode_list.ListNode;
import leetcode_tree.TreeNode;
import sun.security.krb5.KdcComm;

/**
 * 
 * @author jackjoily
 *
 */
public class M_130 {
	public static void main(String[] args) {
		char[][] c = {
				{ 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X' },
				{ 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'O', 'O', 'O', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X' },
				{ 'X', 'X', 'X', 'X', 'X', 'O', 'O', 'O', 'X', 'O', 'X', 'O', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X' },
				{ 'X', 'X', 'X', 'X', 'X', 'O', 'X', 'O', 'X', 'O', 'X', 'O', 'O', 'O', 'X', 'X', 'X', 'X', 'X', 'X' },
				{ 'X', 'X', 'X', 'X', 'X', 'O', 'X', 'O', 'O', 'O', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X' },
				{ 'X', 'X', 'X', 'X', 'X', 'O', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X',
						'X' } };
		solve(c);
	}

	public static void solve(char[][] board) {
		int m = board.length;
		int n = board[0].length;
		Queue<Info> q = new LinkedList<Info>();
		boolean flag[][] = new boolean[m][n];
		for (int i = 0; i < m; i++) {
			if (board[i][n - 1] == 'O') {
				q.add(new Info(i, n - 1));
			}
			if (board[i][0] == 'O') {
				q.add(new Info(i, 0));
			}
		}
		for (int i = 1; i < n - 1; i++) {
			if (board[0][i] == 'O') {
				q.add(new Info(0, i));
			}
			if (board[m - 1][i] == 'O') {
				q.add(new Info(m - 1, i));
			}
		}
		int directions[][] = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };
		while (!q.isEmpty()) {
			Info f = q.poll();
			flag[f.i][f.j] = true;
			for (int k = 0; k < directions.length; k++) {
				int newi = f.i + directions[k][0];
				int newj = f.j + directions[k][1];
				if (newi >= 0 && newi < m && newj >= 0 && newj < n) {
					if (!flag[newi][newj] && board[newi][newj] == 'O') {
						q.add(new Info(newi, newj));
					}
				}
			}
		}
		for (int i = 1; i < m - 1; i++) {
			for (int j = 1; j < n - 1; j++) {
				if (!flag[i][j]) {
					board[i][j] = 'X';
				}
			}
		}
		System.out.println(Arrays.deepToString(board));
	}
}

class Info {
	public int i;
	public int j;

	public Info(int i, int j) {
		this.i = i;
		this.j = j;
	}

}
