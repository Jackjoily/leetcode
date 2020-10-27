package leetcode_tree;

public class TreeUtils {
	/**
	 * 建立一颗含有n个节点的完全二叉树
	 * 
	 * @param n
	 * @return
	 */
	public static TreeNode createTree(int n) {
		TreeNode[] t = new TreeNode[n];
		for (int i = 0; i < n; i++) {
			t[i] = new TreeNode(i + 1);
		}
		for (int i = n / 2 - 1; i >= 0; i--) {
			t[i].left = t[2 * i + 1];
			if (i == (n / 2) - 1 && (2 * (i + 1) + 1) != n) {
				t[i].right = null;
			} else {
				t[i].right = t[2 * i + 2];
			}

		}
		return t[0];
	}
}
