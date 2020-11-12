package JianZhiOffer;

import leetcode_tree.TreeNode;
import leetcode_tree.TreeUtils;

/**
 * 
 * 输入一棵二叉树的根节点，判断该树是不是平衡二叉树。 如果某二叉树中任意节点的左右子树的深度相差不超过1， 那么它就是一棵平衡二叉树。
 * 
 * @author jackjoily
 *
 */
public class JianZhiOffer55II {
	public static void main(String[] args) {
		JianZhiOffer55II j = new JianZhiOffer55II();
		TreeNode createTree = TreeUtils.createTree(7);
		System.out.println(j.isBalanced(createTree));
	}
	boolean flag = true;
	public boolean isBalanced(TreeNode root) {
		if (root == null)
			return true;
		height(root);
		return flag;
	}

	public int height(TreeNode root) {
		if (root != null) {
			int left = height(root.left);
			int right = height(root.right);
			if(Math.abs(left-right)>=2) {
				flag = false;
			}
			return left > right ? left + 1 : right + 1;
		} else {
			return 0;
		}
	}
}
