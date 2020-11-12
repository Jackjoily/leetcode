package leetcode_day;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * 我们有一个由平面上的点组成的列表 points。 需要从中找出 K 个距离原点 (0, 0) 最近的点。
 * 
 * @author jackjoily
 *
 */
public class M_973 {
	public static void main(String[] args) {
		M_973 m = new M_973();
		int a[][] = { {3,3},{5,-1},{-2,4} };
		int[][] kClosest = m.kClosest(a, 2);
		System.out.println(Arrays.deepToString(kClosest));
	}

	public int[][] kClosest(int[][] points, int K) {
		if (points.length < K)
			return new int[0][0];
		Map<Integer, List<int[]>> map = new HashMap<>();
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		for (int i = 0; i < points.length; i++) {
			int val = getVal(points[i]);
			if (!map.containsKey(val)) {
				List<int[]> list = new ArrayList<>();
				list.add(points[i]);
				map.put(val, list);
			} else {
				List<int[]> list = map.get(val);
				list.add(points[i]);
				map.put(val, list);
			}
			pq.add(val);
		}
		int k = 0;
		int a[][] = new int[K][];
		while (k < K) {
			List<int[]> list = map.get(pq.poll());
			for (int l = k; l < k + list.size(); l++) {
				a[l] = list.get(l - k);
			}
			k += list.size();
		}
		return a;
	}

	public int getVal(int a[]) {
		return (a[0] * a[0] + a[1] * a[1]);
	}
}
