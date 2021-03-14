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
public class E_111 {
	public static void main(String[] args) {
	}

	public int minDepth(TreeNode root) {
		if (root == null)
			return 0;
		int min = Integer.MAX_VALUE;
		int count = 0;
		f(root, min, count);
		return min;
	}

	public void f(TreeNode root, int min, int count) {
		if (root != null) {
			count++;
			if (root.left == null && root.right == null) {
                min=Math.min(min,count)  ;
				return ;
			}
			f(root.left, min, count);
			f(root.right, min, count);
		}
	}
}
