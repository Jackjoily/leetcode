package leetcode_tree;

import java.util.HashMap;
import java.util.Map;

public class M_106 {

	public static void main(String[] args) {
		int a[] = { 1, 2 };
		int b[] = { 2, 1 };
		preOrder(buildTree(a, b));
	}

	private static Map<Integer, Integer> map = new HashMap<>();

	public static TreeNode buildTree(int[] inorder, int[] postorder) {
		for (int i = 0; i < inorder.length; i++) {
			map.put(inorder[i], i);
		}
		return createNode(0, postorder.length - 1, 0, inorder.length - 1, inorder, postorder);
	}

	public static TreeNode createNode(int plow, int phigh, int ilow, int ihigh, int[] inorder, int[] postorder) {
		if (plow > phigh || plow < 0) {
			return null;
		}
		TreeNode node = new TreeNode(postorder[phigh]);
		int k = map.get(postorder[phigh]);
		int num = ihigh - k;
		node.right = createNode(phigh - num, phigh - 1, k + 1, ihigh, inorder, postorder);
		node.left = createNode(plow, phigh - num - 1, ilow, k - 1, inorder, postorder);
		return node;
	}

	public static void preOrder(TreeNode node) {
		if (node != null) {
			System.out.println(node.val);
			preOrder(node.left);
			preOrder(node.right);
		}
	}
}
