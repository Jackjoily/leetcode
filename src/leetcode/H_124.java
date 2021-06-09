package leetcode;

import java.util.Arrays;
import java.util.HashMap;

import leetcode_tree.TreeNode;

/**
 * twosum
 * 
 * @author jackjoily
 *
 */
public class H_124 {
	public static void main(String[] args) {
	}

	int maxSum = Integer.MIN_VALUE;

	public int maxPathSum(TreeNode root) {
		if (root == null)
			return 0;
		maxGain(root);
		return maxSum;
	}

	public int maxGain(TreeNode root) {
		if (root == null)
			return 0;
		int leftGain = Math.max(maxGain(root.left), 0);
		int rightGain = Math.max(maxGain(root.right), 0);
		// 节点的最大路径和取决于该节点的值与该节点的左右子节点的最大贡献值
		int priceNewpath = root.val + leftGain + rightGain;
		maxSum = Math.max(maxSum, priceNewpath);
		// 返回节点的最大贡献值
		return root.val + Math.max(leftGain, rightGain);
	}
}
