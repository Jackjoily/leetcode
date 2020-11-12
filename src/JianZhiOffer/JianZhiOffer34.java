package JianZhiOffer;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

import leetcode_tree.TreeNode;
import leetcode_tree.TreeUtils;

/**
 * 
 * 输入一棵二叉树和一个整数，打印出二叉树中节点值的和为输入整数的所有路径。 从树的根节点开始往下一直到叶节点所经过的节点形成一条路径。
 * 
 * @author jackjoily
 *
 */
public class JianZhiOffer34 {
	public static void main(String[] args) {
		// TreeNode createTree = TreeUtils.createTree(7);
		TreeNode n1 = new TreeNode(1);
		TreeNode n2 = new TreeNode(1);
		TreeNode n3 = new TreeNode(1);
		n1.left = n2;
		n1.right = n3;
		JianZhiOffer34 j = new JianZhiOffer34();
		LinkedList<Integer> list = new LinkedList<>();
		j.dfs(n1, 2, list);
		System.out.println(j.list2);
	}

	List<List<Integer>> list2 = new ArrayList<>();

	public List<List<Integer>> pathSum(TreeNode root, int sum) {
		if (root == null)
			return list2;
		return list2;
	}

	public void dfs(TreeNode root, int sum, LinkedList<Integer> list) {
		if (root != null) {
			list.add(root.val);
			sum = sum - root.val;
			if (root.left == null && root.right == null) {
				if (sum == 0) {
					LinkedList<Integer> list1 = new LinkedList<>(list);
					list2.add(list1);
				}
				list.removeLast();
			} else {
				dfs(root.left, sum, list);
				dfs(root.right, sum, list);
				list.removeLast();
			}
		}
	}
}
