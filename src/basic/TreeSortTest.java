package basic;

import java.util.Stack;
import leetcode_tree.TreeNode;
import leetcode_tree.TreeUtils;

public class TreeSortTest {
	public static void main(String[] args) {
		TreeNode createTree = TreeUtils.createTree(7);
		postOrder1(createTree);
	}

	public static void postOrder1(TreeNode root) {
		Stack<TreeNode> stack = new Stack<>();
		TreeNode r = null;
		while (!stack.isEmpty() || root != null) {
			if (root != null) {
				stack.add(root);
				root = root.left;
			} else {
				root = stack.peek();
				//该节点的右孩子节点未被访问过
				if (root.right != r && root.right != null) {
					root = root.right;
					stack.add(root);
					root= root.left;
				} else {
					root=stack.pop();
					System.out.println(root.val);
 					r=root;
					root=null;
				}
			}
		}

	}

	public static void preOrder(TreeNode root) {
		Stack<TreeNode> stack = new Stack<TreeNode>();
		while (!stack.isEmpty() || root != null) {
			if (root != null) {
				stack.add(root);
				root = root.left;
			}

		}
	}

	// 根左右 压栈 头左右
	public static void inOrder(TreeNode root) {
		Stack<TreeNode> stack = new Stack<TreeNode>();
		stack.add(root);
		while (!stack.isEmpty()) {
			root = stack.pop();
			System.out.println(root.val);
			if (root.right != null) {
				stack.add(root.right);
			}
			if (root.left != null) {
				stack.add(root.left);
			}
		}
	}

	// 后序遍历
	public static void postOrder(TreeNode root) {
		Stack<TreeNode> stack = new Stack<TreeNode>();
		Stack<TreeNode> s1 = new Stack<TreeNode>();
		stack.add(root);
		while (!stack.isEmpty()) {
			root = stack.pop();
			s1.add(root);
			if (root.left != null) {
				stack.add(root.left);
			}
			if (root.right != null) {
				stack.add(root.right);
			}
		}
		System.out.println(s1);
	}

}
