package leetcode_array;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.PriorityQueue;
import java.util.Set;

/**
 * 给定一个非空的整数数组，返回其中出现频率前 k 高的元素。
 * 
 * @author jackjoily
 *
 */
public class M_347 {
	public int[] topKFrequent(int[] nums, int k) {
		int n[] = new int[k];
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		for (int i = 0; i < nums.length; i++) {
			map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
		}
//优先级队列
		PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> {
			return map.get(a) - map.get(b);
		});

		for (Integer key : map.keySet()) {
			if (pq.size() < k) {
				pq.add(key);
			} else if (map.get(key) > map.get(pq.peek())) {
				pq.remove();
				pq.add(key);
			}
		}
		int m = 0;
		while (!pq.isEmpty()) {
			n[m] = pq.remove();
			m++;
		}
		return n;

	}
}
