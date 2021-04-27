package leetcode;

import java.util.ArrayList;
import java.util.List;

import leetcode_tree.TreeNode;
import leetcode_tree.TreeUtils;

/**
 * twosum
 * 
 * @author jackjoily
 *
 */
public class E_257 {
	public static void main(String[] args) {
		E_257 e = new E_257();
		TreeNode createTree = TreeUtils.createTree(7);
		StringBuilder sb = new StringBuilder();
		e.f(createTree, "");
	}

	List<String> list = new ArrayList<>();

	public List<String> binaryTreePaths(TreeNode root) {
		return list;
	}

	public void f(TreeNode root, String sb) {
		if (root != null) {
			if (root.left == null && root.right == null) {
				list.add(sb+root.val);
				System.out.println(sb+root.val);
				return;
			} else {
				f(root.left, sb+root.val+"->");
				f(root.right, sb+root.val+"->");
			}
		}
	}

}
