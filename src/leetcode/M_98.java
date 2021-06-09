package leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

import leetcode_list.ListNode;
import leetcode_tree.TreeNode;
import leetcode_tree.TreeUtils;
import sun.nio.cs.ext.ISCII91;

/**
 * 
 * @author jackjoily
 *
 */
public class M_98 {
	public static void main(String[] args) {
		M_98 m = new M_98();
		TreeNode n1 = new TreeNode(1);
		TreeNode n2 = new TreeNode(2);
		TreeNode n3 = new TreeNode(3);
		TreeNode n4 = new TreeNode(4);
		TreeNode n5 = new TreeNode(5);
		n2.left = n1;
		n2.right = n3;
		// n3.left = n2;
		// n2.left = n1;
		// n3.right = n5;
		// n5.left = n4;
		TreeNode createTree = TreeUtils.createTree(7);
		System.out.println(m.isValidBST(n2));
	}

	public boolean isValidBST(TreeNode root) {
        return isValidBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    public boolean isValidBST(TreeNode node, long lower, long upper) {
        if (node == null) {
            return true;
        }
        if (node.val <= lower || node.val >= upper) {
            return false;
        }
        return isValidBST(node.left, lower, node.val) && isValidBST(node.right, node.val, upper);
    }
    }

