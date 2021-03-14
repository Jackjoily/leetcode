package leetcode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
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
public class M_103 {
	List<List<Integer>> list = new ArrayList<>();

	public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
		Queue<TreeNode> q = new ArrayDeque<>();
		if (root == null)
			return list;
		q.add(root);
		int k = 0;
		List<Integer> list1 = new ArrayList<>();
		while (!q.isEmpty()) {
			for (int i = q.size(); i >= 1; i--) {
				root = q.poll();
				list1.add(root.val);
				if (root.left != null) {
					q.add(root.left);
				}
				if (root.right != null) {
					q.add(root.right);
				}
			}
			if (k % 2 != 0) {
				Collections.reverse(list1);
			}
			list.add(new ArrayList<>(list1));
			list1.clear();
			k++;
		}
		return list;
	}
}
