package JianZhiOffer;

import java.util.HashMap;
import java.util.Map;

import leetcode_tree.TreeNode;
import leetcode_tree.TreeUtils;

/**
 * 找出数组中重复的数字。
 * 
 * 统计一个数字在排序数组中出现的次数。
 * 
 * @author jackjoily
 *
 */
public class JianZhiOffer55_I {
	public static void main(String[] args) {
		JianZhiOffer55_I j = new JianZhiOffer55_I();
	}

	public int search(int[] nums, int target) {
		int count = 0;
		if (nums.length == 0)
			return count;
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] > target)
				return count;
			else if (nums[i] == target)
				count++;
		}
		return count;
	}
}
