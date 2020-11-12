package JianZhiOffer;

import java.util.HashMap;
import java.util.Map;

import leetcode_tree.TreeNode;

/**
 * 请实现一个函数，用来判断一棵二叉树是不是对称的。 请实现一个函数，用来判断一棵二叉树是不是对称的。如果一棵二叉树和它的镜像一样，那么它是对称的。
 * 
 * 例如，二叉树 [1,2,2,3,4,4,3] 是对称的。请实现一个函数，用来判断一棵二叉树是不是对称的。如果一棵二叉树和它的镜像一样，那么它是对称的。
 * 
 * 例如，二叉树 [1,2,2,3,4,4,3] 是对称的。如果一棵二叉树和它的镜像一样，那么它是对称的。
 * 
 * 例如，二叉树 [1,2,2,3,4,4,3] 是对称的。
 * 
 * @author jackjoily
 *
 */
public class JianZhiOffer28 {
	public static void main(String[] args) {

	}

	boolean flag = true;

	public boolean isSymmetric(TreeNode root) {
		if (root == null)
			return true;
		f(root.left, root.right);
		return flag;
	}

	public void f(TreeNode left, TreeNode right) {
		if (left != null && right != null) {
			if (left.val != right.val) {
				flag = false;
				return;
			} else {
				f(left.right, right.left);
				f(left.left, right.right);
			}
		} else if (left == null && right == null) {
		} else {
			flag = false;
		}
	}
}
