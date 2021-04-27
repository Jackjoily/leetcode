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
public class M_222 {
	int val = 0;

	public int countNodes(TreeNode root) {
		if (root == null)
			return val;
		dfs(root);
		return val;
	}

	public void dfs(TreeNode root) {
		if (root != null) {
			val++;
			dfs(root.left);
			dfs(root.right);
		}

	}
}
