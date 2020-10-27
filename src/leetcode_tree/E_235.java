package leetcode_tree;

/**
 * 给定一个二叉搜索树, 找到该树中两个指定节点的最近公共祖先。
 * 
 * @author jackjoily
 *
 */
public class E_235 {
	/**
	 * 使用递归的算法更加简洁明了
	 * @param root
	 * @param p
	 * @param q
	 * @return
	 */
	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
		// Value of current node or parent node.
		int parentVal = root.val;
		// Value of p
		int pVal = p.val;
		// Value of q;
		int qVal = q.val;
		if (pVal > parentVal && qVal > parentVal) {
			// If both p and q are greater than parent
			return lowestCommonAncestor(root.right, p, q);
		} else if (pVal < parentVal && qVal < parentVal) {
			// If both p and q are lesser than parent
			return lowestCommonAncestor(root.left, p, q);
		} else {
			// We have found the split point, i.e. the LCA node.
			return root;
		}
	}
}
