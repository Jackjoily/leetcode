package leetcode_tree;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个二叉树，返回它的中序 遍历。
 * 
 * @author jackjoily
 *
 */
public class M_94 {
	public static void main(String[] args) {
		TreeNode roo = new TreeNode(1);
		TreeNode roo1 = new TreeNode(2);
		TreeNode roo2 = new TreeNode(3);
		roo.left = null;
		roo.right = roo1;
		roo1.right = roo2;
		List<Integer> list = inorderTraversal(roo);
		for (Integer integer : list) {
			System.out.println(integer);
		}
	}

	public static List<Integer> inorderTraversal(TreeNode root) {
		TreeNode p = root;
		TreeNode stack[] = new TreeNode[100];
		int tail = -1;
		List<Integer> list = new ArrayList<>();
		while (p != null || tail != -1) {
			if (p != null) {
				stack[++tail] = p;
				p = p.left;
			} else {
				p = stack[tail--];
				list.add(p.val);
				p = p.right;
			}
		}
		return list;
	}
}
