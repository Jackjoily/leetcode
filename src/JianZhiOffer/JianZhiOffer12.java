package JianZhiOffer;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。 输入一个递增排序的数组的一个旋转，输出旋转数组的最小元素。
 * 例如，数组 [3,4,5,1,2] 为 [1,2,3,4,5] 的一个旋转，该数组的最小值为1。  
 */
public class JianZhiOffer12 {
	public static void main(String[] args) {
		JianZhiOffer12 j1 = new JianZhiOffer12();
		char buf[][] = { { 'A', 'B', 'C', 'E' }, { 'S', 'F', 'C', 'S' }, { 'A', 'D', 'E', 'E' } };
		char a[][] = { { 'a' }, { 'b' } };
		// int m = buf.length;
		// int n = buf[0].length;
		// boolean flag[][] = new boolean[m][n];
		// for (int i = 0; i < m; i++) {
		// for (int j = 0; j < n; j++) {
		// j1.f(buf, i, j, "ABCCED", "", flag);
		// }
		// }
		System.out.println(j1.exist(a, "ba"));
	}

	boolean fla1 = false;

	public boolean exist(char[][] board, String word) {
		char[] charArray = word.toCharArray();
		int m = board.length;
		int n = board[0].length;
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (f(board, charArray, 0, 0, 0))
					return true;
			}
		}
		return false;
	}

	public boolean f(char[][] board, char words[], int i, int j, int k) {
		if (i < 0 || i >= board.length || j < 0 || j >= board[0].length || board[i][j] != words[k])
			return false;
		if (k == words.length - 1)
			return true;
		char temp = board[i][j];
		board[i][j] = '/';
		boolean res = f(board, words, i + 1, j, k + 1) || f(board, words, i - 1, j, k + 1)
				|| f(board, words, i, j + 1, k + 1) || f(board, words, i, j - 1, k + 1);
		board[i][j] = temp;
		return res;
	}

}
