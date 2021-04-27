package leetcode;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;

/**
 * 
 * @author jackjoily
 *
 */
public class M_406 {
	public static void main(String[] args) {
		int a[][] = { { 7, 0 }, { 4, 4 }, { 7, 1 }, { 5, 0 }, { 6, 1 }, { 5, 2 } };
		reconstructQueue(a);
	}

	public static int[][] reconstructQueue(int[][] people) {
		Arrays.sort(people, new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				if (o1[0] == o2[0]) {
					return o1[1] - o2[1];
				} else {
					return o2[0] - o1[0];
				}
			}
		});
		LinkedList<int[]> list = new LinkedList<>();
		for (int[] i : people) {
			list.add(i[1], i);
		}

		return list.toArray(new int[list.size()][2]);
	}
}
