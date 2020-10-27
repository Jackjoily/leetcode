package leetcode_tree;

import java.util.HashMap;
import java.util.Map;

/**
 * 给定一个不含重复元素的整数数组。一个以此数组构建的最大二叉树定义如下：
 * 
 * 二叉树的根是数组中的最大元素。 左子树是通过数组中最大值左边部分构造出的最大二叉树。 右子树是通过数组中最大值右边部分构造出的最大二叉树。
 * 通过给定的数组构建最大二叉树，并且输出这个树的根节点。
 * 
 * @author jackjoily
 *
 */
public class E_654 {
	public static void main(String[] args) {
		int a[] = { 3, 2, 1, 6, 0, 5 };
		TreeNode constructMaximumBinaryTree = constructMaximumBinaryTree(a);
		System.out.println();
	}

	static Map<Integer, Integer> map = new HashMap<>();

	public static TreeNode constructMaximumBinaryTree(int[] nums) {
		if (nums == null) {
			return null;
		}
		for (int i = 0; i < nums.length; i++) {
			map.put(nums[i], i);
		}
		return createNode(nums, 0, nums.length - 1);
	}

	public static TreeNode createNode(int nums[], int low, int high) {
		if (nums != null && low <= high) {
			int max = findMax(nums, low, high);
			int k = map.get(max);
			TreeNode node = new TreeNode(max);
			node.left = createNode(nums, low, k - 1);
			node.right = createNode(nums, k + 1, high);
			return node;
		} else {
			return null;
		}
	}

	public static int findMax(int nums[], int low, int high) {
		int max = Integer.MIN_VALUE;
		for (int i = low; i <= high; i++) {
			if (max < nums[i])
				max = nums[i];
		}
		return max;
	}

}
