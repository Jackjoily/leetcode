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

import javafx.scene.shape.Line;
import leetcode_list.ListNode;
import leetcode_tree.TreeNode;

/**
 * 
 * @author jackjoily
 *
 */
public class M_347 {
	public static void main(String[] args) {
		int a[] = { 4, 1, -1, 2, -1, 2, 3 };
		System.out.println(Arrays.toString(topKFrequent(a,2)));
	}

	public static int[] topKFrequent(int[] nums, int k) {
		Map<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < nums.length; i++) {
			map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
		}
		PriorityQueue<Integer> p = new PriorityQueue<>((x, y) -> (map.get(x) - map.get(y)));
		Set<Integer> set = map.keySet();
		for (int i : set) {
			if (p.size() < k) {
				p.add(i);
			} else {
				if (map.get(i) > map.get(p.peek())) {
					p.poll();
					p.add(i);
				}
			}
		}
		int j = 0;
		int a[] = new int[k];
		while (p.size() != 0) {
			a[j] = p.poll();
			j++;
		}
		return a;
	}
}
