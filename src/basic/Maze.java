package basic;

public class Maze {

	// 使用递归和回溯解决迷宫问题
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

	public static boolean check(int[][] map, int i, int j) {
		if (map[8][8] == 2) {
			return true;
		} else {
			// 下右左上
			if (map[i][j] == 0) {
				map[i][j] = 2;
				if (check(map, i+1, j )) {// 向右走
					return true;
				} else if (check(map, i, j+1)) {// 向下走
					return true;
				} else if (check(map, i - 1, j)) {// 向上走
					return true;
				} else if (check(map, i, j - 1)) {// 向左走
					return true;
				} else {
					map[i][j] = 3;
					return false;
				}
			} else {
				return false;
			}
		}

	}

}
