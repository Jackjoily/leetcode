package JianZhiOffer;

import java.util.HashMap;
import java.util.Map;

import leetcode_tree.TreeNode;
import leetcode_tree.TreeUtils;

/**
 * 
 * 请完成一个函数，输入一个二叉树，该函数输出它的镜像。
 * 
 * @author jackjoily
 *
 */
public class JianZhiOffer27 {
	public static void main(String[] args) {
		JianZhiOffer27 j = new JianZhiOffer27();
		TreeNode createTree = TreeUtils.createTree(7);
		TreeNode.InOrder(createTree);
		TreeNode mirrorTree = j.mirrorTree(createTree);
		TreeNode.InOrder(mirrorTree);
	}

	public TreeNode mirrorTree(TreeNode root) {
		if (root == null)
			return root;
		swap(root);
		return root;
	}

	public void swap(TreeNode root) {
		if (root != null) {
			swap(root.left);
			swap(root.right);
			TreeNode temp = root.left;
			root.left = root.right;
			root.right = temp;
		}
	}
}
