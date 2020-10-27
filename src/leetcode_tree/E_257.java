package leetcode_tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * 给定一个二叉树，返回所有从根节点到叶子节点的路径。
 * 
 * @author jackjoily
 *
 */
public class E_257 {
	public static void main(String[] args) {
		TreeNode createTree = TreeUtils.createTree(7);
		System.out.println(binaryTreePaths1(createTree));
	}

	public static List<String> binaryTreePaths(TreeNode root) {
		LinkedList<String> paths = new LinkedList();
		construct_paths(root, "", paths);
		return paths;
	}

	public static void construct_paths(TreeNode root, String str, LinkedList<String> paths) {
		if (root != null) {
			str += root.val + "";
			if (root.left == null && root.right == null) {
				paths.add(str);
			} else {
				str += "->";
				construct_paths(root.left, str, paths);
				construct_paths(root.right, str, paths);
			}
		}

	}

	static List<String> list = new ArrayList<>();

	public static List<String> binaryTreePaths1(TreeNode root) {
		if (root == null) {
			return list;
		} else {
			Stack<TreeNode> S = new Stack<TreeNode>();
			TreeNode pre = null;
			while (root != null || !S.isEmpty()) {
				if (root != null) {
					S.push(root);
					root = root.left;
				} else {
					root = S.peek();
					if (root.right != null && root.right != pre) {
						root = root.right;
						S.push(root);
						root = root.left;
					} else {
						root = S.pop();
						if (root.left == null && root.right == null) {
							StringBuilder sb = new StringBuilder();
							for (int i = 0; i < S.size(); i++) {
								sb.append(S.get(i).val + "->");
							}
							sb.append(root.val);
							list.add(sb.toString());
						}
						pre = root;
						root = null;
					}

				}
			}

		}
		return list;
	}
}
