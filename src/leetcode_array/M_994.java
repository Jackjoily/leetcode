package leetcode_array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/**
 * 在给定的网格中，每个单元格可以有以下三个值之一：
 * 
 * 值 0 代表空单元格； 值 1 代表新鲜橘子； 值 2 代表腐烂的橘子。 每分钟，任何与腐烂的橘子（在 4 个正方向上）相邻的新鲜橘子都会腐烂。
 * 
 * @author jackjoily
 *
 */
public class M_994 {
	public static void main(String[] args) {
		int a[][] = { { 2, 1 } };
		System.out.println(orangesRotting(a));
	}

	public static int orangesRotting(int[][] grid) {
		int m = grid.length;
		int n = grid[0].length;
		int count = 0;
		int times = 0;
		HashSet<String> map = new HashSet<>();
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (grid[i][j] == 1) {
					count++;
				}
				if (grid[i][j] == 2) {
					map.add(i + "" + j);
				}
			}
		}
		if (count == 0)
			return 0;
		while (map.size() > 0) {
			Set<String> keySet = map;
			map = new HashSet<>();
			for (String string : keySet) {
				int i = string.charAt(0) - '0';
				int j = string.charAt(1) - '0';
				if (grid[i][j] == 2) {
					if (i - 1 >= 0 && grid[i - 1][j] == 1) {
						grid[i - 1][j] = 2;
						map.add(i - 1 + "" + j);
						count--;
					}
					if (j - 1 >= 0 && grid[i][j - 1] == 1) {
						grid[i][j - 1] = 2;
						map.add(i + "" + (j - 1));
						count--;
					}
					if (i + 1 < m && grid[i + 1][j] == 1) {
						grid[i + 1][j] = 2;
						map.add((i + 1) + "" + j);
						count--;
					}
					if (j + 1 < n && grid[i][j + 1] == 1) {
						grid[i][j + 1] = 2;
						map.add(i + "" + (j + 1));
						count--;
					}
				}

			}
			times++;
			if (count == 0)
				return times;
		}
		return -1;
	}
}
