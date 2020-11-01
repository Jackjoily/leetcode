package JianZhiOffer;

import java.util.ArrayList;
import java.util.List;

import edu.princeton.cs.algs4.Stack;
import leetcode_tree.TreeNode;

/**
 * 
 * 给定一棵二叉搜索树，请找出其中第k大的节点。
 * 
 * 
 * @author jackjoily
 *
 */
public class JianZhiOffer54 {
	public static void main(String[] args) {
		JianZhiOffer54 j = new JianZhiOffer54();
		TreeNode n1 = new TreeNode(1);
		TreeNode n2 = new TreeNode(2);
		TreeNode n3 = new TreeNode(3);
		TreeNode n4 = new TreeNode(4);
		n3.left = n1;
		n1.right = n2;
		n3.right = n4;
		j.inOrder1(n3);
	}

	public int kthLargest(TreeNode root, int k) {
		if (root == null)
			return 0;
		inOrder(root);
		return list.get(list.size() - k);
	}

	List<Integer> list = new ArrayList<>();

	public void inOrder(TreeNode root) {
		Stack<TreeNode> stack = new Stack<>();
		while (!stack.isEmpty() || root != null) {
			if (root != null) {
				stack.push(root);
				root = root.left;
			} else {
				root = stack.pop();
				list.add(root.val);
				root = root.right;
			}
		}
	}

	int k = 1;
	int res = 0;

	public void inOrder1(TreeNode root) {
		if (root != null) {
			inOrder1(root.right);
			if (k == 0)
				return;
			if (--k == 0)
				res = root.val;
			System.out.println(res);
			inOrder1(root.left);
		}
	}
}
