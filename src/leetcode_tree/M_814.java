package leetcode_tree;

/**
 * 给定二叉树根结点 root ，此外树的每个结点的值要么是 0，要么是 1。 返回移除了所有不包含 1 的子树的原二叉树。 ( 节点 X 的子树为 X
 * 本身，以及所有 X 的后代。)
 * 
 * @author jackjoily
 *
 */
public class M_814 {
	public static void main(String[] args) {
	}

	public TreeNode pruneTree(TreeNode root) {
		if (root == null) {
			return root;
		} else {
			if (!HasOne(root)) {
				return null;
			}
			return root;
		}
	}

	public boolean HasOne(TreeNode root) {
		if (root != null) {
			boolean left = HasOne(root.left);
			boolean right = HasOne(root.right);
			if (!left)
				root.left = null;
			if (!right)
				root.right = null;
			return root.val == 1 || left || right;

		} else {
			return false;
		}

	}

}
