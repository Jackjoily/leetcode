package leetcode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;

import javafx.scene.shape.Line;
import leetcode_list.ListNode;
import leetcode_tree.TreeNode;

/**
 * 
 * @author jackjoily
 *
 */
public class M_264 {
	public static void main(String[] args) {
		System.out.println(nthUglyNumber(1690));
	}

	public static int nthUglyNumber(int n) {
		if (n == 1)
			return 1;
		PriorityQueue<Long> q = new PriorityQueue<>();
		q.add(1L);
		Set<Long> set = new HashSet<>();
		set.add(1L);
		long poll = 0L;
		for (int i = 0; i < n; i++) {
			poll = q.poll();
			if (set.add(poll * 2)) {
				q.add(poll * 2);
			}
			if (set.add(poll * 3)) {
				q.add(poll * 3);
			}
			if (set.add(poll * 5)) {
				q.add(poll * 5);
			}
		}
		return (int) poll;
	}
}
