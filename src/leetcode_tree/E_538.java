package leetcode_tree;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个二叉搜索树（Binary Search Tree），把它转换成为累加树（Greater
 * Tree)，使得每个节点的值是原来的节点值加上所有大于它的节点值之和。
 * 
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/convert-bst-to-greater-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * 
 * @author jackjoily
 *
 */
public class E_538 {
	public static void main(String[] args) {
		TreeNode n2 = new TreeNode(2);
		TreeNode n1 = new TreeNode(1);
		TreeNode n3 = new TreeNode(3);
		n2.left = n1;
		n2.right = n3;
		E_538 e = new E_538();
		TreeNode n = e.convertBST(n2);
		System.out.println(n);
	}

	List<Integer> list = new ArrayList<>();
	int res = 0;
	int i;

	public TreeNode convertBST(TreeNode root) {
		dfs(root);
		i = list.size()-2;
		dfs1(root);
		return root;
	}

	public void dfs1(TreeNode root) {
		if (root != null) {
			dfs1(root.left);
			if (i >=0) {
				root.val = root.val + list.get(i);
				i--;
			}
			dfs1(root.right);
		}

	}

	public void dfs(TreeNode root) {
		if (root != null) {
			dfs(root.right);
			res += root.val;
			list.add(res);
			dfs(root.left);
		}
	}
}
