package leetcode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Stack;

import javafx.scene.shape.Line;
import leetcode_list.ListNode;
import leetcode_tree.TreeNode;

/**
 * 
 * @author jackjoily
 *
 */
public class M_145 {
	public List<Integer> postorderTraversal(TreeNode root) {
		List<Integer> list = new ArrayList<>();
		Stack<TreeNode> s = new Stack<>();
		TreeNode r = null;
		while (!s.isEmpty() || root != null) {
			if (root != null) {
				s.add(root);
				root = root.left;
			} else {
				root = s.peek();
				if (root.right != null && root.right != r) {
					root = s.pop();
					root = root.right;
					s.add(root);
					root = root.left;
				} else {
					root = s.pop();
					list.add(root.val);
					r=root;
					root=null;
				}
			}
		}
		return list;
	}
}
