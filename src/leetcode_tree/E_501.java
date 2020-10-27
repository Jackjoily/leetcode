package leetcode_tree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class E_501 {
	private TreeNode preNode = null;
	private int curCount = 1;
	private int maxCount = 1;

	public int[] findMode(TreeNode root) {
		List<Integer> nums = new ArrayList<>();
		inOrder(root, nums);
		int i = 0;
		int[] res = new int[nums.size()];
		for (int num : nums) {
			res[i++] = num;
		}
		return res;
	}
	private void inOrder(TreeNode node, List<Integer> nums) {
		if (node == null) {
			return;
		}
		inOrder(node.left, nums);
		if (preNode != null) {
			if (preNode.val == node.val) {
				curCount++;
			} else {
				curCount = 1;
			}
		}
		if (curCount > maxCount) {
			maxCount = curCount;
			//这里产生更新
			nums.clear();
			nums.add(node.val);
		} else if (curCount == maxCount) {
			nums.add(node.val);
		}
		preNode = node;
		inOrder(node.right, nums);
	}

}
