package leetcode_tree;

/**
 * 二叉树的深度为根节点到最远叶子节点的最长路径上的节点数
 * 
 * @author jackjoily
 *
 */
public class E_104 {
	public int maxDepth(TreeNode root) {
		if (root != null) {
			return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
		} else {
			return 0;
		}
	}

}
