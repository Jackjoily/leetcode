package leetcode_tree;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个二叉树，原地将它展开为一个单链表。
 * 
 * @author jackjoily
 *
 */
public class M_114 {
	private List<TreeNode> list = new ArrayList<>();

	public void flatten(TreeNode root) {
		if (root == null) {
			return ;
		}
		dfs(root);
		for (int i = 0; i + 1 < list.size(); i++) {
			list.get(i).left = null;
			list.get(i).right = list.get(i + 1);
		}
		list.get(list.size() - 1).left = null;
		list.get(list.size() - 1).right = null;
	}

	public void dfs(TreeNode root) {
		if (root != null) {
			list.add(root);
			dfs(root.left);
			dfs(root.right);
		}
	}
}
