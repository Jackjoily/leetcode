package newcoder;

import java.util.HashMap;
import java.util.Map;

import leetcode_tree.TreeNode;
import leetcode_tree.TreeUtils;

public class NC12 {
	/**
	 * 根据前序遍历和后序遍历重建二叉树
	 */
	public static void main(String[] args) {
		// int a[] = { 1, 2, 3, 4, 5, 6, 7 };
		// int b[] = { 3, 2, 4, 1, 6, 5, 7 };
		int a[] = { };
		int b[]= {};
		NC12 n = new NC12();
		TreeNode reConstructBinaryTree = n.reConstructBinaryTree(a, b);
		TreeNode.InOrder(reConstructBinaryTree);
		TreeNode.LevelOrder(reConstructBinaryTree);
	}

	Map<Integer, Integer> map = new HashMap<>();

	public TreeNode reConstructBinaryTree(int[] pre, int[] in) {
		int n = pre.length;
		if (n == 0)
			return null;
		for (int i = 0; i < in.length; i++) {
			map.put(in[i], i);
		}
		return create(pre, 0, n - 1, in, 0, n - 1);
	}

	public TreeNode create(int[] pre, int pl, int ph, int[] in, int il, int ih) {
		if (pl > ph)
			return null;
		else {
			TreeNode node = new TreeNode(pre[pl]);
			int k = map.get(pre[pl]);
			int num = k - il;
			node.left = create(pre, pl + 1, pl + num, in, il, k - 1);
			node.right = create(pre, pl + num + 1, ph, in, k + 1, ih);
			return node;
		}

	}
}
