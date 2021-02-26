package leetcode_array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;

/**
 * 
 * 给你 n 个非负整数 a1，a2，...，an，每个数代表坐标中的一个点  (i, ai) 。在坐标内画 n 条垂直线，垂直线 i 的两个端点分别为 
 * (i, ai) 和 (i, 0) 。找出其中的两条线，使得它们与 x 轴共同构成的 容器可以容纳最多的水。
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
		Arrays.sort(people, (o1, o2) -> o1[0] == o2[0] ? o1[1] - o2[1] : o2[0] - o1[0]);
		LinkedList<int[]> list = new LinkedList<>();
		for (int[] i : people) {
			list.add(i[1], i);
		}
		return list.toArray(new int[list.size()][2]);
	}
}
