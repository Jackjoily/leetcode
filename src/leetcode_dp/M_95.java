package leetcode_dp;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import leetcode_tree.TreeNode;

/**
 * 给定一个整数 n，生成所有由 1 ... n 为节点所组成的 二叉搜索树 。
 * 
 * @author jackjoily
 *
 */
public class M_95 {

	public List<TreeNode> generateTrees(int n) {
		if (n == 0) {
			return new ArrayList<TreeNode>();
		}
		return generateTrees(1, n);
	}

	public List<TreeNode> generateTrees(int start, int end) {
		List<TreeNode> list = new ArrayList<>();
		if (start > end) {
			list.add(null);
			return list;
		}
		if (start == end) {
			list.add(new TreeNode(start));
			return list;
		}
		for (int i = 1; i <= end; i++) {
			List<TreeNode> left = generateTrees(start, i - 1);
			List<TreeNode> right = generateTrees(i + 1, end);
			for (TreeNode l : left) {
				for (TreeNode r : right) {
					TreeNode node = new TreeNode(i);
					node.left = l;
					node.right = r;
					list.add(node);
				}
			}
		}
		return list;
	}

}
