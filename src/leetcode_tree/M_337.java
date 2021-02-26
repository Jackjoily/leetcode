package leetcode_tree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

/**
 * 在上次打劫完一条街道之后和一圈房屋后，小偷又发现了一个新的可行窃的地区。 这个地区只有一个入口，我们称之为“根”。
 * 除了“根”之外，每栋房子有且只有一个“父“房子与之相连。 一番侦察之后，聪明的小偷意识到“这个地方的所有房屋的排列类似于一棵二叉树”。
 * 如果两个直接相连的房子在同一天晚上被打劫，房屋将自动报警。 计算在不触动警报的情况下，小偷一晚能够盗取的最高金额。
 * 
 * @author jackjoily
 *
 */
public class M_337 {
	Map<TreeNode, Integer> f = new HashMap<TreeNode, Integer>();
	Map<TreeNode, Integer> g = new HashMap<TreeNode, Integer>();

	/**
	 * o的左右孩子都不能被选中 当o选中的时候，o的左右孩子都不能被选中 f(o) = g(l) + g(r)
	 * 当o不被选中的时候g(o)=max{f(l),g(l)}+max{f(r),g(r)}
	 * 
	 * @param node
	 */
	public void dfs(TreeNode node) {
		if (node == null) {
			return;
		}
		dfs(node.left);
		dfs(node.right);
		f.put(node, node.val + g.getOrDefault(node.left, 0) + g.getOrDefault(node.right, 0));
		g.put(node, Math.max(f.getOrDefault(node.left, 0), g.getOrDefault(node.left, 0))
				+ Math.max(f.getOrDefault(node.right, 0), g.getOrDefault(node.right, 0)));
	}

	public int rob(TreeNode root) {
		Info process = process(root);
		return Math.max(process.selected, process.unselected);
	}

	public static class Info {
		int selected;
		int unselected;

		public Info(int selected, int unselected) {
			this.selected = selected;
			this.unselected = unselected;
		}
	}

	public Info process(TreeNode root) {
		if (root == null) {
			return new Info(0, 0);
		}
		Info leftInfo = process(root.left);
		Info rightInfo = process(root.right);
		int selected = leftInfo.unselected + rightInfo.unselected + root.val;
		int unselected = Math.max(leftInfo.selected, leftInfo.unselected)
				+ Math.max(rightInfo.selected, rightInfo.unselected);
		return new Info(selected, unselected);
	}

}
