package leetcode_wx;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import leetcode_list.ListNode;
import leetcode_tree.TreeNode;
import leetcode_tree.TreeUtils;

public class M_113II {

	public static void main(String[] args) {
		M_113II m = new M_113II();
		TreeNode create = TreeUtils.createTree(7);
		m.f(create, 11, new LinkedList<Integer>());
	}

	List<List<Integer>> list1 = new ArrayList<>();

	public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
		if (root == null)
			return list1;
		f(root, targetSum, new LinkedList<Integer>());
		return list1;
	}

	public void f(TreeNode root, int val, LinkedList<Integer> list) {
		if (root != null) {
			int i = val - root.val;
			if (i != 0) {
				list.add(root.val);
				f(root.left, i, list);
				f(root.right, i, list);
				list.removeLast();
			} else if (i == 0) {
				if (root.left == null && root.right == null) {
					list.add(root.val);
					list1.add(new ArrayList<>(list));
					list.removeLast();
					return;
				} else {
					list.removeLast();
					return;
				}
			}
		}

	}
}
