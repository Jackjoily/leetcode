package leetcode_day;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 *
 *
 *
 * 有一堆石头，每块石头的重量都是正整数。 每一回合，从中选出两块 最重的 石头，然后将它们一起粉碎。假设石头的重量分别为 x 和 y，且 x <=
 * y。那么粉碎的可能结果如下： 如果 x == y，那么两块石头都会被完全粉碎； 如果 x !=
 * y，那么重量为 x 的石头将会完全粉碎，而重量为 y 的石头新重量为 y-x。 最后，最多只会剩下一块石头。返回此石头的重量。如果没有石头剩下，就返回
 * 0。
 *
 *
 *
 *
 *
 */
public class E_1046 {
	public static void main(String[] args) {
		int a[] = { 1, 2, 3, 4, 5, 6, 7, 8 };
		System.out.println(lastStoneWeight(a));
	}

	public static int lastStoneWeight(int[] stones) {
		if (stones.length == 1) {
			return stones[0];
		}
		PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				// TODO Auto-generated method stub
				return o2 - o1;
			}
		});
		for (int i = 0; i < stones.length; i++) {
			pq.add(stones[i]);
		}
		while (pq.size() >= 2) {
			int a = pq.poll();
			int b = pq.poll();
			if (b != a) {
				pq.add(a - b);
			}
		}
		if (pq.size() == 2) {
			int a = pq.poll();
			int b = pq.poll();
			if (a == b) {
				return 0;
			} else {
				return a - b;
			}
		} else if (pq.size() == 1) {
			return pq.peek();
		} else {
			return 0;
		}

	}
}
