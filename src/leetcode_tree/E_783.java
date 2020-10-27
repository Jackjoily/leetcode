package leetcode_tree;

import java.util.ArrayList;
import java.util.List;

public class E_783 {
	List<Integer> list = new ArrayList<>();
	int min = Integer.MAX_VALUE;

	public int minDiffInBST(TreeNode root) {
		inOrder(root);
		for (int i = 0; i < list.size() - 1; i++) {
			if (min > list.get(i + 1) - list.get(i)) {
				min = list.get(i + 1) - list.get(i);
			}
		}
		return min;
	}

	public void inOrder(TreeNode root) {
		if (root != null) {
			inOrder(root.left);
			list.add(root.val);
			inOrder(root.right);
		}

	}
}
