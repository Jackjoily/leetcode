package leetcode_array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 给出一个区间的集合，请合并所有重叠的区间。
 * 
 * @author jackjoily
 *
 */
public class M_56 {
	public static void main(String[] args) {
		M_56 m = new M_56();
		int a[][] = { { 1, 3 }, { 2, 6 }, { 8, 10 }, { 15, 18 } };

		System.out.println(Arrays.deepToString(m.merge(a)));
	}

	public int[][] merge(int[][] intervals) {
		// 先按照区间起始位置排序
		Arrays.sort(intervals, (v1, v2) -> v1[0] - v2[0]);
		// 遍历区间
		int[][] res = new int[intervals.length][2];
		int idx = -1;
		for (int[] interval : intervals) {
			// 如果结果数组是空的，或者当前区间的起始位置 > 结果数组中最后区间的终止位置，
			// 则不合并，直接将当前区间加入结果数组。
			if (idx == -1 || interval[0] > res[idx][1]) {
				res[++idx] = interval;
			} else {
				// 反之将当前区间合并至结果数组的最后区间
				res[idx][1] = Math.max(res[idx][1], interval[1]);
			}
		}
		return Arrays.copyOf(res, idx + 1);
	}

}
