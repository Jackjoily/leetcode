package leetcode_array;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

/**
 * 
 * 
 * @author jackjoily
 *
 */
public class M_5665 {
	public static void main(String[] args) {
		int a[][] = { { 2,1 },{3,4},{3,2} };
		System.out.println(Arrays.toString(		restoreArray(a)));
	}

	public static int[] restoreArray(int[][] adjacentPairs) {
		Deque<Integer> queue = new ArrayDeque<Integer>();
		int m = adjacentPairs.length;
		if (m == 1)
			return adjacentPairs[0];
		boolean visited[] = new boolean[m];
		queue.add(adjacentPairs[0][0]);
		queue.add(adjacentPairs[0][1]);
		visited[0] = true;
		int l = 1;
		int a[] = new int[queue.size()];
		while (l < m) {
			for (int i = 1; i < m; i++) {
				if (!visited[i]) {
					int left = adjacentPairs[i][0];
					int right = adjacentPairs[i][1];
					if (left == queue.peekFirst()) {
						queue.addFirst(right);
						visited[i] = true;
						l++;
					}else 
					if (left == queue.peekLast()) {
						queue.addLast(right);
						visited[i] = true;
						l++;
					}else 
					if (right == queue.peekFirst()) {
						queue.addFirst(left);
						visited[i] = true;
						l++;
					}else
					if (right == queue.peekLast()) {
						queue.addLast(left);
						visited[i] = true;
						l++;
					}
				
				}
			}
		}
		l = 0;
		while (queue.size() > 0) {
			a[l] = queue.poll();
			l++;
		}
		return a;
	}
}
