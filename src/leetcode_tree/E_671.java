package leetcode_tree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class E_671 {
	List<Integer> list = new ArrayList<>();
	HashSet<Integer> set = new HashSet<>();

	public int findSecondMinimumValue(TreeNode root) {
		findMin(root);
		set.addAll(list);
		list = new ArrayList<Integer>();
		list.addAll(set);
		if (list.size() < 2) {
			return -1;
		} else {
			Collections.sort(list);
			return list.get(1);
		}
	}

	public void findMin(TreeNode node) {
		if (node != null) {
			list.add(node.val);
			if (node.left != null) {
				findMin(node.left);
				findMin(node.right);
			}
		}

	}
}
