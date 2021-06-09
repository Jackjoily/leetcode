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
public class M_105 {
	Map<Integer, Integer> map = new HashMap<>();

	public TreeNode buildTree(int[] preorder, int[] inorder) {
		int n = preorder.length;
		if (n == 0)
			return null;
		for (int i = 0; i < n; i++) {
			map.put(inorder[i], i);
		}
		return createTree(preorder, 0, n - 1, inorder, 0, n - 1);
	}

	public TreeNode createTree(int p[], int pl, int ph, int i[], int il, int ih) {
		if (ph > pl)
			return null;
		int inx = map.get(p[pl]);
		TreeNode root = new TreeNode(p[pl]);
		int k = map.get(p[pl]);
		int num = k - il;
		root.left = createTree(p, pl + 1, pl + num, i, il, k - 1);
		root.right = createTree(p, pl + num + 1, ph, i, k + 1, ih);
		return root;
	}
}
