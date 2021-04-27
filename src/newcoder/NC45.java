package newcoder;

import java.util.Arrays;

import leetcode_tree.TreeNode;
import leetcode_tree.TreeUtils;

public class NC45 {
	public static void main(String[] args) {
		NC45 n = new NC45();
		TreeNode node = TreeUtils.createTree(5);
		n.threeOrders(node);
	}

	public int[][] threeOrders(TreeNode root) {
		if (root == null)
			return new int[0][0];
		int n = getSize(root);
		a = new int[3][n];
		order(root);
		System.out.println(Arrays.deepToString(a));
		return a;
	}

	int i = 0, j = 0, k = 0;

	int a[][];

	public int getSize(TreeNode root) {
		if (root == null)
			return 0;
		return getSize(root.left) + getSize(root.right) + 1;
	}

	public void order(TreeNode root) {
		if (root != null) {
			a[0][i++] = root.val;
			order(root.left);
			a[1][j++] = root.val;
			order(root.right);
			a[2][k++] = root.val;
		}
	}

}
