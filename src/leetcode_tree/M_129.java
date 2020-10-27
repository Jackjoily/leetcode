package leetcode_tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 给定一个二叉树，它的每个结点都存放一个 0-9 的数字，每条从根到叶子节点的路径都代表一个数字。 例如，从根到叶子节点路径 1->2->3 代表数字
 * 123。 计算从根到叶子节点生成的所有数字之和。
 */
public class M_129 {
	public static void main(String[] args) {
		TreeNode node = TreeUtils.createTree(7);
		System.out.println(sumNumbers(node));
	}

	public static int sumNumbers(TreeNode root) {
		int sum = 0;
		List<Integer> list = new ArrayList<>();
		if (root == null) {
			return sum;
		}
		TreeNode pre = null;
		Stack<TreeNode> s = new Stack<>();
		while (root != null || !s.isEmpty()) {
			if (root != null) {
				s.push(root);
				root = root.left;
			} else {
				root = s.peek();
				if (root.right != null && root.right != pre) {
					root = root.right;
					s.push(root);
					root = root.left;
				} else {
					root = s.pop();
					if (root.left == null && root.right == null) {
						StringBuilder sb = new StringBuilder();
						for (int i = 0; i < s.size(); i++) {
							sb.append(s.get(i).val);
						}
						sb.append(root.val);
						sum += Integer.valueOf(sb.toString());
					}
					pre = root;
					root = null;
				}

			}

		}
		return sum;
	}
}
