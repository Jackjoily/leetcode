package leetcode_tree;

/**
 * 给定二叉搜索树（BST）的根节点和一个值。 你需要在BST中找到节点值等于给定值的节点。 返回以该节点为根的子树。 如果节点不存在，则返回 NULL。
 * 
 * @author jackjoily
 *
 */
public class E_700 {
	public TreeNode searchBST(TreeNode root, int val) {
		if (root == null) {
			return null;
		} else {
			if (root.val < val) {
				return searchBST(root.right, val);
			} else if (root.val > val) {
				return searchBST(root.left, val);
			} else {
				return root;
			}
		}
	}

}
