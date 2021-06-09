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
public class M_974 {

	public int subarraysDivByK(int[] nums, int k) {
		Map<Integer, Integer> map = new HashMap<>();
		map.put(0, 1);
		int sum = 0;
		int n = 0;
		for (int elm : nums) {
			sum += elm;
			int mod = (sum % k + k) % k;
			int same = map.getOrDefault(mod, 0);
			n += same;
			map.put(mod, same + 1);
		}
		return n;
	}
}
