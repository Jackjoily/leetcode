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
public class M_199 {
	List<Integer> list = new ArrayList<>();

	public List<Integer> rightSideView(TreeNode root) {
		if (root == null)
			return list;
		Queue<TreeNode> q = new ArrayDeque<>();
		q.add(root);
		while (!q.isEmpty()) {
			for (int i = q.size(); i >= 1; i--) {
				root = q.poll();
				if (i == 1) {
					list.add(root.val);
				}
				if (root.left != null) {
					q.add(root.left);
				}
				if (root.right != null) {
					q.add(root.right);
				}
			}
		}
		return list;
	}
}
