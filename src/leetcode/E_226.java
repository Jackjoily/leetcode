package leetcode;

import java.util.Arrays;
import java.util.HashMap;

import com.sun.org.apache.xerces.internal.util.SynchronizedSymbolTable;

import leetcode_tree.TreeNode;
import leetcode_tree.TreeUtils;

/**
 * twosum
 * 
 * @author jackjoily
 *
 */
public class E_226 {
	public static void main(String[] args) {
		TreeNode createTree = TreeUtils.createTree(7);
		TreeNode invertTree = new E_226().invertTree(createTree);
		TreeNode.LevelOrder(invertTree);
	}

	public TreeNode invertTree(TreeNode root) {
		if (root == null)
			return null;
		TreeNode right = invertTree(root.left);
		TreeNode left = invertTree(root.right);
		root.right = right;
		root.left = left;
		return root;
	}
}
