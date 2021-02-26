package leetcode_day;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * 给你一个由一些多米诺骨牌组成的列表 dominoes。 如果其中某一张多米诺骨牌可以通过旋转 0 度或 180
 * 度得到另一张多米诺骨牌，我们就认为这两张牌是等价的。 形式上，dominoes[i] = [a, b] 和 dominoes[j] = [c,
 * d] 等价的前提是 a==c 且 b==d，或是 a==d 且 b==c。 在 0 <= i < j <
 * dominoes.length 的前提下，找出满足 dominoes[i] 和 dominoes[j] 等价的骨牌对 (i, j) 的数量。
 */
public class E_1128 {
	public static void main(String[] args) {
		int a[][] = { { 1, 2 }, { 2, 1 }, { 3, 4 }, { 3, 4 }, { 4, 3 }, { 3, 4 } };
		System.out.println(numEquivDominoPairs1(a));
	}

	/**
	 * 使用暴力的方法
	 * 
	 * @param dominoes
	 * @return
	 */
	public static int numEquivDominoPairs(int[][] dominoes) {
		int m = dominoes.length;
		if (m == 0)
			return 0;
		int count = 0;
		for (int i = 0; i < m; i++) {
			for (int j = i + 1; j < m; j++) {
				if ((dominoes[i][0] == dominoes[j][0] && dominoes[i][1] == dominoes[j][1])
						|| (dominoes[i][1] == dominoes[j][0] && dominoes[i][0] == dominoes[j][1])) {
					count++;
				}
			}
		}
		return count;
	}

	public static int numEquivDominoPairs1(int[][] dominoes) {
		int m = dominoes.length;
		if (m == 0)
			return 0;
		int count = 0;
		Map<Integer, Integer> map = new HashMap<>();
		map.put(dominoes[0][0] * 10 + dominoes[0][1], 1);
		for (int i = 1; i < m; i++) {
			int a = dominoes[i][0] * 10 + dominoes[i][1];
			int b = dominoes[i][1] * 10 + dominoes[i][0];
			if (map.containsKey(a)) {
				count += map.get(a);
				map.put(a, map.get(a) + 1);
			} else if (map.containsKey(b)) {
				count += map.get(b);
				map.put(b, map.get(b) + 1);
			} else {
				map.put(a, 1);
			}
		}
		return count;
	}

	/**
	 * 官方的解法
	 * 
	 * @param dominoes
	 * @return
	 */
	public int numEquivDominoPairs3(int[][] dominoes) {
		int[] num = new int[100];
		int ret = 0;
		for (int[] domino : dominoes) {
			int val = domino[0] < domino[1] ? domino[0] * 10 + domino[1] : domino[1] * 10 + domino[0];
			ret += num[val];
			num[val]++;
		}
		return ret;
	}
}
