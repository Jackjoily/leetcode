package leetcode_tree;

import java.util.LinkedList;
import java.util.Queue;

public class TreeNode {
	public int val;
	public TreeNode left;
	public TreeNode right;

	public TreeNode(int x) {
		this.val = x;
	}

	public int leftHeight() {
		if (left == null) {
			return 0;
		}
		return left.height();
	}

	public int rightHeight() {
		if (right == null) {
			return 0;
		}
		return right.height();
	}

	// 返回以该节点为根节点树的高度
	public int height() {
		return Math.max(left == null ? 0 : left.height(), right == null ? 0 : right.height()) + 1;
	}

	@Override
	public String toString() {
		return "TreeNode [val=" + val + "]";
	}

	public static void InOrder(TreeNode node) {
		if (node != null) {
			InOrder(node.left);
			System.out.println(node);
			InOrder(node.right);
		}

	}

	public static void LevelOrder(TreeNode TreeNode) {
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		if (TreeNode != null) {
			queue.add(TreeNode);
		}
		while (!queue.isEmpty()) {
			TreeNode p = queue.poll();
			System.out.println(p.val);
			if (p.left != null) {
				queue.add(p.left);
			}
			if (p.right != null) {
				queue.add(p.right);
			}
		}
	}
}


