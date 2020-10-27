package leetcode_tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * 给定一个二叉树和一个目标和，找到所有从根节点到叶子节点路径总和等于给定目标和的路径。
 * 
 * @author jackjoily
 *
 */
public class M_113 {
	public static void main(String[] args) {
		TreeNode n51 = new TreeNode(5);
		TreeNode n52 = new TreeNode(5);
		TreeNode n41 = new TreeNode(4);
		TreeNode n42 = new TreeNode(4);
		TreeNode n8 = new TreeNode(8);
		TreeNode n11 = new TreeNode(11);
		TreeNode n7 = new TreeNode(7);
		TreeNode n2 = new TreeNode(2);
		TreeNode n13 = new TreeNode(13);
		TreeNode n1 = new TreeNode(1);
		n51.left = n41;
		n51.right = n8;
		n41.left = n11;
		n11.left = n7;
		n11.right = n2;
		n8.left = n13;
		n8.right = n42;
		n42.left = n52;
		n42.right = n1;
		System.out.println(pathSum(n51, 22));
	}

	List<List<Integer>> list1 = new ArrayList<>();

	public void preOrder(TreeNode root, int sum, LinkedList<Integer> list) {
		if (root != null) {
			list.add(root.val);
			sum = sum - root.val;
			if (root.left == null && root.right == null && sum == 0) {
				System.out.println(list);
				list1.add(new ArrayList<>(list));
			}
			preOrder(root.left, sum, list);
			preOrder(root.right, sum, list);
			list.removeLast();
		}
	}

	public static List<List<Integer>> pathSum(TreeNode root, int sum) {
		List<List<Integer>> list = new ArrayList<>();
		Stack<TreeNode> stack = new Stack<TreeNode>();
		TreeNode pre = null;
		TreeNode q = root;
		while (q != null || !stack.isEmpty()) {
			if (q != null) {
				stack.push(q);
				q = q.left;
			} else {
				q = stack.peek();
				if (q.right != null && q.right != pre) {
					q = q.right;
					stack.push(q);
					q = q.left;
				} else {
					q = stack.pop();

					if (q.left == null && q.right == null) {
						int res = q.val;
						for (int i = 0; i < stack.size(); i++) {
							res += stack.get(i).val;
						}
						if (res == sum) {
							List<Integer> list1 = new ArrayList<>();
							for (int i = 0; i < stack.size(); i++) {
								list1.add(stack.get(i).val);
							}
							list1.add(q.val);
							list.add(list1);
						}
					}
					pre = q;
					q = null;
				}
			}
		}

		return list;
	}

	public static void posrOrder(TreeNode root, int sum) {
		List<List<Integer>> list = new ArrayList<>();
		Stack<TreeNode> stack = new Stack<TreeNode>();
		TreeNode pre = null;
		TreeNode q = root;
		while (q != null || !stack.isEmpty()) {
			if (q != null) {
				stack.push(q);
				q = q.left;
			} else {
				q = stack.peek();
				if (q.right != null && q.right != pre) {
					q = q.right;
					stack.push(q);
					q = q.left;
				} else {
					q = stack.pop();
					System.out.println(q.val);
					pre = q;
					q = null;
				}

			}
		}
	}
}
