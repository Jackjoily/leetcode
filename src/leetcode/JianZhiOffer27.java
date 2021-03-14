package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import com.sun.org.apache.xerces.internal.util.SynchronizedSymbolTable;

import leetcode_tree.TreeNode;

/**
 * twosum
 * 
 * @author jackjoily
 *
 */
public class JianZhiOffer27 {
	public TreeNode mirrorTree(TreeNode root) {
		if (root == null)
			return root;
		change(root);
		return root;
	}

	public void change(TreeNode root) {
		if (root != null) {
			change(root.left);
			change(root.right);
			TreeNode temp = root.left;
			root.left = root.right;
			root.right = temp;
		}
	}
}
