package JianZhiOffer;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 地上有一个m行n列的方格，从坐标 [0,0] 到坐标 [m-1,n-1] 。 一个机器人从坐标 [0, 0]
 * 的格子开始移动，它每次可以向左、右、上、下移动一格 （不能移动到方格外），也不能进入行坐标和列坐标的数位之和大于k的格子。
 * 例如，当k为18时，机器人能够进入方格 [35, 37] ，因为3+5+3+7=18。 但它不能进入方格 [35,
 * 38]，因为3+5+3+8=19。请问该机器人能够到达多少个格子？
 *
 * TODO
 */
public class JianZhiOffer13 {
	public static void main(String[] args) {
		JianZhiOffer13 j = new JianZhiOffer13();
		System.out.println(		j.movingCount(16, 8, 4));
	}

	boolean flag[][];

	public int movingCount(int m, int n, int k) {
		int count = 0;
		flag = new boolean[m][n];
		f(flag, 0, 0, k);
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (flag[i][j]) {
					count++;
				}
			}
		}
		return count;
	}

	public void f(boolean[][] flag, int m, int n, int k) {
		if (m >= 0 && m < flag.length && n >= 0 && n < flag[0].length) {
			if (!flag[m][n] && getVal(m + "", n + "") <= k) {
				flag[m][n] = true;
				f(flag, m - 1, n, k);
				f(flag, m + 1, n, k);
				f(flag, m, n - 1, k);
				f(flag, m, n + 1, k);
			}
		}
	}

	public  int getVal(String x, String y) {
		int sum = 0;
		for (int i = 0; i < x.length(); i++) {
			sum += x.charAt(i) - '0';
		}
		for (int j = 0; j < y.length(); j++) {
			sum += y.charAt(j) - '0';
		}
		return sum;
	}
}
