package leetcode_tree;

public class E_404 {
	public int sumOfLeftLeaves(TreeNode root) {
		if (root == null) {
			return 0;
		} else {
			dfs(root);
		}
		return res;
	}

	int res = 0;

	public void dfs(TreeNode root) {
		if (root != null) {
			if (root.left != null) {
				if (root.left == null && root.right == null) {
					res += root.left.val;
				}
		
			}
		}
	}
}
