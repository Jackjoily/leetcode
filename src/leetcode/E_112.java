package leetcode;

import java.util.Arrays;
import java.util.HashMap;

import com.sun.org.apache.xerces.internal.util.SynchronizedSymbolTable;

import edu.princeton.cs.algs4.In;
import leetcode_tree.TreeNode;

/**
 * twosum
 * 
 * @author jackjoily
 *
 */
public class E_112 {
	public static void main(String[] args) {
	}

	public boolean hasPathSum(TreeNode root, int targetSum) {
		if (root == null)
			return false;
		f(root, targetSum);
		return flag;
	}

	boolean flag = false;

	public void f(TreeNode root, int targetSum) {
		if (root != null && !flag) {
			if (targetSum - root.val == 0) {
				if (root.left == null && root.right == null) {
					flag = true;
					return;
				}
				f(root.left, targetSum - root.val);
				f(root.right, targetSum - root.val);
			} else {
				f(root.left, targetSum - root.val);
				f(root.right, targetSum - root.val);
			}
		}
	}
}
