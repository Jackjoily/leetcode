package leetcode_tree;

import java.util.Deque;
import java.util.LinkedList;

public class TreeUtils {
	
	 public static TreeNode createBinaryTreeByArray(Integer[] nums) {
	        if (nums == null || nums.length == 0) {
	            return null;
	        }
	        int len = nums.length;
	        int index = 0;
	        TreeNode head = new TreeNode(nums[index]);
	        Deque<TreeNode> nodeQueue = new LinkedList<>();
	        nodeQueue.offer(head);
	        TreeNode cur;
	        while (index < len) {
	            index++;
	            if (index >= len) {
	                return head;
	            }
	            cur = nodeQueue.poll();
	            Integer left = nums[index];
	            if (left != null) {
	                cur.left = new TreeNode(left);
	                nodeQueue.offer(cur.left);
	            }

	            index++;
	            if (index >= len) {
	                return head;
	            }
	            Integer right = nums[index];
	            if (right != null) {
	                cur.right = new TreeNode(right);
	                nodeQueue.offer(cur.right);
	            }
	        }
	        return head;
	    }

	/**
	 * 建立一颗含有n个节点的完全二叉树
	 * 
	 * @param n
	 * @return
	 */
	public static TreeNode createTree(int n) {
		TreeNode[] t = new TreeNode[n];
		for (int i = 0; i < n; i++) {
			t[i] = new TreeNode(i + 1);
		}
		for (int i = n / 2 - 1; i >= 0; i--) {
			t[i].left = t[2 * i + 1];
			if (i == (n / 2) - 1 && (2 * (i + 1) + 1) != n) {
				t[i].right = null;
			} else {
				t[i].right = t[2 * i + 2];
			}

		}
		return t[0];
	}
}
