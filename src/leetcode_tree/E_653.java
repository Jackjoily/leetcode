package leetcode_tree;

import java.util.HashSet;
import java.util.Set;

public class E_653 {
	boolean flag = false;
	TreeNode root = null;

	public boolean findTarget(TreeNode root, int k) {
		if (root == null) {
			return false;
		} else {
			this.root = root;
			dfs(root, k);
			return flag;
		}
	}

	public void dfs(TreeNode node, int k) {
		if (node != null) {
			find(root, node, k);
			dfs(node.left, k);
			dfs(node.right, k);
		}
	}

	public void find(TreeNode node, TreeNode pre, int k) {
		if (node != null) {
			if (node != pre && (node.val + pre.val) == k) {
				flag = true;
				return;
			} else {
				find(node.left, pre, k);
				find(node.right, pre, k);
			}
		}
	}
	
	
	 public boolean findTarget1(TreeNode root, int k) {
	        Set < Integer > set = new HashSet();
	        return find(root, k, set);
	    }
	    public boolean find(TreeNode root, int k, Set < Integer > set) {
	        if (root == null)
	            return false;
	        if (set.contains(k - root.val))
	            return true;
	        set.add(root.val);
	        return find(root.left, k, set) || find(root.right, k, set);
	    }

	
	
}
