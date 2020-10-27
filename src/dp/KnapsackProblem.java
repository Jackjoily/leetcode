package dp;

import java.util.Arrays;

/**
 * 背包问题
 * 
 * @author jackjoily
 *
 */
public class KnapsackProblem {
	public static void main(String[] args) {
		int w[] = { 1, 4, 3, 2, 5, 6, 7, 8, };
		int v[] = { 1500, 3000, 2500, 2000, 3500, 4000, 4500, 5000 };
		int wegiht = 16;
		int path[][] = new int[w.length + 1][wegiht + 1];
		int wegihts[][] = new int[w.length + 1][wegiht + 1];
		for (int i = 0; i < wegihts[0].length; i++) {
			wegihts[0][i] = 0;
		}
		for (int i = 0; i < wegihts.length; i++) {
			wegihts[i][0] = 0;
		}
		System.out.println(Arrays.deepToString(wegihts));
		for (int i = 1; i < wegihts.length; i++) {
			for (int j = 1; j < wegihts[0].length; j++) {
				if (w[i - 1] > j)
					wegihts[i][j] = wegihts[i - 1][j];
				else {
					// 为了记录商品存放到背包的情况
					if (wegihts[i - 1][j] < v[i - 1] + wegihts[i - 1][j - w[i - 1]]) {
						wegihts[i][j] = v[i - 1] + wegihts[i - 1][j - w[i - 1]];
						path[i][j] = 1;
					} else {
						wegihts[i][j] = wegihts[i - 1][j];
					}
				}

			}
		}
		System.out.println(Arrays.deepToString(wegihts));
		int i = path.length - 1;
		int j = path[0].length - 1;
		while (i > 0 && j > 0) {
			if (path[i][j] == 1) {
				System.out.printf("第%d个商品放入到背包\n", i);
				j -= w[i - 1];
			}
			i--;
		}
	}

}
