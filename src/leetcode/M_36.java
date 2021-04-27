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
public class M_36 {
	public static void main(String[] args) {
		M_36  m=new M_36();
		char a[][]={
				{'8','3','.','.','7','.','.','.','.'},
				{'6','.','.','1','9','5','.','.','.'},
				{'.','9','8','.','.','.','.','6','.'},
				{'8','.','.','.','6','.','.','.','3'},
				{'4','.','.','8','.','3','.','.','1'},
				{'7','.','.','.','2','.','.','.','6'},
				{'.','6','.','.','.','.','2','8','.'},
				{'.','.','.','4','1','9','.','.','5'},
				{'.','.','.','.','8','.','.','7','9'}
				};
		System.out.println(	m.isValidSudoku(a));
		
		
	}

	public boolean isValidSudoku(char[][] board) {
		for (int i = 0; i < 9; i++) {
			if (!check(board[i])) {
				return false;
			}
			if (!check(board, i)) {
				return false;
			}
		}

		return check(board);
	}

	public boolean check(char a[]) {
		HashSet<Character> set = new HashSet<>();
		for (int i = 0; i < 9; i++) {
			if (a[i] != '.') {
				if (set.contains(a[i])) {
					return false;
				}else {
					set.add(a[i]);
				}
			}
		}
		return true;
	}

	public boolean check(char a[][], int j) {
		HashSet<Character> set = new HashSet<>();
		for (int i = 0; i < 9; i++) {
			if (a[i][j] != '.') {
				if (set.contains(a[i][j])) {
					return false;
				}else {
					set.add(a[i][j]);
				}
			}
		}
		return true;
	}

	public boolean check(char a[][]) {
		HashSet<Character> set = new HashSet<>();
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				if (a[i][j] != '.') {
					if (set.contains(a[i][j])) {
						return false;
					}else {
						set.add(a[i][j]);
					}
				}
			}
		}
		set = new HashSet<>();
		for (int i = 0; i < 3; i++) {
			for (int j = 3; j < 6; j++) {
				if (a[i][j] != '.') {
					if (set.contains(a[i][j])) {
						return false;
					}else {
						set.add(a[i][j]);
					}
				}
			}
		}
		set = new HashSet<>();
		for (int i = 0; i < 3; i++) {
			for (int j = 6; j < 9; j++) {
				if (a[i][j] != '.') {
					if (set.contains(a[i][j])) {
						return false;
					}else {
						set.add(a[i][j]);
					}
				}
			}
		}

		set = new HashSet<>();
		for (int i = 3; i < 6; i++) {
			for (int j = 0; j < 3; j++) {
				if (a[i][j] != '.') {
					if (set.contains(a[i][j])) {
						return false;
					}else {
						set.add(a[i][j]);
					}
				}
			}
		}
		set = new HashSet<>();
		for (int i = 3; i < 6; i++) {
			for (int j = 3; j < 6; j++) {
				if (a[i][j] != '.') {
					if (set.contains(a[i][j])) {
						return false;
					}else {
						set.add(a[i][j]);
					}
				}
			}
		}
		set = new HashSet<>();
		for (int i = 3; i < 6; i++) {
			for (int j = 6; j < 9; j++) {
				if (a[i][j] != '.') {
					if (set.contains(a[i][j])) {
						return false;
					}else {
						set.add(a[i][j]);
					}
				}
			}
		}

		set = new HashSet<>();
		for (int i = 6; i < 9; i++) {
			for (int j = 0; j < 3; j++) {
				if (a[i][j] != '.') {
					if (set.contains(a[i][j])) {
						return false;
					}else {
						set.add(a[i][j]);
					}
				}
			}
		}
		set = new HashSet<>();
		for (int i = 6; i < 9; i++) {
			for (int j = 3; j < 6; j++) {
				if (a[i][j] != '.') {
					if (set.contains(a[i][j])) {
						return false;
					}else {
						set.add(a[i][j]);
					}
				}
			}
		}
		set = new HashSet<>();
		for (int i = 6; i < 9; i++) {
			for (int j = 6; j < 9; j++) {
				if (a[i][j] != '.') {
					if (set.contains(a[i][j])) {
						return false;
					}else {
						set.add(a[i][j]);
					}
				}
			}
		}
		return true;
	}
}
