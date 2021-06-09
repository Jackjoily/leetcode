package leetcode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;

/**
 * 
 * 这是一道典型的拓扑排序题目
 * 
 * @author jackjoily
 *
 */
public class M_1353 {
	public static void main(String[] args) {

		int a[][] = { { 1, 1 }, { 1, 1 }, { 1, 1 }, { 1, 1 }, { 1, 1 } };
		System.out.println(maxEvents(a));
	}

	public static int maxEvents(int[][] events) {
		Arrays.sort(events, Comparator.comparingInt(o -> o[0]));
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		int i = 0, start = 1, count = 0;
		while (i < events.length || !pq.isEmpty()) {
			while (!pq.isEmpty() && pq.peek() < start) {
				pq.poll();
			}
			while (i < events.length && events[i][0] <= start) {
				pq.add(events[i++][0]);
			}
			if (!pq.isEmpty()) {
				pq.poll();
				count++;
			}
			start++;
		}
		return count;
	}
}
