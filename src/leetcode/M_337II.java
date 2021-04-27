package leetcode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Queue;

import basic.Node;
import javafx.scene.shape.Line;
import leetcode_list.ListNode;
import leetcode_tree.TreeNode;

/**
 * 
 * @author jackjoily
 *
 */
public class M_337II {
	HashMap<TreeNode, Integer> s = new HashMap<>();
	HashMap<TreeNode, Integer> us = new HashMap<>();

	public int rob(TreeNode root) {
		if (root == null)
			return 0;
		dfs(root);
		return Math.max(s.getOrDefault(root, 0), us.getOrDefault(root, 0));
	}

	public void dfs(TreeNode root) {
		if (root != null) {
			dfs(root.left);
			dfs(root.right);
			s.put(root, root.val + Math.max(s.getOrDefault(root.left, 0), us.getOrDefault(root.right, 0)));
			us.put(root, Math.max(s.getOrDefault(root.left, 0), us.getOrDefault(root.left, 0))
					+ Math.max(s.getOrDefault(root.right, 0), us.getOrDefault(root.right, 0)));
		}
	}
}
