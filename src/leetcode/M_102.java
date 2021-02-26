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
public class M_102 {
	public List<List<Integer>> levelOrder(TreeNode root) {
		List<List<Integer>> list = new ArrayList<>();
		if (root == null)
			return list;
		Queue<TreeNode> q = new ArrayDeque<>();
		q.add(root);
		while (!q.isEmpty()) {
			List<Integer> list1 = new ArrayList<>();
			for (int i = q.size(); i >0; i--) {
				root = q.poll();
				list1.add(root.val);
				if (root.left != null) {
					q.add(root.left);
				}
				if (root.right != null) {
					q.add(root.right);
				}
			}
			list.add(list1);
		}
		return list;
	}
}
