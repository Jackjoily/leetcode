package leetcode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;

import edu.princeton.cs.algs4.Stack;
import javafx.scene.shape.Line;
import leetcode_list.ListNode;
import leetcode_tree.TreeNode;

/**
 * 
 * @author jackjoily
 *
 */
public class M_230 {
	public int kthSmallest(TreeNode root, int k) {
		Stack<TreeNode> s = new Stack<>();
		while (!s.isEmpty() || root != null) {
			if (root != null) {
				s.push(root);
				root = root.left;
			} else {
				root = s.pop();
				k--;
				if (k == 0)
					return root.val;
				root = root.right;
			}
		}
		return k;
	}

}
