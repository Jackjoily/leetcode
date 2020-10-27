package leetcode_tree;

/**
 * 给定一个二叉树，找到最长的路径，这个路径中的每个节点具有相同值。 这条路径可以经过也可以不经过根节点。
 * 
 * @author jackjoily
 *
 */
public class E_687 {
	int max = 0;

	public int longestUnivaluePath(TreeNode root) {
		if (root == null)
			return 0;
		find(root);
		return max;
	}

	public int find(TreeNode root) {
		if (root != null) {
			int maxRoars = 0;
			int left = find(root.left);
			int right = find(root.right);
			if (root.left != null && root.val == root.left.val && root.right != null && root.val == root.right.val) {
				max = Math.max(max, left + right + 2);
			}
			if (root.left != null && root.val == root.left.val) {
				maxRoars=Math.max(maxRoars,left+1);
			}
			if (root.right != null && root.val == root.right.val) {
				maxRoars=Math.max(maxRoars,right+1);
			}
			max = Math.max(max,maxRoars);
			return maxRoars;
		} else {
			return 0;
		}
	}

}
