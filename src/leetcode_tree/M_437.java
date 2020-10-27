package leetcode_tree;

/**
 * 给定一个二叉树，它的每个结点都存放着一个整数值。
 * 
 * 找出路径和等于给定数值的路径总数。
 * 
 * 路径不需要从根节点开始，也不需要在叶子节点结束，但是路径方向必须是向下的（只能从父节点到子节点）。
 * 
 * 二叉树不超过1000个节点，且节点数值范围是 [-1000000,1000000] 的整数。
 * 
 * @author jackjoily
 *
 */
public class M_437 {
	int ans = 0;

	public int pathSum(TreeNode root, int sum) {
		dfs1(root, sum);
		return ans;
	}

	public void dfs1(TreeNode root, int sum) {
		if (root != null) {
			dfs(root, sum);
			dfs1(root.left, sum);
			dfs1(root.right, sum);
		}
	}

	public void dfs(TreeNode root, int sum) {
		if (root == null) {
			return;
		}
		sum -= root.val;
		if (sum == 0) {
			ans++;
		}
		dfs(root.left, sum);
		dfs(root.left, sum);

	}

}
