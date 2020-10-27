package basic;

import leetcode_tree.TreeNode;

/**
 * 平衡二叉树
 * 
 * @author jackjoily
 *
 */
public class AvlTree {

	private TreeNode node;

	public static void main(String[] args) {
		// 左
		int[] a = { 4, 3, 6, 5, 7, 8 };
		// 右
		int[] b = { 10, 12, 8, 9, 7, 6 };
		// LR
		int[] c = { 10, 11, 7, 6, 8, 9 };
		int[] d = { 1, 2, 3, 4, 5, 6 };
		TreeNode node = create(d);
		System.out.println(node.height());
		System.out.println(node.leftHeight());
		System.out.println(node.rightHeight());
	}

	public static int height(TreeNode root) {
		if (root == null) {
			return 0;
		} else {
			return Math.max(height(root.left), height(root.right)) + 1;
		}
	}

	// 创建一颗二叉排序树
	public static TreeNode create(int[] a) {
		TreeNode root = new TreeNode(a[0]);
		for (int i = 1; i < a.length; i++) {
			insert(root, a[i]);
		}
		return root;
	}

	public static void insert(TreeNode root, int data) {
		if (data > root.val) {
			if (root.right == null) {
				root.right = new TreeNode(data);
			} else {
				insert(root.right, data);
			}

		} else {
			if (root.left == null)
				root.left = new TreeNode(data);
			else
				insert(root.left, data);
		}
		// 当添加完一个节点后，发生右子树不平衡
		if (root.rightHeight() - root.leftHeight() > 1) {
			// 如果它的右子树的左子树的高度大于它的右子树的右子树的高度
			// 先进行右旋转
			if (root.right != null && root.right.leftHeight() > root.right.rightHeight()) {
				leftRotate(root.right);
				rightRotate(root);
			} else {
				leftRotate(root);
			}

			return;
		}
		// 左子树的高度大于右子树的高度的时候，进行右旋转
		if (root.leftHeight() - root.rightHeight() > 1) {
			if (root.left != null && root.left.rightHeight() > root.left.leftHeight()) {
				leftRotate(root.left);
				rightRotate(root);
			} else {
				rightRotate(root);
			}
		}
		return;
	}

	private static void leftRotate(TreeNode node) {
		// 创建一个新的节点
		TreeNode newNode = new TreeNode(node.val);
		// 把新的节点的左子树设置成当前节点的左子树
		newNode.left = node.left;
		// 把新的节点的右子树设置成当前节点的右子树的左子树
		newNode.right = node.right.left;
		// 把当前节点的值替换成右子节点的值
		node.val = node.right.val;
		// 把当前节点的右子树设置成为当前节点右子树的右子树
		node.right = node.right.right;
		// 把当前节点的左子树设置成新的节点
		node.left = newNode;
	}

	private static void rightRotate(TreeNode node) {
		// 创建一个新的节点
		TreeNode newNode = new TreeNode(node.val);
		// 把新的节点的左子树设置成当前节点的左子树
		newNode.right = node.right;
		// 把新的节点的右子树设置成当前节点的右子树的左子树
		newNode.left = node.left.right;
		// 把当前节点的值替换成右子节点的值
		node.val = node.left.val;
		// 把当前节点的右子树设置成为当前节点右子树的右子树
		node.left = node.left.left;
		// 把当前节点的左子树设置成新的节点
		node.right = newNode;
	}

}
