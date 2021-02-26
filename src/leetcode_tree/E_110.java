package leetcode_tree;
/**
 * 判断二叉树是否是平衡二叉树
 * @author jackjoily
 *
 */
public class E_110 {
	public boolean isBalanced(TreeNode root) {
		if (root == null) {
			return true;
		} else {
			if (Math.abs(height(root.left) - height(root.right)) > 1) {
				return false;
			} else {
				return isBalanced(root.left) & isBalanced(root.right);
			}
		}

	}

	public int height(TreeNode root) {
		if (root != null) {
			return Math.max(height(root.left), height(root.right)) + 1;
		} else {
			return 0;
		}

	}
}
