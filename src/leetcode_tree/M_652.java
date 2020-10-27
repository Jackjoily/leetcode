package leetcode_tree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class M_652 {
	/**
	 * 给定一棵二叉树，返回所有重复的子树。对于同一类的重复子树，你只需要返回其中任意一棵的根结点即可。
	 * 
	 * 两棵树重复是指它们具有相同的结构以及相同的结点值。
	 * 
	 * 
	 * 通过序列化来做
	 * 
	 * @param args
	 */

	public static void main(String[] args) {
		TreeNode n1 = new TreeNode(1);
		TreeNode n2 = new TreeNode(2);
		TreeNode n21 = new TreeNode(2);
		TreeNode n3 = new TreeNode(3);
		TreeNode n4 = new TreeNode(4);
		TreeNode n41 = new TreeNode(4);
		TreeNode n42 = new TreeNode(4);
		n1.left = n2;
		n1.right = n3;
		n2.left = n4;
		n3.left = n21;
		n3.right = n41;
		n21.left = n42;
		System.out.println(findDuplicateSubtrees(n1));
	}

	static Map<String, Integer> map = new HashMap<>();
	static List<TreeNode> list = new ArrayList<>();

	public static List<TreeNode> findDuplicateSubtrees(TreeNode root) {
		if (root == null) {
			return list;
		} else {
			collect(root);
			return list;
		}

	}

	public static String collect(TreeNode root) {
		if (root == null)
			return "#";
		String str = root.val + "," + collect(root.left) + "," + collect(root.right);
		map.put(str, map.getOrDefault(str, 0) + 1);
		if (map.get(str) == 2) {
			list.add(root);
		}
		return str;

	}
}
