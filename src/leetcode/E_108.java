package leetcode;

import java.util.Arrays;
import java.util.HashMap;

import com.sun.org.apache.xerces.internal.util.SynchronizedSymbolTable;

import leetcode_tree.TreeNode;

/**
 * twosum
 * 
 * @author jackjoily
 *
 */
public class E_108 {
	public static void main(String[] args) {

	}

	public TreeNode sortedArrayToBST(int[] nums) {
		int n = nums.length;
		if (n == 0)
			return null;
		if (n == 1) {
			return new TreeNode(nums[0]);
		}
		return createTreeNode(nums, 0, n - 1);
	}

	public TreeNode createTreeNode(int nums[], int left, int right) {
		if (left > right)
			return null;
		int mid = (left + right) / 2;
		TreeNode root = new TreeNode(nums[mid]);
		root.left = createTreeNode(nums, left, mid - 1);
		root.right = createTreeNode(nums, mid + 1, right);
		return root;
	}
}
