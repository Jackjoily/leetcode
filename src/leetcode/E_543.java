package leetcode;

import java.util.Arrays;
import java.util.HashMap;

import com.sun.org.apache.xerces.internal.util.SynchronizedSymbolTable;

import leetcode_tree.TreeNode;

/**
 * twosum
 * 
 * @author jackjoily
 *
 */
public class E_543 {
	public static void main(String[] args) {
	}

	public int diameterOfBinaryTree(TreeNode root) {
		if (root == null)
			return max;
		depth(root);
		return max;
	}

	int max = 1;

	public int depth(TreeNode root) {
		if (root == null)
			return 0;
		int left = depth(root.left);
		int right = depth(root.left);
		max = Math.max(max, left + right + 1);
		return Math.max(left, right) + 1;
	}
}
