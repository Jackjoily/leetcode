package leetcode_tree;

/**
 * 给出一个完全二叉树，求出该树的节点个数。
 * 
 * @author jackjoily
 *
 */
public class M_222 {
	private int ret = 0;

	public int countNodes(TreeNode root) {
		if (root == null) {
			return ret;
		} else {
			dfs(root);
			return ret;
		}
	}

	public void dfs(TreeNode root) {
		if (root != null) {
			ret++;
			dfs(root.left);
			dfs(root.right);
		}
	}
}
