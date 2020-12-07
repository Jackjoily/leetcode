package leetcode_day;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

/**
 *
 *
 *
 *
 *
 *
 */
public class M_861 {
	public static void main(String[] args) {
		int a[][] = { { 0, 0, 1, 1 }, { 1, 0, 1, 0 }, { 1, 1, 0, 0 } };
		System.out.println(matrixScore(a));
	}

	public static int matrixScore(int[][] a) {
		int m = 0, n = 0;
		int res = 0;
		for (int i = 0; i < a.length; i++) {
			if (a[i][0] != 1) {
				for (int j = 0; j < a[0].length; j++) {
					if (a[i][j] == 1) {
						a[i][j]=0;
					}else {
						a[i][j]=1;
					}
				}
			}
		}
		res = a.length * power(a[0].length - 1);
		for (int i = 1; i < a[0].length; i++) {
			m = 0;
			n = 0;
			for (int j = 0; j < a.length; j++) {
				if (a[j][i] == 0) {
					m++;
				} else {
					n++;
				}
			}
			if (m > n) {
				res += m * power(a[0].length - 1 - i);
			} else {
				res += n * power(a[0].length - 1 - i);
			}
		}
		return res;
	}

	public static int power(int n) {
		int res = 1;
		for (int i = 0; i < n; i++) {
			res *= 2;
		}
		return res;
	}

}
