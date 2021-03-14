package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * twosum
 * 
 * @author jackjoily
 *
 */
public class JianZhiOffer13 {

	public static void main(String[] args) {
		JianZhiOffer13 j = new JianZhiOffer13();

		System.out.println(j.count);
	}

	public int movingCount(int m, int n, int k) {
		boolean flag[][] = new boolean[m][n];
		f(0, 0, k, m, n, flag);
		return count;
	}

	int count = 0;
	int directions[][] = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };

	public void f(int m, int n, int k, int col, int row, boolean flag[][]) {
		if (!flag[m][n] && isOkay(m, n, k)) {
			count++;
			flag[m][n] = true;
			for (int i = 0; i < directions.length; i++) {
				int newi = directions[i][0] + m;
				int newj = directions[i][1] + n;
				if (newi >= 0 && newj >= 0 && newi < col && newj < row) {
					f(newi, newj, k, col, row, flag);
				}
			}
		} else {
			return;
		}
	}

	public boolean isOkay(int i, int j, int k) {
		int sum = 0;
		while (i != 0) {
			sum += i % 10;
			i /= 10;
		}
		while (j != 0) {
			sum += j % 10;
			j /= 10;
		}
		return sum > k ? false : true;
	}
}
