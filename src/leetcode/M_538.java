package leetcode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Queue;

import javafx.scene.shape.Line;
import leetcode_list.ListNode;
import leetcode_tree.TreeNode;
import leetcode_tree.TreeUtils;

/**
 * 
 * @author jackjoily
 *
 */
public class M_538 {
	public static void main(String[] args) {
		M_538 m = new M_538();
		Integer a[] = { 3,3,2};
		TreeNode createBinaryTreeByArray = TreeUtils.createBinaryTreeByArray(a);
		TreeNode.LevelOrder(		m.convertBST(createBinaryTreeByArray));
	}

	List<TreeNode> list = new ArrayList<>();

	public TreeNode convertBST(TreeNode root) {
		if (root == null)
			return root;
		if (root.left == null && root.right == null)
			return root;
		inorder(root);
		int sum = 0;
		TreeNode treeNode = null;
		for (int i = list.size() - 1; i >= 0; i--) {
			treeNode = list.get(i);
			int temp = treeNode.val;
			treeNode.val += sum;
			sum += temp;
		}
		return root;
	}

	public void inorder(TreeNode root) {
		if (root != null) {
			inorder(root.left);
			list.add(root);
			inorder(root.right);
		}
	}
}
