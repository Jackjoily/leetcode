package leetcode_tree;

/**
 * 翻转一棵二叉树。
 * 
 * @author jackjoily
 *
 */
public class E_226 {
	TreeNode temp = null;

	public TreeNode invertTree(TreeNode root) {
		if (root == null) {
			return root;
		} else {
			swap(root);
		}
		return root;
	}

	public void swap(TreeNode root) {
		if (root == null) {
			return;
		} else {
			temp = root.left;
			root.left = root.right;
			root.right = temp;
			swap(root.left);
			swap(root.right);
		}
	}
}
