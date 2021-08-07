package leetcode_wx;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

import basic.Node;
import leetcode_list.ListNode;
import leetcode_tree.TreeNode;
import leetcode_tree.TreeUtils;

public class M_130 {

	public static void main(String[] args) {
		M_130 m = new M_130();
		char a[][] = {
				{ 'X', 'X', 'X', 'X' ,'X' }, 
				{ 'X', 'O', 'O', 'X' ,'X'}, 
				{ 'X', 'X', 'O', 'X' ,'X'}, 
				{ 'X', 'O', 'X', 'O' ,'X'},
				{ 'X', 'O', 'O', 'X' ,'X'}};
		m.solve(a);
	}

	boolean used[][];
	int dir[][] = { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };

	public void solve(char[][] board) {
		int m = board.length;
		int n = board[0].length;
		used = new boolean[m][n];
		int count = 0;
		for (int i = 1; i < m - 1; i++) {
			for (int j = 1; j < n - 1; j++) {
				if (!used[i][j] && board[i][j] == 'O') {
					if (f(board, i, j, used)) {
						count++;
					}
				}
			}
		}
		System.out.println(count);
	}

	public boolean f(char c[][], int i, int j, boolean used[][]) {
		boolean flag = true;
		used[i][j] = true;
		for (int a[] : dir) {
			int newi = a[0] + i;
			int newj = a[1] + j;
			if (0 <= newi && newi < c.length && 0 <= newj && newj < c[0].length && !used[newi][newj]
					&& c[newi][newj] == 'O') {
				if (newi == 0 || newj == 0 || newi == c.length - 2 || newj == c[0].length - 2) {
					used[newi][newj] = true;
					return false;
				}
				flag &= f(c, newi, newj, used);
			}
		}
		return flag;
	}
}