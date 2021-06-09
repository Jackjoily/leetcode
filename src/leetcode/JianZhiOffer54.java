package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Stack;

import com.sun.org.apache.xerces.internal.util.SynchronizedSymbolTable;

import leetcode_tree.TreeNode;

/**
 * twosum
 * 
 * @author jackjoily
 *
 */
public class JianZhiOffer54 {
	public int kthLargest(TreeNode root, int k) {
		Stack<TreeNode> s = new Stack<>();
		List<Integer> list = new ArrayList<>();
		while (!s.isEmpty() || root != null) {
			if (root != null) {
				s.add(root);
				root = root.left;
			} else {
				root = s.pop();
				list.add(root.val);
				root = root.right;
			}
		}
		return list.get(list.size() - k);
	}
}
