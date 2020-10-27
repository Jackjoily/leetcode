package leetcode_tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 给定一个二叉树，检查它是否是镜像对称的。
 * 
 * @author jackjoily
 *
 */
public class E_101 {
	public static void main(String[] args) {
		TreeNode n1 = new TreeNode(1);
		TreeNode n21 = new TreeNode(2);
		TreeNode n22 = new TreeNode(2);
		TreeNode n31 = new TreeNode(3);
		TreeNode n41 = new TreeNode(4);
		TreeNode n42 = new TreeNode(4);
		TreeNode n32 = new TreeNode(3);
		TreeNode n51 = new TreeNode(5);
		TreeNode n52 = new TreeNode(5);
		n21.left = n31;
		n21.right = n32;
		n31.left = n41;
		n31.right = n51;
		n32.right = n42;
//		n1.left = n21;
//		n1.right = n22;
//		n21.left = n31;
//		n21.right = n41;
//		n22.left = n42;
//		n22.right = n32;
		System.out.println(isSymmetric1(n21));
	}

	/**
	 * 非递归写法
	 * 
	 * @param root
	 * @return
	 */
	public static boolean isSymmetric(TreeNode root) {
		Queue<TreeNode> q1 = new LinkedList<TreeNode>();
		Queue<TreeNode> q2 = new LinkedList<TreeNode>();
		if (root == null) {
			return true;
		}
		if (root != null && root.left == null && root.right == null) {
			return true;
		} else if (root.left != null && root.right != null) {
			TreeNode p = root.left;
			TreeNode q = root.right;
			if (p.val == q.val) {
				q1.add(p);
				q2.add(q);
				while (!q1.isEmpty() && !q2.isEmpty()) {
					p = q1.poll();
					q = q2.poll();
					if (p.left != null && q.right != null) {
						if (p.left.val == q.right.val) {
							q1.add(p.left);
							q2.add(q.right);
						} else {
							return false;
						}
					}
					if (p.right != null && q.left != null) {
						if (p.right.val == q.left.val) {
							q1.add(p.right);
							q2.add(q.left);
						} else {
							return false;
						}
					}
					if ((p.left != null && q.right == null) || (p.left == null && q.right != null)
							|| (p.right != null && q.left == null) || (p.right == null && q.left != null)) {
						return false;
					}
				}
				return true;
			} else {
				return false;
			}
		} else {
			return false;
		}
	}

	/**
	 * 递归写法
	 * 
	 * @param root
	 * @return
	 */
	public static boolean isSymmetric1(TreeNode root) {
		if (root == null)
			return true;
		return isSame(root.left, root.right);
	}

	public static boolean isSame(TreeNode p, TreeNode q) {
		if (p == null && q == null) {
			return true;
		}
		if (p == null || q == null) {
			return false;
		}
		if (p.val == q.val) {
			return isSame(p.left, q.right) && isSame(p.right, q.left);
		}
		return false;
	}

}
