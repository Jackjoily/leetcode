package leetcode_tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 给你一个二叉树，请你返回其按 层序遍历 得到的节点值。 （即逐层地，从左到右访问所有节点）。
 * 
 * @author jackjoily
 *
 */
public class M_102 {
	public static void main(String[] args) {
		TreeNode root = new TreeNode(3);
		TreeNode root9 = new TreeNode(9);
		TreeNode root20 = new TreeNode(20);
		TreeNode root15 = new TreeNode(15);
		TreeNode root7 = new TreeNode(7);
		root.left = root9;
		root.right = root20;
		root20.left = root15;
		root20.right = root7;
		List<List<Integer>> a = levelOrder(root);
		System.out.println();
	}

	public static List<List<Integer>> levelOrder(TreeNode root) {
		List<List<Integer>> list1 = new ArrayList<>();
		if (root == null)
			return list1;
		Queue<TreeNode> queue = new LinkedList<>();
		int front = -1, rear = -1;
		int last = 0;
		TreeNode p = root;
		queue.add(p);
		++rear;
		List<Integer> list = new ArrayList<>();
		while (front < rear) {
			p = queue.poll();
			++front;
			if (p.left != null) {
				queue.add(p.left);
				++rear;
			}
			if (p.right != null) {
				queue.add(p.right);
				++rear;
			}
			list.add(p.val);
			if (front == last) {
				last = rear;
				list1.add(list);
				list = new ArrayList<>();
			}
		}
		return list1;
	}
//	
//	List<List<Integer>> list1 = new ArrayList<>();
//	if (root == null)
//		return list1;
//	TreeNode queue[] = new TreeNode[300];
//	int front = -1, rear = -1;
//	int last = 0;
//	TreeNode p = root;
//	queue[++rear] = p;
//	List<Integer> list = new ArrayList<>();
//	while (front < rear) {
//		p = queue[++front];
//		if (p.left != null) {
//			queue[++rear] = p.left;
//		}
//		if (p.right != null) {
//			queue[++rear] = p.right;
//		}
//		list.add(p.val);
//		if (front == last) {
//			last = rear;
//			list1.add(list);
//			list=new ArrayList<>();
//		}
//	}
//	return list1;
}
