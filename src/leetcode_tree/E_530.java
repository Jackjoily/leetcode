package leetcode_tree;

import java.util.ArrayList;
import java.util.List;

/**
 * 二叉搜索树的最小绝对差
 * 
 * @author jackjoily
 *
 */
public class E_530 {
	List<Integer> list = new ArrayList<>();

	public int getMinimumDifference(TreeNode root) {
		dfs(root);
		int min = Integer.MAX_VALUE;
		for (int i = 0; i < list.size() - 1; i++) {
			int res = list.get(i + 1) - list.get(i);
			if (min > res) {
				min = res;
			}
		}
		return min;
	}

	public void dfs(TreeNode root) {
		if (root != null) {
			dfs(root.left);
			list.add(root.val);
			dfs(root.right);
		}
	}

}
