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
public class E_110 {
	public boolean isBalanced(TreeNode root) {
		if (root == null)
			return true;
		if (Math.abs(h(root.left) - h(root.right)) > 1) {
			return false;
		} else {
			return isBalanced(root.left) && isBalanced(root.right);
		}
	}

	public int h(TreeNode root) {
		if (root == null) {
			return 0;
		} else {
			int left = h(root.left);
			int right = h(root.right);
			return Math.max(right, left) + 1;
		}
	}

}
