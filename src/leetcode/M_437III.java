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
import leetcode_tree.TreeUtils;

/**
 * 
 * @author jackjoily
 *
 */
public class M_437III {
	public static void main(String[] args) {
		M_437III m = new M_437III();
		Integer a[] = { 10, 5, -3, 3, 2, null, 11, 3, -2, null, 1 };
		TreeNode createTree = TreeUtils.createBinaryTreeByArray(a);
		System.out.println(m.pathSum1(createTree, 8));
	}

	public int pathSum1(TreeNode root, int sum) {
		Map<Integer, Integer> prefixSumCount = new HashMap<>();
		prefixSumCount.put(0, 1);
		return recursionPathSum(root, prefixSumCount, sum, 0);
	}

	private int recursionPathSum(TreeNode root, Map<Integer, Integer> prefixSumCount, int target, int curr) {
		if (root == null)
			return 0;
		int res = 0;
		curr += root.val;
		res = prefixSumCount.getOrDefault(curr - target, 0);
		prefixSumCount.put(curr, res + 1);
		res += recursionPathSum(root.left, prefixSumCount, target, curr);
		res += recursionPathSum(root.right, prefixSumCount, target, curr);
		prefixSumCount.put(curr, prefixSumCount.get(curr) - 1);
		return res;
	}

	int n = 0;

	public int pathSum(TreeNode root, int targetSum) {
		if (root == null)
			return 0;
		dfs(root, targetSum);
		return n;
	}

	public void dfs(TreeNode root, int targetSum) {
		if (root != null) {
			dfs1(root, targetSum);
			dfs(root.left, targetSum);
			dfs(root.right, targetSum);
		}
	}

	public void dfs1(TreeNode root, int val) {
		if (root != null) {
			if (val - root.val == 0) {
				n++;
			}
			dfs1(root.left, val - root.val);
			dfs1(root.right, val - root.val);
		}
	}
}
