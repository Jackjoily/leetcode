package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Stack;

import com.sun.org.apache.xerces.internal.util.SynchronizedSymbolTable;

import leetcode_tree.TreeNode;
import leetcode_tree.TreeUtils;

/**
 * twosum
 * 
 * @author jackjoily
 *
 */
public class JianZhiOffer26 {
	public static void main(String[] args) {
		JianZhiOffer26 j = new JianZhiOffer26();
		TreeNode createTree = TreeUtils.createTree(4);
		TreeNode node = new TreeNode(3);
		System.out.println(j.isSubStructure(createTree, node));
	}

	public boolean isSubStructure(TreeNode A, TreeNode B) {
		if (A == null || B == null)
			return B == null ? true : false;
		Stack<TreeNode> s = new Stack<>();
		s.add(A);
		while (!s.isEmpty()) {
			A = s.pop();
			if (A.val == B.val) {
				if (isSame(A, B)) {
					return true;
				}
			} else {
				if (A.right != null) {
					s.add(A.right);
				}
				if (A.left != null) {
					s.add(A.left);
				}
			}
		}
		return false;
	}

	public boolean isSame(TreeNode a, TreeNode b) {
		if (a != null && b != null) {
			if (a.val != b.val)
				return false;
			boolean left = isSame(a.left, b.left);
			boolean right = isSame(a.right, b.right);
			return left && right;
		} else if (a == null && b == null) {
			return true;
		} else if (a == null) {
			return false;
		} else {
			return true;
		}
	}

}
