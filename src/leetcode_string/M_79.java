package leetcode_string;

import java.util.HashMap;
import java.util.Map;

public class M_79 {

	public static void main(String[] args) {
		char[][] board = { { 'A', 'B', 'C', 'E' }, { 'S', 'F', 'C', 'S' }, { 'A', 'D', 'E', 'E' }, };
  System.out.println(exist(board, "ABCESEEDASFCD"));
	}

	public static boolean exist(char[][] board, String word) {
		int m = board.length;
		int n = board[0].length;
		boolean visted[][] = new boolean[m][n];
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (f(board, m, n, visted, i, j, 0, word)) {
					return true;
				}
			}
		}
		return false;
	}

	public static boolean f(char[][] board, int m, int n, boolean[][] visted, int i, int j, int k, String string) {
		if (board[i][j] != string.charAt(k)) {
			return false;
		}
		if (k == string.length() - 1)
			return true;
		int directions[][] = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };
		visted[i][j] = true;
		boolean result = false;
		for (int l = 0; l < 4; l++) {
			int newi = directions[l][0] + i;
			int newj = directions[l][1] + j;
			if (newi >= 0 && newi < m && newj >= 0 && newj < n) {
				if (!visted[newi][newj]) {
					boolean flag = f(board, m, n, visted, newi, newj, k + 1, string);
					if (flag) {
						result = true;
						break;
					}
				}
			}
		}
		visted[i][j] = false;
		return result;
	}

}
