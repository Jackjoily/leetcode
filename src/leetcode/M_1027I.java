package leetcode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Queue;

import javafx.scene.shape.Line;
import leetcode_list.ListNode;
import leetcode_tree.TreeNode;

/**
 * 
 * @author jackjoily
 *
 */
public class M_1027I {
	public static void main(String[] args) {
		int a[] = { 3,2, 1 ,6 ,7, 10, 9, 13, 12, 14, 15};
		System.out.println(longestArithSeqLength(a));
	}
	public static int longestArithSeqLength(int[] A) {
		int len = A.length;
		if (len < 2) {
			return 0;
		}
		int res = 0;
		Map<Integer, Map<Integer, Integer>> map = new HashMap<>();
		int i = 0, j = 0;
		for (i = 0; i < len; i++) {
			map.put(i, new HashMap<>());
			int cur = 0;
			for (j = i - 1; j >= 0; j--) {
				int key = A[i] - A[j];
				if (map.get(i).containsKey(key))
					continue;
				cur = map.get(j).getOrDefault(key, 0);
				if (cur == 0) {
					res = Math.max(res, 2);
					map.get(i).put(key, cur + 2);
				} else {
					res = Math.max(res, cur + 1);
					map.get(i).put(key,cur + 1);
				}
			}
		}
		return res;
	}
}
