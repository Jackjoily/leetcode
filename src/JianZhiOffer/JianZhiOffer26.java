package JianZhiOffer;

import java.util.HashMap;
import java.util.Map;

import edu.princeton.cs.algs4.Stack;
import leetcode_tree.TreeNode;

/**
 * 找出数组中重复的数字。
 * 
 * 
 * 输入两棵二叉树A和B，判断B是不是A的子结构。(约定空树不是任意一个树的子结构) B是A的子结构， 即 A中有出现和B相同的结构和节点值。
 * 
 * 
 * @author jackjoily
 *
 */
public class JianZhiOffer26 {
	public boolean isSubStructure(TreeNode A, TreeNode B) {
		if (A == null && B == null)
			return true;
		if (A == null || B == null)
			return false;
		return isSame(inOrder(A, B.val), B);
	}

	public TreeNode inOrder(TreeNode root, int val) {
		Stack<TreeNode> stack = new Stack<>();
		while (!stack.isEmpty() || root != null) {
			if (root != null) {
				stack.push(root);
				root = root.left;
			} else {
				root = stack.pop();
				if (root.val == val)
					return root;
				root = root.right;
			}
		}
		return null;
	}

	public boolean isSame(TreeNode A, TreeNode B) {
		if (A == null && B == null)
			return true;
		if (A == null && B != null)
			return false;
		if (A != null && B == null)
			return true;
		if (A.val != B.val)
			return false;
		else {
			return isSame(A.left, B.left) && isSame(A.right, B.right);
		}
	}
}
