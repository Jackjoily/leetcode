package basic;

import java.util.Arrays;

public class MiGong {
	public static void main(String[] args) {
		int map[][] = new int[10][10];
		for (int i = 0; i < 10; i++) {
			map[0][i] = 1;
			map[9][i] = 1;
			map[i][0] = 1;
			map[i][9] = 1;
		}
		map[3][1] = 1;
		map[3][2] = 1;
		map[3][3] = 1;
		map[2][3] = 1;

		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 10; j++) {
				System.out.print(map[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println();
		check(map, 1, 1);
		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 10; j++) {
				System.out.print(map[i][j] + " ");
			}
			System.out.println();
		}
	}

	// 使用递归回溯算法来个小球找路
	// （1，1）->(6,5)
	// map[i][j]=0 表示没有走过，1表示禁止，2表示不能通行，3表示该点已经走过但是走不通
	// 在走迷宫的时候需要定一个策略 下->右->上->左，如果该点走不通在回溯
	/**
	 * 
	 * @param map 表示地图
	 * @param i
	 * @param j
	 * @return 找到地图 返回true
	 * 
	 */
	public static boolean check(int[][] map, int i, int j) {
		if (map[8][8] == 2) {
			return true;
		} else {
			if (map[i][j] == 0) {
				// 按照策略走右->下->上->左
				map[i][j] = 2;// 假定该店可以走通
				if (check(map, i , j+1)) {// 向右走
					return true;
				} else if (check(map, i+1, j )) {// 向下走
					return true;
				} else if (check(map, i - 1, j)) {// 向上走
					return true;
				} else if (check(map, i, j - 1)) {// 向左走
					return true;
				} else {
					// 说明该点是走不通的，是死路
					map[i][j] = 3;
					return false;
				}
			} else {
				return false;
			}
		}
	}
}
