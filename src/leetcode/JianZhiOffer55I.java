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
public class JianZhiOffer55I {
	public int maxDepth(TreeNode root) {
		if (root == null)
			return 0;
		int a = maxDepth(root.left);
		int b = maxDepth(root.right);
		return Math.max(a, b) + 1;
	}
}
