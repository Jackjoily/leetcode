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
import leetcode_tree.TreeUtils;

/**
 * 
 * @author jackjoily
 *
 */
public class M_106 {
	public static void main(String[] args) {
		M_106 m = new M_106();
		int a[] = { 4, 2, 5, 1, 6, 3, 7 };
		int b[] = { 4, 5, 2, 6, 7, 3, 1 };
		TreeNode.LevelOrder(m.buildTree(a, b));
	}

	Map<Integer, Integer> map = new HashMap<>();

	public TreeNode buildTree(int[] inorder, int[] postorder) {
		int length = inorder.length;
		if(length==0)return null;
		for (int i = 0; i < length; i++) {
			map.put(inorder[i], i);
		}
		return createTreeNode(inorder, 0, length - 1, postorder, 0, length - 1);
	}

	public TreeNode createTreeNode(int[] in, int il, int ih, int po[], int pl, int ph) {
		if (pl > ph)
			return null;
		int n = po[ph];
		TreeNode node = new TreeNode(n);
		int idx = map.get(n);
		int num = idx - il;
		node.left = createTreeNode(in, il, idx - 1, po, pl, pl + num - 1);
		node.right = createTreeNode(in, idx + 1, ih, po, pl + num, ph - 1);
		return node;
	}
}
