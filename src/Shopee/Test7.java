package Shopee;

import java.util.*;

public class Test7 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int x = sc.nextInt();
		int y = sc.nextInt();
		int boss_num = sc.nextInt();
		// 与其用数组去维护boss的坐标位置，不如直接在表里填-1，表示不可走
		long[][] mv = new long[x + 1][y + 1];// 因为从0开始到y，所以空间是y+1;
		for (int i = 0; i < boss_num; i++) {
			mv[sc.nextInt()][sc.nextInt()] = -1;
		}
		long res = count_mv(x, y, mv);
		System.out.println(res);
	}

	private static long count_mv(int x, int y, long[][] mv) {
		// 初始化
		for (int i = 0; i <= y; i++) {
			mv[0][i] = 1;// 在同一行的时候，只有1种情况，右移
		}
		for (int i = 0; i <= x; i++) {
			mv[i][0] = 1;// 同一列只有一种情况
		}
		// 填表，按行、上三角形填
		for (int i = 1; i <= x; i++) {
			for (int j = 1; j <= y; j++) {
				if (mv[i][j] == -1)
					mv[i][j] = 0; // 老板位置不走,走法为0
				else
					mv[i][j] = mv[i][j - 1] + mv[i - 1][j];
			}
		}
		return mv[x][y];
	}
}
